package vip.qianbai.cloud.client.api.order;
import lombok.Getter;
import lombok.Setter;


/** 
 * fiegn fallback<br/>
 * @date    2017年2月25日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Setter
@Getter
public class OrderFallback implements OrderApiService {

	@Override
	public String hello(String what) {
		return "hello order fallback";
	}

}
