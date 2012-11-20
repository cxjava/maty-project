package com.maty.j2ee.service;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseUser;
import com.maty.j2ee.repository.BaseUserRepository;
import com.maty.j2ee.service.BaseUserService;

public class BaseUserTest extends Base {
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
	public void testDeleteUser() {
		userRepository.deleteAll();
	}

}
