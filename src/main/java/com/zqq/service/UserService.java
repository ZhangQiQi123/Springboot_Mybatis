package com.zqq.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.zqq.model.User;

public interface UserService {
	
	int addUser(User user);

    List<User> findAllUserByPage(int pageNum, int pageSize);
    /**
     * 获取所有用户信息
     * @return
     */
    List<User> findAllUsers();
    /**
     * 分页查询
     * @param pageNo 当前页码
     * @param pageSize 每页显示记录数
     * @return
     */
//    Page<User> findByPage(int pageNo, int pageSize,User user);

    Page<User> findByPage(int pageNo, int pageSize,String userName,Integer roleId,Date createTime);
    
    User getUserById(Integer userId);
    
    int deleteUserById(Integer userId);
    
    User getUserByUserNameAndPwd(User user);
    
    int updateUserById(int userId,String userName,int roleId,String phone,Date updateTime);
    /**
     * 检查用户名是否存在
     * @param userName
     * @return
     */
    User checkUserName(String userName);
    /**
     * 修改用户密码
     * @param user
     * @return
     */
    int updateUserPwd(User user);
}
