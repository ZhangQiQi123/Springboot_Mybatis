package com.zqq.mapper;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zqq.model.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer roleId);

    int insert(Role role);

    int insertSelective(Role role);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role role);

    int updateByPrimaryKey(Role role);
    
    List<Role> getAllRoles();
    
    Role selectByUserNameAndPwd(Role role);
    /**
     * 分页获取角色信息
     * @return
     */
    Page<Role> getRolesByPage(Map<String, Object> params);
    
    Role getRoleByRoleName(String roleName);
}
