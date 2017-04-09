package vip.qianbai.cloud.client.api.one;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

import vip.qianbai.cloud.client.configuration.RibbonConfiguration;
import vip.qianbai.cloud.client.ribbon.annotation.IgnoreCfg;


/** 
 * @date    2017年4月9日 <br/> 
 * @author   陈小峰
 * @since    JDK 1.8
 */
@Configuration
@IgnoreCfg
@RibbonClient(name = "orderRibbonService", configuration = RibbonConfiguration.class)
public class OrderRibbonApi {

}
