package com.maty.j2ee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.maty.j2ee.entity.BaseUser;

public interface BaseUserRepository extends PagingAndSortingRepository<BaseUser, Long>, JpaSpecificationExecutor<BaseUser> {

	List<BaseUser> findByAccount(String account);
	
	List<BaseUser> findByAccountAndEmail(String account,String email);

}
