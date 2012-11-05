package com.maty.j2ee.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maty.j2ee.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	public List<User> findByAccount(String account);

	List<User> findByAccountAndName(String account, String name);
	List<User> findByAccountIgnoreCaseAndName(String account, String name);

	List<User> findByAccountAndNameOrPassword(String account, String name, String password);

}