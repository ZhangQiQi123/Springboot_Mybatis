package com.zqq.mapper;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zqq.model.User;


public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(Map<String, Object> params);
    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUsers();
    /**
     * 分页获取用户信息
     * @return
     */
    Page<User> getUsersByPage(Map<String, Object> params);
    
    User selectByUserNameAndPwd(User user);
    
    int deleteUserById(Integer userId);
    
    User getUserByUserName(String userName);
    
    int updateUserPwd(User user);
    
    
}