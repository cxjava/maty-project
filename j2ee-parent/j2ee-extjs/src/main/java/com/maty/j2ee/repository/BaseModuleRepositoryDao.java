package com.maty.j2ee.repository;

import java.util.List;
import java.util.Map;

import com.maty.j2ee.entity.BaseModule;

public interface BaseModuleRepositoryDao {
	List<BaseModule> selectAllModules(Map<String, Object> parameters);
}
