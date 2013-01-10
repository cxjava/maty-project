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

	/**
	 * user login error,and update the user error count.
	 * 
	 * @param userName
	 *            account name
	 */
	void updateUserErrorCount(String userName);

	/**
	 * user login success,and update the user error count to zero.
	 * 
	 * @param userName
	 *            account name
	 */
	void resetUserErrorCount(String userName);

}