package com.maty.j2ee.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页面
 * 
 * @author Maty Chen
 * @date 2011-11-2 下午2:03:20
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Value("${reset.password}")
	private String password;
	@Value("${avail.languages}")
	private String availLanguages;

	@Autowired
	private MessageSource source;

	/**
	 * 主页
	 */
	@RequestMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale,Model model) {
		try {
			logger.info(locale.toString());
			if(!ArrayUtils.contains(StringUtils.split(availLanguages, ','),locale.toString())){
				model.addAttribute("language","en_US");
			}else{
				model.addAttribute("language",locale.toString());
			}
			return "login";
		} catch (Exception e) {
			logger.error("Exception: ", e);
			return source.getMessage("login.page.title", null, locale);
		}
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
