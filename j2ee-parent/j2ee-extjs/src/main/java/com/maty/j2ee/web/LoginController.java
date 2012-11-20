package com.maty.j2ee.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * 
 * 真正登录的POST请求由Filter完成,
 * 
 * @author calvin
 */
@Controller
public class LoginController {
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	/** system support languages */
	@Value("${avail.languages:en_US,de_DE,zh_CN}")
	private String availLanguages;

	/**
	 * go to login page,and get some info from user's browser
	 * 
	 * @param request
	 * @param response
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		// judge the locale is in the default languages.
		if (!ArrayUtils.contains(StringUtils.split(availLanguages, ','), locale.toString())) {
			// get the first language from configuration file as a default language
			LOG.warn("user default language is {},it's not in support group.", locale.toString());
			model.addAttribute("language", StringUtils.split(availLanguages, ',')[0]);
		} else {
			model.addAttribute("language", locale.toString());
		}
		return "login";
	}

	/**
	 * login failed,and return back the page
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		return "login";
	}

}
