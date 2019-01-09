package com.zqq.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

	@Override
	public User getUserByUserNameAndPwd(User user) {
		return userMapper.selectByUserNameAndPwd(user);
	}

	@Override
	public int updateUserById(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public Page<User> findByPage(int pageNo, int pageSize,String userName,Integer roleId,Date createTime) {
		PageHelper.startPage(pageNo, pageSize);
		Map<String, Object> params=new HashMap<>();
		params.put("userName", userName);
		params.put("roleId", roleId);
		params.put("createTime", createTime);
        return userMapper.getUsersByPage(params);
	}

}
