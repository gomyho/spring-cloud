package vip.qianbai.cloud.service.order.service;
import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import vip.qianbai.cloud.service.order.repo.UserRepo;


/** 
 * @date    2016年12月4日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Controller
@RequestMapping("/order")
public class OrderService {
	
	@Autowired
	OrderHystrixService hystrix;
	@Autowired
	UserRepo userRepo;
	
	@ResponseBody
	@RequestMapping("/hello/{what}")
	public String hello(@PathVariable("what") String what,HttpServletRequest request){
		String prefix = request.getHeader("Set-Cookie");
		System.out.println(prefix);
		prefix = request.getHeader("Cookie");
		System.out.println(prefix);
		hystrix.getStores(null);
		return "hello ,this is service order "+ what;
	}
	
	@RequestMapping("/report")
	public ResponseEntity<File> orderReport(){
		File f = new File("F:/programer/jd-gui.exe");
		ResponseEntity<File> entity = new ResponseEntity<File>(f, HttpStatus.OK);
		return entity;
	}
	
}
