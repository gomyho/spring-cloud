package vip.qianbai.cloud.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
@EnableEurekaClient

//@EnableHystrix
@EnableCircuitBreaker
@EnableJpaRepositories
public class CloudServiceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceOrderApplication.class, args);
	}
    
}
