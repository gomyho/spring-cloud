package vip.qianbai.cloud.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@EnableEurekaServer
@Configuration
@SpringBootApplication
//@EnableDiscoveryClient
public class CloudRegistryApplication {
    public static void main(String[] args) {
		SpringApplication.run(CloudRegistryApplication.class, args);
	}
}
