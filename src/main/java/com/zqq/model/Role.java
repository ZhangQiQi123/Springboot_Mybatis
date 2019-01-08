package com.zqq.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 角色表
 * @author 17612
 *
 */
@Entity
public class Role {
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	@Column(name="role_name")
	private String roleName;
	@Column(name="create_time")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date createTime;
	@Column(name="update_time")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Role(int roleId, String roleName, Date createTime, Date updateTime) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public Role() {
		super();
	}
	
}
