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

import com.maty.j2ee.service.ServiceException;

/**
 * 主页面
 * 
 * @author Maty Chen
 * @date 2011-11-2 下午2:03:20
 */
@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Value("${avail.languages:en_US,de_DE,zh_CN}")
	private String availLanguages;

	@Autowired
	private MessageSource source;

	/**
	 * 主页
	 */
	@RequestMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		try {
			LOGGER.debug(availLanguages);
			LOGGER.debug(locale.toString());
			// judge the locale is in the default languages.
			if (!ArrayUtils.contains(StringUtils.split(availLanguages, ','), locale.toString())) {
				model.addAttribute("language", StringUtils.split(availLanguages, ',')[0]);
			} else {
				model.addAttribute("language", locale.toString());
			}
			return "login";
		} catch (ServiceException e) {
			LOGGER.error(WebConstants.SERVICE_EXCEPTION, e);
			if (StringUtils.hasText(e.getErrorCode())) {
				return source.getMessage(e.getErrorCode(), null, locale);
			} else {
				return "";
			}
		}
	}

	/**
	 * 主页面
	 */
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
}
