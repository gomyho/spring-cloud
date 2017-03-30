package vip.qianbai.cloud.client.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;
import vip.qianbai.cloud.client.api.one.HelloApiService;


/** 
 * @date    2016年12月4日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Setter
@Getter
@Controller
@RequestMapping("/client")
public class HelloControlle {

	@Autowired
	HelloApiService helloApi;
	
	@RequestMapping("/sayHi")
	@ResponseBody
	public String sayHello() {
		return helloApi.hello();
	}
}
