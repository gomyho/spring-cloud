package vip.qianbai.cloud.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import vip.qianbai.cloud.client.ribbon.annotation.IgnoreCfg;

/** 
 * Date:     2016年2月4日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Configuration
@EnableConfigurationProperties
@SpringBootApplication
//@EnableEurekaClient
//same as discovery client
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(excludeFilters={
		@Filter(type=FilterType.ANNOTATION,value=IgnoreCfg.class)
})
@EnableZuulProxy
public class CloudClientApplication {

	@Autowired
	RestTemplate rest;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(ClientHttpRequestFactory httpClientFactory){
		RestTemplate rest = new RestTemplate(httpClientFactory);
		return rest;
	}
	
	@Bean
	public ClientHttpRequestFactory httpClientFactory(HttpClient httpClient){
		HttpComponentsClientHttpRequestFactory f = new HttpComponentsClientHttpRequestFactory(httpClient);
		f.setConnectTimeout(2000);
		f.setReadTimeout(10000);
		return f;
	}

	@Bean
	public HttpClient httpClient(){
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setValidateAfterInactivity(500);
		RequestConfig cfg = RequestConfig.custom()
				  .setSocketTimeout(5000)
				  .setConnectTimeout(5000)
				  .setConnectionRequestTimeout(5000)
				  .build();
		return HttpClients.custom().setConnectionManager(connManager).setDefaultRequestConfig(cfg).build();
		/*CloseableHttpClient build = HttpClientBuilder.create().setConnectionManager(connManager).build() ;
		return build;*/
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CloudClientApplication.class, args);
	}
}