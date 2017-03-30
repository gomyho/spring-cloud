package vip.qianbai.cloud.service.configuration;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vip.qianbai.cloud.service.config.ZookeeperConfig;

/**
 * 
 * @date 2017年3月11日 <br/>
 * @author 陈小峰
 * @since JDK 7
 */
@Configuration
public class ZkCuratorConfiguration {
	
	@Autowired
	private ZookeeperConfig zkCfg;
	
	@ConditionalOnBean(ZookeeperConfig.class)
	@Bean(destroyMethod="close",initMethod="start")
	public CuratorFramework curatorFramework() {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(zkCfg.getBaseSleepTimeMs(), zkCfg.getMaxRetries());
		CuratorFramework client = CuratorFrameworkFactory.newClient(zkCfg.getConnectString(), retryPolicy);
		return client;
	}
	
	
}
