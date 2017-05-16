package vip.qianbai.cloud.service.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/** 
 * @date    2017年3月11日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Setter
@Getter
@ConfigurationProperties(ZookeeperConfigProperties.PREFIX)
public class ZookeeperConfigProperties {
	public static final String PREFIX="properties.zk.config";
	/**
	 * base path for load properties
	 */
	private String basePath;
}
