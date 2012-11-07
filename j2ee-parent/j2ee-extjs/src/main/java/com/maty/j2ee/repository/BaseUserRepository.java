package com.maty.j2ee.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maty.j2ee.entity.BaseUser;

public interface BaseUserRepository extends PagingAndSortingRepository<BaseUser, Long> {

	public List<BaseUser> findByAccount(String account);

	List<BaseUser> findByAccountAndRealName(String account, String realName);

	List<BaseUser> findByAccountIgnoreCaseAndRealName(String account, String realName);

	List<BaseUser> findByAccountAndRealNameOrPassword(String account, String realName, String password);

}
