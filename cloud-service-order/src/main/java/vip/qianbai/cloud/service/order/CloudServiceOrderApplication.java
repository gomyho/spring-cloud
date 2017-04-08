package vip.qianbai.cloud.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
@EnableEurekaClient

//@EnableHystrix
@EnableCircuitBreaker
public class CloudServiceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceOrderApplication.class, args);
	}
    
}
