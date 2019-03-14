package com.zqq.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

	@Override
	public Page<Role> getRolesByPage(int pageNo, int pageSize, String roleName, Date createTime) {
		PageHelper.startPage(pageNo, pageSize);
		Map<String, Object> params=new HashMap<>();
		params.put("roleName", roleName);
		params.put("createTime", createTime);
		return roleMapper.getRolesByPage(params);
	}
	
	@Override
	public Role getRoleByRoleName(String roleName) {
		return roleMapper.getRoleByRoleName(roleName);
	}

}
