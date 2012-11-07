package com.maty.j2ee.service;

import com.maty.j2ee.entity.BaseUser;

/**
 * 用户业务接口
 */
public interface BaseUserService {

	/**
	 * 保存用户
	 * 
	 * @param user
	 * @return 
	 */
	BaseUser saveUser(BaseUser user);

	/**
	 * 根据id查找用户
	 * 
	 * @param id
	 * @return
	 */
	BaseUser findUserById(Long id);

	/**
	 * 更新用户
	 * 
	 * @param user
	 */
	void updateUser(BaseUser user);

	/**
	 * 根据ID删除用户
	 * 
	 * @param id
	 */
	void deleteUserById(Long id);

}