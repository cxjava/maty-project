package com.maty.j2ee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * controller基本测试类
 * 
 * @author Maty Chen
 * @date 2011-12-7 下午4:17:51
 */
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring/spring.xml" })
@Transactional
@ActiveProfiles("test")
public class Controller {
	@Autowired
	protected WebApplicationContext wac;

}
