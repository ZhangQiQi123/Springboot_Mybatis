package com.zqq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqq.mapper.UserMapper;
import com.zqq.model.User;
import com.zqq.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}
	/*
	  * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
	  * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
	  * pageNum 开始页数
	  * pageSize 每页显示的数据条数
	  * */
	@Override
	public List<User> findAllUserByPage(int pageNum, int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);
		return userMapper.getAllUsers();
	}

	@Override
	public List<User> findAllUsers() {
		return userMapper.getAllUsers();
	}

	@Override
	public User getUserById(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int deleteUserById(Integer userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

}
