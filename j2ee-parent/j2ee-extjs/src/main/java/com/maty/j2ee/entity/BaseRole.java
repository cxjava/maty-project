package com.maty.j2ee.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * role info table
 */
@Entity
@Table(name = "t_base_role")
public class BaseRole extends IdEntity {

	/** role name */
	@NotBlank
	private String roleName;
	/** role description */
	private String roleDesc;

	/**
	 * @return the roleName role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDesc role description
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * @param roleDesc
	 *            the roleDesc to set role description
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}