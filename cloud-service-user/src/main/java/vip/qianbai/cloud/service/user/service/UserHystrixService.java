package vip.qianbai.cloud.service.user.service;
import java.util.Map;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.Getter;
import lombok.Setter;


/** 
 * TODO 该类的作用<br/>
 * @date    2017年2月21日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Setter
@Getter
@Component
public class UserHystrixService {

	@HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
		int rdm = RandomUtils.nextInt(10);
		if(rdm<8){
			throw new RuntimeException("test exception");
		}
    	return new UserHystrixBean("default");
    }

    public Object defaultStores(Map<String, Object> parameters) {
    	return new UserHystrixBean("failure");
    }
}
