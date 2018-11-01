package com.zqq.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zqq.model.User;
import com.zqq.service.UserService;

@RestController
@RequestMapping("/user")
public class UserControllor {

	@Resource
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/getAllUser")
	public List<User> getAllUsers(){
		List<User> users=userService.findAllUsers();
		return users;
	}
}
