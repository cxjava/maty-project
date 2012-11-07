package com.maty.j2ee.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseModule;

public class BaseModuleRepositoryTest extends Base {
	private static final Logger logger = LoggerFactory.getLogger(BaseModuleRepositoryTest.class);
	@Autowired
	private BaseModuleRepository repository;
	private BaseModule baseModule;

	@Before
	public void before() {
		baseModule = new BaseModule();
		baseModule.setModuleName("module name");
		baseModule.setParentUrl(2L);
	}

	@Test
	public void testSave() {
		baseModule = repository.save(baseModule);
		assertNotNull(baseModule);
	}

	@Test
	public void testFindOne() {
		baseModule = repository.findOne(1L);
		logger.info("module:{}", baseModule);
		assertNotNull(baseModule);
		assertEquals(baseModule.getModuleName(), "系统设置");
	}

}
