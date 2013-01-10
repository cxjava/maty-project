package com.maty.j2ee.repository;

import java.util.List;
import java.util.Map;

import com.maty.j2ee.entity.BaseModule;

public interface BaseModuleRepositoryDao {
	List<BaseModule> findAllModules(Map<String, Object> parameters);
}
