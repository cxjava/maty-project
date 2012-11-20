/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.maty.j2ee.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maty.j2ee.entity.BaseUser;

/**
 * manage login
 * 
 * @author calvin
 * 
 */
@Service
public class ShiroRealm extends AuthorizingRealm {

	public static final int HASH_INTERATIONS = 1024;
	protected BaseUserService baseUserService;

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		BaseUser user = baseUserService.findUserByLoginName(token.getUsername());
		if (user != null) {
			// if (user.getStatus().equals("disabled")) {
			// throw new DisabledAccountException();
			// }

			// byte[] salt = Encodes.decodeHex(user.getSalt());
			//Note that a normal app would reference an attribute rather
			//than create a new RNG every time:
			RandomNumberGenerator rng = new SecureRandomNumberGenerator();
			Object salt = rng.nextBytes();
			//now hash the plain-text password with the random salt and multiple
			//iterations and then Base64-encode the value (requires less space than Hex):
			String hashedPasswordBase64 = new Sha1Hash("admin", salt, 1024).toBase64();
			
//			byte[] salt = new byte[1024];
			return new SimpleAuthenticationInfo(new ShiroUser(user.getAccount(), user.getRealName()), user.getPassword(),
					ByteSource.Util.bytes(salt), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		BaseUser user = baseUserService.findUserByLoginName(shiroUser.loginName);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// for (Role role : user.get()) {
		// //基于Role的权限信息
		// info.addRole(role.getName());
		// //基于Permission的权限信息
		// info.addStringPermissions(role.getPermissionList());
		// }
		return info;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Sha1Hash.ALGORITHM_NAME);
		matcher.setHashIterations(HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}

	/**
	 * @param baseUserService
	 *            the baseUserService to set
	 */
	@Autowired
	public void setBaseUserService(BaseUserService baseUserService) {
		this.baseUserService = baseUserService;
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public String loginName;
		public String name;

		/**
		 * @param loginName
		 * @param name
		 */
		public ShiroUser(String loginName, String name) {
			this.loginName = loginName;
			this.name = name;
		}

		/**
		 * @return
		 */
		public String getName() {
			return name;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this, "loginName");
		}

		/**
		 * 重载equals,只比较loginName
		 */
		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(this, obj, "loginName");
		}
	}
}
