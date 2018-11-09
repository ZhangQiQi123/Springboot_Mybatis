package com.zqq.service;

import java.util.List;

import com.zqq.model.User;

public interface UserService {
	
	int addUser(User user);

    List<User> findAllUserByPage(int pageNum, int pageSize);
    
    List<User> findAllUsers();
    
    User getUserById(Integer userId);
    
    int deleteUserById(Integer userId);
}
