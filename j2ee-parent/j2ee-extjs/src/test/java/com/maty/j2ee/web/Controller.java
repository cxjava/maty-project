package com.maty.j2ee.web;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * controller基本测试类
 * 
 * @author Maty Chen
 * @date 2011-12-7 下午4:17:51
 */
@ContextConfiguration(locations = { "classpath:/spring/spring.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ActiveProfiles("test")
public class Controller {
	protected MockHttpServletRequest request;
	protected MockHttpServletResponse response;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		response.setCharacterEncoding("UTF-8");
	}

}
