package vip.qianbai.cloud.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient
//eq @EnableDiscoveryClient
public class ConfigServerApplication {

	public static void main(String[] args) {
//		EncryptionAutoConfiguration
//		EncryptionAutoConfiguration
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
