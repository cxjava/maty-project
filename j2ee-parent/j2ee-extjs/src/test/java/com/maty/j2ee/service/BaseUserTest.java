package com.maty.j2ee.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseUser;
import com.maty.j2ee.repository.BaseUserRepository;
import com.maty.j2ee.service.BaseUserService;

public class BaseUserTest extends Base {
	private static final Logger logger = LoggerFactory.getLogger(BaseUserTest.class);
	@Autowired
	private BaseUserService userService;
	@Autowired
	private BaseUserRepository userRepository;
	private BaseUser user;

	@Before
	public void before() {
		user = new BaseUser();
		user.setAccount("LiHuai");
		user.setRealName("李坏");
		user.setPassword("123456");
		user.setLastLoginTime(new Date());
	}

	@Test
	public void testSaveUser() {
		user = userService.saveUser(user);
		logger.debug("user:{}", user);
	}

	@Test
	public void testDeleteUser() {
		userRepository.deleteAll();
	}

	@Test
	public void testFindByAccount() {
		user = userRepository.save(user);
		List<BaseUser> users = userRepository.findByAccount("LiHuai");
		assertFalse(users.isEmpty());
		assertThat(users.get(0), is(user));
		assertEquals(users.size(), 1);
	}

}
