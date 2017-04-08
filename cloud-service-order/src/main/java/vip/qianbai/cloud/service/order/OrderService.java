package vip.qianbai.cloud.service.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/** 
 * @date    2016年12月4日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@RestController
@RequestMapping("/order")
public class OrderService {
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
