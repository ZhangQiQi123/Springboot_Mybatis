package com.zqq.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.zqq.model.Role;

public interface RoleService {
	int addRole(Role role);

//    List<Role> findAllRoleByPage(int pageNum, int pageSize);
    
    List<Role> findAllRoles();
    
    Role getRoleById(Integer roleId);
    
    int deleteRoleById(Integer roleId);
    
    Role getRoleByUserNameAndPwd(Role role);
    
    Page<Role> getRolesByPage(int pageNo, int pageSize,String roleName,Date createTime);
    /**
     * 判断角色名是否存在
     * @param roleName
     * @return
     */
    Role getRoleByRoleName(String roleName);
    
}
