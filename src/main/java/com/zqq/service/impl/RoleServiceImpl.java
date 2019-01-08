package com.zqq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqq.mapper.RoleMapper;
import com.zqq.model.Role;
import com.zqq.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public int addRole(Role role) {
		return roleMapper.insert(role);
	}

	@Override
	public List<Role> findAllRoles() {
		return roleMapper.getAllRoles();
	}

	@Override
	public Role getRoleById(Integer roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int deleteRoleById(Integer roleId) {
		return roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public Role getRoleByUserNameAndPwd(Role role) {
		return roleMapper.selectByUserNameAndPwd(role);
	}

}
