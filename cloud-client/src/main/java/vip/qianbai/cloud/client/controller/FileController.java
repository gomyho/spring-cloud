package vip.qianbai.cloud.client.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;


/** 
 * @date    2017年6月10日 <br/> 
 * @author   陈小峰
 * @since    JDK 1.8
 */
@RestController
@RequestMapping("/files")
public class FileController {

	private static final String tmpDir="D:/tmp/upload";
	
	@PostMapping
	public Response shardUpload(ShardUpload upload){
		String fileName = upload.name;
		int partIdx = upload.getIndex();
		boolean locked = touchLock(fileName,partIdx);			
		if(!locked){
			return new Response(0,"failed");
		}
		try {
			File partFile = partFile(fileName, partIdx);
			FileOutputStream fos = new FileOutputStream(partFile);
			StreamUtils.copy(upload.getFile().getInputStream(), fos);
			fos.flush();
			fos.close();
			removeLock(fileName,partIdx);			
			System.out.println("remove lock:"+partIdx);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		}
		System.out.println("check and combine:"+partIdx);
		combine(upload.name,upload.getTotalSlice(),partIdx);
		
		return new Response(1,"ok"); 
	}
	private File partFile(String fileName, int partIdx) {
		File partFile = new File(tmpDir,fileName+".part"+partIdx);
		return partFile;
	}
	private File lockFile(String fileName, int sliceIndex) {
		String name = fileName+sliceIndex+".lock";
		File lockFile = new File(tmpDir,name);
		return lockFile;
	}
	private void removeLock(String fileName, int sliceIndex) {
		lockFile(fileName,sliceIndex).delete();
	}
	
	private boolean touchLock(String fileName,int sliceIndex){
		File lockFile = lockFile(fileName,sliceIndex);
		if(!lockFile.exists()){
			try {
				lockFile.createNewFile();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	private boolean combine(String fileName, int totalSlice,int current) {
		for(int i = 1 ; i <= totalSlice; i++){
			if(lockFile(fileName, i).exists()){//看锁是否存在，所有的锁不存在了才能合并
				System.out.println("-----lock exist:"+i);
				return false;
			}
			if(!partFile(fileName, i).exists()){//任意一个分片不存在不能合并
				System.out.println("-----part not exist:"+i);
				return false;
			}
		}
		
		try (FileOutputStream fos = new FileOutputStream(new File(tmpDir,fileName))){
			for(int i = 1 ; i <= totalSlice;i++){
				FileInputStream fis = new FileInputStream(partFile(fileName, i));
				StreamUtils.copy(fis, fos);
				fos.flush();
				fis.close();
			}
			partFile(fileName, current).delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}


	@Data
	@AllArgsConstructor
	static class Response{
		private int code;
		private String message;
	}
	
	@Data
	public static class ShardUpload{
		int index;
		int totalSlice;
		String name;
		MultipartFile file;
	}
}
