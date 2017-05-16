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
@ConfigurationProperties("zk.config")
public class ZookeeperConfig {

	private String connectString="";
	private String userName;
	private String password;
	private int maxRetries = 3;
	private int baseSleepTimeMs = 1000;
}
