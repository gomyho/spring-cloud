package vip.qianbai.cloud.service.configuration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import vip.qianbai.cloud.service.config.ZookeeperConfigProperties;


/** 
 * @date    2017年3月11日 <br/> 
 * @author   陈小峰
 * @since    JDK 8
 * @see ConfigServicePropertySourceLocator
 */
public class ZookeeperConfigPropertySourceLocator implements PropertySourceLocator {
	
	ZookeeperConfigProperties config;
	CuratorFramework client;
	public ZookeeperConfigPropertySourceLocator(ZookeeperConfigProperties config, CuratorFramework client) {
		super();
		this.config = config;
		this.client = client;
	}
	/**
	 * @see ConfigServicePropertySourceLocator#locate(Environment)
	 */
	@Override
	public PropertySource<?> locate(Environment environment) {
		try {
			List<String> children = client.getChildren().forPath(config.getBasePath());
			Map<String,String> pathData = new HashMap<>();
			children.forEach(e -> {
				try {
					byte[] data = client.getData().forPath(e);
					pathData.put(e, new String(data,"UTF-8"));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			System.out.println(pathData);
			CompositePropertySource composite = new CompositePropertySource("zkProperties");
			
			return composite;
		} catch (Exception e) {
		}
		return null;
	}

}
