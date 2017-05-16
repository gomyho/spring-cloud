package vip.qianbai.cloud.service.user;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vip.qianbai.cloud.service.user.config.ZookeeperConfig;
import vip.qianbai.cloud.service.user.config.ZookeeperConfigProperties;
import vip.qianbai.cloud.service.user.configuration.ZookeeperConfigPropertySourceLocator;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
@EnableEurekaClient

//@EnableHystrix
@EnableCircuitBreaker
public class CloudServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceUserApplication.class, args);
	}
    
	@Bean
	public ZookeeperConfigProperties zookeeperConfigProperties(){
		return new ZookeeperConfigProperties();
	}
	
	@Bean
	public ZookeeperConfig zookeeperConfig(){
		return new ZookeeperConfig();
	}
	
	@Bean
	@ConditionalOnBean({CuratorFramework.class})
	public ZookeeperConfigPropertySourceLocator zookeeperConfigPropertySource(CuratorFramework client) {
		ZookeeperConfigPropertySourceLocator locator = new ZookeeperConfigPropertySourceLocator(
				zookeeperConfigProperties(),client);
		return locator;
	}
}
