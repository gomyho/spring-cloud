package vip.qianbai.cloud.service.user.processor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;


/** 
 * @date    2017年3月12日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
public class ZkPropertySourceProcessor implements EnvironmentPostProcessor {

	
	
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		System.out.println("---------ZkPropertySourceProcessor-------------");
	}

}
