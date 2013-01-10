package com.maty.j2ee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.repository.BaseUserRepository;
import com.maty.j2ee.service.BaseUserService;

public class Temp extends Base {
	private static final Logger LOG = LoggerFactory.getLogger(Temp.class);
	@Autowired
	private BaseUserService userService;
	@Autowired
	private BaseUserRepository repository;
	private String name;

	@Before
	public void before() {
		name = "";
	}

	@Test
	public void testUpdateUserErrorCount() {
		// assertNotNull(user);
		// assertEquals(user.getStatus(), "1");
		// assertTrue(user.getErrorCount() == 11);
	}

}
