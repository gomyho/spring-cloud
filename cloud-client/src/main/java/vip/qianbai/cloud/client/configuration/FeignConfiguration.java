package vip.qianbai.cloud.client.configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.apache.http.client.HttpClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Retryer;
import feign.httpclient.ApacheHttpClient;
import vip.qianbai.cloud.client.ribbon.annotation.IgnoreCfg;
/**
 * see alse
 * Logger.Level
	Retryer
	ErrorDecoder
	Request.Options
	Collection<RequestInterceptor>
 * @date:     2017年2月24日 <br/> 
 * @author 陈小峰
 * @since JDK7
 * @see FeignClientsConfiguration
 */
@Configuration
@IgnoreCfg
public class FeignConfiguration {
	
	@Bean
	Feign.Builder feignBuilder(HttpClient httpClient){
		ApacheHttpClient client = new ApacheHttpClient(httpClient);
		return new Feign.Builder().client(client);
	}
	@Bean
	Retryer retryer(){
		return new Retryer.Default(100, SECONDS.toMillis(1), 3);
	}
}