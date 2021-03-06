package com.maty.j2ee.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.maty.j2ee.entity.BaseModule;

public interface BaseModuleRepository extends PagingAndSortingRepository<BaseModule, Long>, JpaSpecificationExecutor<BaseModule>,
		BaseModuleRepositoryDao {

}
