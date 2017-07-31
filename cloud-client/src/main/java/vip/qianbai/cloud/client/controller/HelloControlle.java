package vip.qianbai.cloud.client.controller;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import vip.qianbai.cloud.client.api.one.UserApiService;
import vip.qianbai.cloud.client.api.order.OrderApiService;


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
	OrderApiService orderApi;
	@Autowired
	UserApiService helloApi;
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@RequestMapping("/sayHi")
	@ResponseBody
	public String sayHello() {
		return helloApi.hello();
	}
	
	@RequestMapping("/order")
	@ResponseBody
	public String getOrders(){
		MultipartFile report = orderApi.report();
		System.out.println(report.getName());
		return orderApi.hello("order-direct");
	}
	
	@RequestMapping("/ribbon")
	@ResponseBody
	public String getRibbonOrders(){
		ServiceInstance instance = loadBalancer.choose("cloudServiceOrder");
		URI orderUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
		StringBuilder sb = new StringBuilder();
		
		try {
			URL u = new URL(orderUri.toString()+"/order/hello/ribbon");
			URLConnection conn = u.openConnection();
			InputStream in = conn.getInputStream();
			byte[] b = new byte[1024];
			while(in.available()>0){
				int size = in.read(b,0,b.length);	
				sb.append(new String(b,0,size,Charset.forName("UTF-8")));
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
