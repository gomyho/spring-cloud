package vip.qianbai.cloud.service;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.Getter;
import lombok.Setter;


/** 
 * TODO 该类的作用<br/>
 * @date    2016年12月4日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@RestController
@RequestMapping("/v1")
public class HelloService {
	@Autowired
	HystrixService hystrix;
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("it's B");
		try{
			Thread.sleep(100);
		}catch(Exception e){
			
		}
		hystrix.getStores(null);
		return "hello ,this is service HELLO B";
	}
	
	
	
	
}
