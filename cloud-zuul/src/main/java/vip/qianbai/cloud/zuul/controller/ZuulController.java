package vip.qianbai.cloud.zuul.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author xiaofeng
 * @date 2017年8月1日
 */
@Controller
@RequestMapping("/pages")
public class ZuulController {

	@RequestMapping("/upload")
	public void uploadPage(HttpServletRequest request,HttpServletResponse response){
		String data = "<!DOCTYPE html><html><head><tilte>upload page</title></head>"
				+ "<body><form action=\"/zuul/orders/files\" method=\"post\" enctype=\"multipart/form-data\">"
				+ "<input type=\"file\" name=\"file\"></input>"
				+ "<input type=\"submit\"> submit </input>"
				+ "</form></body>"
				+ "</html>";
		try {
			IOUtils.write(data, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
