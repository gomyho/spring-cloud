package vip.qianbai.cloud.client.api.order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vip.qianbai.cloud.client.configuration.FeignConfiguration;


/** 
 * @date    2016年12月4日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 * @see FeignClientsConfiguration
 */
@FeignClient(name="cloudServiceOrder",configuration=FeignConfiguration.class,
fallback=OrderFallback.class)
public interface OrderApiService {
	@RequestMapping("/order/hello/{what}")
	public String hello(@PathVariable("what")String what);
	
	@RequestMapping("/order/report")
	public MultipartFile report();
	
}
