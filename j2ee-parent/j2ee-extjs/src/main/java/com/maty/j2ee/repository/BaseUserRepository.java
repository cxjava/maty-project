package com.maty.j2ee.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.maty.j2ee.entity.BaseUser;

/**
 * all about user
 * 
 * @author Maty Chen
 * @date 2013-1-9下午4:52:21
 */
public interface BaseUserRepository extends PagingAndSortingRepository<BaseUser, Long>, JpaSpecificationExecutor<BaseUser> {

	BaseUser findByAccount(String account);

}
