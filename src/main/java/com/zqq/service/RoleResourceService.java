package com.zqq.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zqq.model.RoleResource;

public interface RoleResourceService {
	
	int addRoleResource(RoleResource roleResource);
	
	int deleteRoleResourceById(int roleResourceId);
	
	int deleteRoleResourceByRoleId(int roleId);
	
	int updateRoleResourceById(int roleResourceId);
	
	RoleResource getRoleResourceById(int roleResourceId);
	
	List<RoleResource> getAllRoleResources();
	
	List<RoleResource> getRoleResourcesByRoleId(int roleId);
	
	Page<RoleResource> getRoleResourceByPage(Map<String, Object> params);
}
