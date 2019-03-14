package com.zqq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 角色权限
 * @author 17612
 *
 */
@Entity
public class RoleResource {
	@Id
	@Column(name="role_resource_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleResourceId;
	@Column(name="role_id")
	private int roleId;
	@Column(name="resource_id")
	private String resourceId;

	public int getRoleResourceId() {
		return roleResourceId;
	}

	public void setRoleResourceId(int roleResourceId) {
		this.roleResourceId = roleResourceId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public RoleResource(int roleResourceId, int roleId, String resourceId) {
		super();
		this.roleResourceId = roleResourceId;
		this.roleId = roleId;
		this.resourceId = resourceId;
	}

	public RoleResource() {
		super();
	}
}
