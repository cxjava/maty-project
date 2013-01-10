package com.maty.j2ee.repository;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseUser;

public class BaseUserRepositoryTest extends Base {
	private static final Logger LOG = LoggerFactory.getLogger(BaseUserRepositoryTest.class);
	@Autowired
	private BaseUserRepository repository;
	private BaseUser baseUser;

	@Before
	public void before() {
		baseUser = new BaseUser();
		baseUser.setAccount("cx");
		baseUser.setRealName("cx");
		baseUser.setPassword("123456");
		baseUser.setSalt("123456");
		baseUser.setLastLoginTime(new Date());
	}

	@Test
	public void findByAccount() {
		baseUser = repository.findByAccount("admin");
		assertNotNull(baseUser);
		LOG.debug("baseUser : {}.", baseUser);
		assertEquals(baseUser.getStatus(), "0");
	}

}
