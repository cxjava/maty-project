package com.maty.j2ee.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.maty.j2ee.Base;
import com.maty.j2ee.entity.BaseModule;

public class BaseModuleRepositoryTest extends Base {
	private static final Logger LOG = LoggerFactory.getLogger(BaseModuleRepositoryTest.class);
	@Autowired
	private BaseModuleRepository repository;
	@Resource(name = "baseModuleRepositoryImpl")
	private BaseModuleRepositoryDao repositoryimpl;
	private BaseModule baseModule;

	@Before
	public void before() {
		baseModule = new BaseModule();
		baseModule.setModuleName("module name");
		baseModule.setParentId(2L);
	}

	@Test
	public void testSelectAllModules() {
		HashMap<String, Object> parameters = Maps.newHashMap();
		List<BaseModule> list = repositoryimpl.findAllModules(parameters);
		assertNotNull(list);
		LOG.debug("list.size() : {}.", list.size());
		assertEquals(list.size(), 7);
	}

}
