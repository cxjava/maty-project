package com.maty.j2ee.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.maty.j2ee.entity.BasePermission;

public interface BasePermissionRepository extends PagingAndSortingRepository<BasePermission, Long>,
		JpaSpecificationExecutor<BasePermission> {

}
