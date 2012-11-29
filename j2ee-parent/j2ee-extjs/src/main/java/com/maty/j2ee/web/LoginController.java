package com.maty.j2ee.web;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.maty.j2ee.entity.ext.ExtReturn;

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

	private Producer captchaProducer = null;

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
		// judge the locale is or not in the default languages.
		if (!ArrayUtils.contains(StringUtils.split(availLanguages, ','), locale.toString())) {
			// if not,get the first language from configuration file
			// as a default language
			LOG.warn("user default language is {},it's not in support group.", locale.toString());
			// get the first one to default language
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
	@ResponseBody
	public Object fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String shiroLoginFailureClass = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		LOG.warn("shiroLoginFailureClass is {}.", shiroLoginFailureClass);
		if ("com.maty.j2ee.service.exception.LoginException".equals(shiroLoginFailureClass)) {
			// username is null or blank
			return new ExtReturn(shiroLoginFailureClass);
			
		} else if ("com.maty.j2ee.service.exception.CaptchaException".equals(shiroLoginFailureClass)) {
			//TODO:添加cookie，需要captcha
			return new ExtReturn(shiroLoginFailureClass);
			
		} else if ("org.apache.shiro.authc.UnknownAccountException".equals(shiroLoginFailureClass)) {
			// 用户名不存在
			return new ExtReturn(shiroLoginFailureClass);
			
		} else if ("org.apache.shiro.authc.IncorrectCredentialsException".equals(shiroLoginFailureClass)) {
			// 密码不正确
			// TODO:更新登录错误次数
			return new ExtReturn(shiroLoginFailureClass);

		} else if ("org.apache.shiro.authc.LockedAccountException".equals(shiroLoginFailureClass)) {
			return new ExtReturn(shiroLoginFailureClass);
			// account for that username is locked - can't login. Show them a
			// message?

		} else if ("org.apache.shiro.authc.AuthenticationException".equals(shiroLoginFailureClass)) {
			return new ExtReturn(shiroLoginFailureClass);
			// unexpected condition - error?
		} else if ("org.apache.shiro.authc.AccountException".equals(shiroLoginFailureClass)) {
			return new ExtReturn(shiroLoginFailureClass);
		}else{
			LOG.error(shiroLoginFailureClass);
			return new ExtReturn(shiroLoginFailureClass);
			//others
		}
	}

	/**
	 * login success and return json object
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping("/loginSuccess")
	@ResponseBody
	public Object loginSuccess() {
		return new ExtReturn(true, "login success!");
	}

	/**
	 * get captcha jpg
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/captcha.jpg", method = RequestMethod.GET)
	public Object captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Set to expire far in the past.
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		// return a jpeg
		response.setContentType("image/jpeg");

		// create the text for the image
		String capText = captchaProducer.createText();

		// store the text in the session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

		// create the image with the text
		BufferedImage bi = captchaProducer.createImage(capText);

		OutputStream out = response.getOutputStream();

		// write the data out
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			IOUtils.closeQuietly(out);
		}
		return null;
	}

	/**
	 * @param captchaProducer
	 */
	@Autowired
	public void setCaptchaProducer(Producer captchaProducer) {
		this.captchaProducer = captchaProducer;
	}
}
