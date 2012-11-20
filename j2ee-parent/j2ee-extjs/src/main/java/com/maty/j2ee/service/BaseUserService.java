package com.maty.j2ee.service;

import com.maty.j2ee.entity.BaseUser;

/**
 * user method
 */
public interface BaseUserService {

	/**
	 * user login by account
	 * 
	 * @param account
	 *            login name
	 * @return
	 */
	BaseUser findUserByLoginName(String account);

}