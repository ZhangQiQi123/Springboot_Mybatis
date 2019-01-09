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

    int updateByPrimaryKey(User record);
    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUsers();
    /**
     * 分页获取用户
     * @return
     */
    Page<User> getUsersByPage(Map<String, Object> params);
    
    User selectByUserNameAndPwd(User user);
}