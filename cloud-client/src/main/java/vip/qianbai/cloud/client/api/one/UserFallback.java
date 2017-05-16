package vip.qianbai.cloud.client.api.one;
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
public class UserFallback implements UserApiService {

	@Override
	public String hello() {
		return "hello user fallback";
	}

}
