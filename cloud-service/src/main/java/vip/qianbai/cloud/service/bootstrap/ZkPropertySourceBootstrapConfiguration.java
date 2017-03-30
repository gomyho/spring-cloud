package vip.qianbai.cloud.service.bootstrap;
import org.springframework.boot.bind.PropertySourcesPropertyValues;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.cloud.bootstrap.config.PropertySourceBootstrapConfiguration;
import org.springframework.cloud.bootstrap.config.PropertySourceBootstrapProperties;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

import lombok.Getter;
import lombok.Setter;


/** 
 * @date    2017年3月11日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 * @see PropertySourceBootstrapConfiguration
 */
@Configuration
public class ZkPropertySourceBootstrapConfiguration implements
	ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

	private static final String ZK_BOOTSTRAP_PROPERTY_SOURCE_NAME = "zk_bootstrap_properties";

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ConfigurableEnvironment env = applicationContext.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		CompositePropertySource composite = new CompositePropertySource(
				ZK_BOOTSTRAP_PROPERTY_SOURCE_NAME);
		
		//composite.addPropertySource(source);
		//insertPropertySources(propertySources,composite);
		
	}
	
	private void insertPropertySources(MutablePropertySources propertySources,
			CompositePropertySource composite) {
		MutablePropertySources incoming = new MutablePropertySources();
		incoming.addFirst(composite);
		PropertySourceBootstrapProperties remoteProperties = new PropertySourceBootstrapProperties();
		new RelaxedDataBinder(remoteProperties, "spring.cloud.config")
				.bind(new PropertySourcesPropertyValues(incoming));
		if (!remoteProperties.isAllowOverride() || (!remoteProperties.isOverrideNone()
				&& remoteProperties.isOverrideSystemProperties())) {
			propertySources.addFirst(composite);
			return;
		}
		if (remoteProperties.isOverrideNone()) {
			propertySources.addLast(composite);
			return;
		}
		if (propertySources
				.contains(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME)) {
			if (!remoteProperties.isOverrideSystemProperties()) {
				propertySources.addAfter(
						StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,
						composite);
			}
			else {
				propertySources.addBefore(
						StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,
						composite);
			}
		}
		else {
			propertySources.addLast(composite);
		}
	}

}
