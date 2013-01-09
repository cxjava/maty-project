package com.maty.j2ee.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.maty.j2ee.entity.BaseUserRole;

public interface BaseUserRoleRepository extends PagingAndSortingRepository<BaseUserRole, Long>, JpaSpecificationExecutor<BaseUserRole> {

}
