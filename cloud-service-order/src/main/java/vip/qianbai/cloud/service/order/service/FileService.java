package vip.qianbai.cloud.service.order.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author xiaofeng
 * @date 2017年8月1日
 */
@Controller
@RequestMapping("/files")
public class FileService {

	@PostMapping
	@ResponseBody
	public String postFile(MultipartFile file,HttpServletRequest request){
		
		return "0k";
	}
	
}
