package com.maty.j2ee.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	private static final Logger LOG = LoggerFactory.getLogger(BaseUserServiceImpl.class);

	@Autowired
	private BaseUserRepository userRepository;
	@Value("${max.password.error.count:10}")
	private Integer maxErrorCount;

	@Override
	public BaseUser findUserByLoginName(String account) {
		return userRepository.findByAccount(account);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUserErrorCount(String userName) {
		BaseUser user = userRepository.findByAccount(userName);
		Integer errorCount = user.getErrorCount();
		LOG.debug("errorCount:{}", errorCount);
		LOG.debug("user.getStatus():{}", user.getStatus());
		if (errorCount >= maxErrorCount) {
			// 0:active,1:locked
			user.setStatus("1");
		}
		errorCount = errorCount + 1;
		user.setErrorCount(errorCount);
		userRepository.save(user);
	}
}
