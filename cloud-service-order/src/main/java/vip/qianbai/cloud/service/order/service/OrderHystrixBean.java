package vip.qianbai.cloud.service.order.service;
import lombok.Getter;
import lombok.Setter;


/** 
 * @date    2017年2月21日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Setter
@Getter
public class OrderHystrixBean {

	String name ;
	public OrderHystrixBean(String name){
		this.name = name;
	}
}
