package com.maty.j2ee.web.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.maty.j2ee.common.shiro.Group;
import com.maty.j2ee.common.shiro.User;
import com.google.common.collect.Lists;

/**
 * 系统初始化监听器
 * 
 * @author maty
 * @date 2011-12-16 下午11:26:14
 */
public class SystemInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// ServletContext servletContext = sce.getServletContext();
		// servletContext.setAttribute("fields",
		// baseFieldsService.selectAllByExample(criteria));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	public static User user = new User();

	static {
		user = new User();
		user.setId(1L);
		user.setEmail("cxjava@gmail.com");
		user.setLoginName("admin");
		user.setName("管理员");
		user.setPassword("c3284d0f94606de1fd2af172aba15bf3");
//		user.setPassword(new String(token.getPassword()));
		Group group = new Group();
		group.setId(3L);
		group.setName("管理员");
		List<String> p = Lists.newArrayList();
		p.add("user:view");
		p.add("user:edit");
		group.setPermissionList(p);
		List<Group> list = Lists.newArrayList();
		list.add(group);

		user.setGroupList(list);
	}
}
