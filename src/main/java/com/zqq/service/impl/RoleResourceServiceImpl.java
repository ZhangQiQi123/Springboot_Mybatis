package com.zqq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.zqq.mapper.RoleResourceMapper;
import com.zqq.model.RoleResource;
import com.zqq.service.RoleResourceService;
@Service
public class RoleResourceServiceImpl implements RoleResourceService {

	@Autowired
	private RoleResourceMapper roleResourceMapper;
	
	public void setRoleResourceMapper(RoleResourceMapper roleResourceMapper) {
		this.roleResourceMapper = roleResourceMapper;
	}

	@Override
	public int addRoleResource(RoleResource roleResource) {
		return roleResourceMapper.insertRoleResource(roleResource);
	}

	@Override
	public int deleteRoleResourceById(int roleResourceId) {
		return roleResourceMapper.deleteRoleResourceById(roleResourceId);
	}

	@Override
	public int updateRoleResourceById(int roleResourceId) {
		return roleResourceMapper.updateRoleResourceById(roleResourceId);
	}

	@Override
	public RoleResource getRoleResourceById(int roleResourceId) {
		return roleResourceMapper.selectRoleResourceById(roleResourceId);
	}

	@Override
	public List<RoleResource> getAllRoleResources() {
		return roleResourceMapper.selectRoleResources();
	}

	@Override
	public List<RoleResource> getRoleResourcesByRoleId(int roleId) {
		return roleResourceMapper.selectRoleResourcesByRoleId(roleId);
	}

	@Override
	public Page<RoleResource> getRoleResourceByPage(Map<String, Object> params) {
		return roleResourceMapper.selectRoleResourcesByPage(params);
	}

	@Override
	public int deleteRoleResourceByRoleId(int roleId) {
		return roleResourceMapper.deleteRoleResourceByRoleId(roleId);
	}

}
