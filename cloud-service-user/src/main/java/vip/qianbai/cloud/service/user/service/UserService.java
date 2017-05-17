package vip.qianbai.cloud.service.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/** 
 * @date    2016年12月4日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@RestController
@RequestMapping("/v1")
public class UserService {
	@Autowired
	UserHystrixService hystrix;
	
	@RequestMapping("/hello")
	public String hello(){
		hystrix.getStores(null);
		try{
		}catch(Exception e){
		}
		return "hello ,this is service user";
	}
	
	
	
	
}
