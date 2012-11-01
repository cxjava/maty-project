package com.maty.j2ee.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页面
 * 
 * @author chenxin
 * @date 2011-11-2 下午2:03:20
 */
@Controller
public class HomeController {

	/**
	 * 主页
	 */
	@RequestMapping("/")
	public String home() {
		// 转到登录页面
		return "login";
	}
	/**
	 * 主页
	 */
	@RequestMapping("/1")
	public String home1() {
		// 转到登录页面
		return "login1";
	}

	/**
	 * 主页面
	 */
	@RequestMapping("/main")
	public String main() {
		return "main";
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
}
