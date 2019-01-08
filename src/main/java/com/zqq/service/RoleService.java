package com.zqq.service;

import java.util.List;

import com.zqq.model.Role;

public interface RoleService {
	int addRole(Role role);

//    List<Role> findAllRoleByPage(int pageNum, int pageSize);
    
    List<Role> findAllRoles();
    
    Role getRoleById(Integer roleId);
    
    int deleteRoleById(Integer roleId);
    
    Role getRoleByUserNameAndPwd(Role role);
}
