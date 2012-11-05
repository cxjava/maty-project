package com.maty.j2ee.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maty.j2ee.Base;
import com.maty.j2ee.entity.User;
import com.maty.j2ee.service.UserService;

public class UserTest extends Base {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	private User user;

	@Before
	public void before() {
		user = new User();
		user.setAccount("LiHuai");
		user.setName("李坏");
		user.setPassword("123456");
	}

	@Test
	public void testSaveUser() {
		userService.saveUser(user);
	}

	@Test
	public void testDeleteUser() {
		userRepository.deleteAll();
	}

	@Test
	public void testFindByAccount() {
		userRepository.save(user);
		List<User> user = userRepository.findByAccount("LiHuai");
		assertEquals(user.size(), 1);
	}
	
	@Test
	public void testFindByAccountAndName() {
		userRepository.save(user);
		List<User> user = userRepository.findByAccountAndName("LiHuai", "李坏");
		assertEquals(user.get(0).getAccount(), "LiHuai");
	}

	@Test
	public void testFindByAccountAndNameIgnoreCase() {
		userRepository.save(user);
		List<User> user = userRepository.findByAccountIgnoreCaseAndName("LIHUAI", "李坏");
		assertEquals(user.get(0).getAccount(), "LiHuai");
	}

	@Test
	public void testFindByAccountAndNameOrPassword() {
		userRepository.save(user);
		List<User> user = userRepository.findByAccountAndNameOrPassword("LiHuai", "李坏", "123");
		assertEquals(user.get(0).getAccount(), "LiHuai");
	}
}