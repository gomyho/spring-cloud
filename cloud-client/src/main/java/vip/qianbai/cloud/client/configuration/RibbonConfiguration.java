package vip.qianbai.cloud.client.configuration;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

import lombok.Getter;
import lombok.Setter;
import vip.qianbai.cloud.client.ribbon.annotation.IgnoreCfg;


/** 
 * ribbon client 4 client one <br/>
 * beans in this class are default config
 * @date    2017年2月22日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 * @see RibbonClientConfiguration
 */
@Setter
@Getter
@Configuration
@IgnoreCfg
public class RibbonConfiguration {
	/*@Bean
    public IPing ribbonPing(IClientConfig config) {
		//default 
		//return new NoOpPing();
		return new NIWSDiscoveryPing();
//        return new PingUrl();
    }*/
	
	@Bean
	public IClientConfig ribbonClientConfig(){
		IClientConfig config = new DefaultClientConfigImpl();
		config.set(CommonClientConfigKey.ConnectTimeout, 1000);
		config.set(CommonClientConfigKey.ReadTimeout, 500);
		config.set(CommonClientConfigKey.MaxAutoRetries, 1);
		return config;
	}
	
	@Bean
	public IRule ribbonRule(){
		return new ZoneAvoidanceRule();
	}
	
	/*@Bean 
	public ServerList<? extends Server> ribbonServerList(IClientConfig clientConfig){
		return new RibbonDiscoveryEnabledNIWSServerList();
		//return new ConfigurationBasedServerList();
	}*/
	@Bean
	public ServerListFilter<Server> ribbonServerListFilter(){
		return new ZonePreferenceServerListFilter();
	}
	@Bean
	public ILoadBalancer ribbonLoadBalancer(){
		return new ZoneAwareLoadBalancer();
	}
	
}
