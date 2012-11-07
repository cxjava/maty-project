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
	private static final Logger logger = LoggerFactory.getLogger(BaseUserRepositoryTest.class);
	@Autowired
	private BaseUserRepository repository;
	private BaseUser baseUser;

	@Before
	public void before() {
		baseUser = new BaseUser();
		baseUser.setAccount("LiHuai");
		baseUser.setRealName("李坏");
		baseUser.setPassword("123456");
		baseUser.setLastLoginTime(new Date());
	}

	@Test
	public void testSave() {
		baseUser = repository.save(baseUser);
		assertNotNull(baseUser);
	}

	@Test
	public void testFindOne() {
		baseUser = repository.findOne(2L);
		logger.info("user:{}", baseUser);
		assertNotNull(baseUser);
		assertEquals(baseUser.getAccount(), "admin");
	}

	@Test
	public void testFindManyToMany() {
		baseUser = repository.findOne(2L);
		logger.info("user:{}", baseUser);
		assertNotNull(baseUser);
		assertNotNull(baseUser.getRoleList());
		assertNotNull(baseUser.getRoleList().size());
		assertEquals(baseUser.getRoleList().size(), 1);
	}
}
