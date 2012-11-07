package com.maty.j2ee.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseRole;

public class BaseRoleRepositoryTest extends Base {
	private static final Logger logger = LoggerFactory.getLogger(BaseRoleRepositoryTest.class);
	@Autowired
	private BaseRoleRepository repository;
	private BaseRole baseRole;

	@Before
	public void before() {
		baseRole = new BaseRole();
		baseRole.setRoleDesc("role description");
		baseRole.setRoleName("admin");
	}

	@Test
	public void testSave() {
		baseRole = repository.save(baseRole);
		assertNotNull(baseRole);
	}

	@Test
	public void testFindOne() {
		baseRole = repository.findOne(1L);
		logger.info("role:{}", baseRole);
		assertNotNull(baseRole);
		assertEquals(baseRole.getRoleName(), "管理员");
	}

	@Test
	public void testFindManyToMany() {
		baseRole = repository.findOne(1L);
		logger.info("role:{}", baseRole);
		assertNotNull(baseRole);
		assertNotNull(baseRole.getModuleList());
		assertNotNull(baseRole.getModuleList().size());
		assertEquals(baseRole.getModuleList().size(), 7);
		assertEquals(baseRole.getRoleName(), "管理员");
	}

}
