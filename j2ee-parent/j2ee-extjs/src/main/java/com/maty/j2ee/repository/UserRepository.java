package com.maty.j2ee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maty.j2ee.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByAccount(String account);
}