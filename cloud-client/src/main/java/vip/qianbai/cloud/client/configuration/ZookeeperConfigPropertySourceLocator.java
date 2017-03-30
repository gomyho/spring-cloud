package vip.qianbai.cloud.client.configuration;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


/** 
 * @date    2017年3月11日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Setter
@Getter
@Component
public class ZookeeperConfigPropertySourceLocator implements PropertySourceLocator {

	@Override
	public PropertySource<?> locate(Environment environment) {
		return null;
	}

}
