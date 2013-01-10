package com.maty.j2ee.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseUser;
import com.maty.j2ee.repository.BaseUserRepository;
import com.maty.j2ee.service.BaseUserService;

public class BaseUserServiceTest extends Base {
	private static final Logger LOG = LoggerFactory.getLogger(BaseUserServiceTest.class);
	@Autowired
	private BaseUserService userService;
	@Autowired
	private BaseUserRepository repository;
	private BaseUser user;

	@Before
	public void before() {
		user = new BaseUser();
		user.setAccount("cx");
		user.setRealName("cx");
		user.setPassword("123456");
		user.setSalt("123456");
		user.setLastLoginTime(new Date());
	}

	@Test
	public void findUserByLoginName() {
		user = userService.findUserByLoginName("admin");
		assertNotNull(user);
		LOG.debug("user : {}.", user);
		assertEquals(user.getStatus(), "0");
	}

	@Test
	public void updateUserErrorCount() {
		String account = "admin";
		user = repository.findByAccount(account);
		user.setErrorCount(10);
		repository.save(user);
		userService.updateUserErrorCount(account);
		user = repository.findByAccount(account);
		assertNotNull(user);
		LOG.debug("user : {}.", user);
		assertEquals(user.getStatus(), "1");
		assertTrue(user.getErrorCount() == 11);
	}

	@Test
	public void resetUserErrorCount() {
		String account = "admin";
		userService.resetUserErrorCount(account);
		user = repository.findByAccount(account);
		assertNotNull(user);
		LOG.debug("user : {}.", user);
		assertTrue(user.getErrorCount() == 0);
	}

}
