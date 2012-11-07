package com.maty.j2ee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maty.j2ee.entity.BaseUser;
import com.maty.j2ee.repository.BaseUserRepository;
import com.maty.j2ee.service.BaseUserService;

/**
 * 用户业务服务实现类
 * 
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {

	@Autowired
	private BaseUserRepository userRepository;

	@Override
	@Transactional
	public BaseUser saveUser(BaseUser user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public BaseUser findUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional
	public void updateUser(BaseUser user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteUserById(Long id) {
		userRepository.delete(id);
	}

}
