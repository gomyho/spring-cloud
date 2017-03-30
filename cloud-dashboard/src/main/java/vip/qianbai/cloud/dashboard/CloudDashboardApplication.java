package vip.qianbai.cloud.dashboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Configuration;


/** 
 * <br/>
 * @date    2017年2月21日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@EnableTurbine
@EnableEurekaClient
@EnableHystrixDashboard

@Configuration
@EnableConfigurationProperties
@SpringBootApplication
public class CloudDashboardApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CloudDashboardApplication.class, args);
	}
}
