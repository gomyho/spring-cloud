package vip.qianbai.cloud.client.api.one;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

import vip.qianbai.cloud.client.configuration.FeignConfiguration;


/** 
 * @date    2016年12月4日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 * @see FeignClientsConfiguration
 */
@FeignClient(name="cloudUserService",configuration=FeignConfiguration.class,
fallback=HelloFallback.class)
public interface UserApiService {
	@RequestMapping("/v1/hello")
	public String hello();
	
}
