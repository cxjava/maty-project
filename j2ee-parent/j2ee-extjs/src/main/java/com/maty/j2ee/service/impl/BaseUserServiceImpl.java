package com.maty.j2ee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maty.j2ee.entity.BaseUser;
import com.maty.j2ee.repository.BaseUserRepository;
import com.maty.j2ee.service.BaseUserService;

/**
 * user implement
 * 
 */
@Service
@Transactional(readOnly = true)
public class BaseUserServiceImpl implements BaseUserService {

	@Autowired
	private BaseUserRepository userRepository;

	@Override
	public BaseUser findUserByLoginName(String account) {
		return userRepository.findByAccount(account);
	}

}
