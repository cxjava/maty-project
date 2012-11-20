package com.maty.j2ee.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * role info and permission info table
 */
@Entity
@Table(name = "t_base_role_permission")
public class BaseRolePermission extends IdEntity {

	private Long roleId;
	private Long permissionId;

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the permissionId
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId
	 *            the permissionId to set
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

}