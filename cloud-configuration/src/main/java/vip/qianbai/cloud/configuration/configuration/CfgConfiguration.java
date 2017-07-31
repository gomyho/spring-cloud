package vip.qianbai.cloud.configuration.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vip.qianbai.cloud.configuration.service.UserService;


/** 
 * @date    2017年6月25日 <br/> 
 * @author   陈小峰
 * @since    JDK 1.8
 */
@Configuration
public class CfgConfiguration {

	@Bean
	public UserService useservice(){
		return new UserService();
	}
}
