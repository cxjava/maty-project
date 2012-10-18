package com.maty.j2ee.common.shiro;

import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Lists;

/**
 * 权限组.
 * 
 * 注释见{@link User}.
 * 
 * @author calvin
 */
public class Group extends IdEntity {

	private String name;

	private List<String> permissionList = Lists.newArrayList();

	public Group() {
	}

	public Group(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}

	public String getPermissionNames() {
		List<String> permissionNameList = Lists.newArrayList();
		for (String permission : permissionList) {
			permissionNameList.add(Permission.parse(permission).displayName);
		}
		return StringUtils.join(permissionNameList, ",");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
