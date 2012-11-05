package com.maty.j2ee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maty.j2ee.entity.User;
import com.maty.j2ee.repository.UserRepository;
import com.maty.j2ee.service.UserService;

/**
 * 用户业务服务实现类
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);

	}

	@Override
	@Transactional(readOnly = true)
	public User findUserById(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteUserById(Integer id) {
		userRepository.delete(id);
	}

}
