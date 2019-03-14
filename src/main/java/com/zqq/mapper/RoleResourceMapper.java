package com.zqq.mapper;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zqq.model.RoleResource;

public interface RoleResourceMapper {

	int insertRoleResource(RoleResource roleResource);
	
	int deleteRoleResourceById(int roleResourceId);
	
	int deleteRoleResourceByRoleId(int roleId);
	
	int updateRoleResourceById(int roleResourceId);
	
	RoleResource selectRoleResourceById(int roleResourceId);
	
	List<RoleResource> selectRoleResources();
	
	List<RoleResource> selectRoleResourcesByRoleId(int roleId);
	
	Page<RoleResource> selectRoleResourcesByPage(Map<String, Object> params);
}
