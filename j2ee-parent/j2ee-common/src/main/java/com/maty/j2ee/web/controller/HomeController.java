package com.maty.j2ee.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;

/**
 * 主页面
 * 
 * @author maty
 * @date 2011-11-2 下午2:03:20
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * 主页
	 */
	@RequestMapping("/query")
	public String index() {
		// 转到登录页面
		return "query";
	}

	/**
	 * 主页面
	 */
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	/**
	 * 头部
	 */
	@RequestMapping("/header")
	public String header() {
		return "header";
	}
	
	/**
	 * 欢迎界面
	 */
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	/**
	 * 欢迎界面
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Object test() {
		Map<String,Object> map=Maps.newHashMap();
		map.put("age", new Object[] {1,2,3});
		return map;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model,HttpServletRequest request) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		logger.info("fail(String, Model) - Model error= {}", error);
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login login");
		return "login";
	}
}
