package vip.qianbai.cloud.service.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.qianbai.cloud.service.order.repo.UserRepo;


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
	@Autowired
	UserRepo userRepo;
	@RequestMapping("/hello/{what}")
	public String hello(@PathVariable("what") String what){
		try{
			Thread.sleep(100);
		}catch(Exception e){
			
		}
		hystrix.getStores(null);
		return "order service:"+what;
	}
	
	
	
	
}
