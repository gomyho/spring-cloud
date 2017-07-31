package vip.qianbai.cloud.configuration.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import vip.qianbai.cloud.configuration.service.UserService;


/** 
 * @date    2017年6月19日 <br/> 
 * @author   陈小峰
 * @since    JDK 1.8
 */

@Slf4j
@RestController
@RequestMapping
public class MonitorController {

	@Autowired
	Environment env;
	
	@Autowired
	UserService us;
	
	public MonitorController() {
		super();
		log.info("staring......................");
	}
	
	@RequestMapping
	public void isOk(HttpServletRequest request,HttpServletResponse resp){
		try {
			resp.getWriter().println(env.getProperty("systemProperties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
