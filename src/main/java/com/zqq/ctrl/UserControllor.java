package com.zqq.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.zqq.config.JdbcConfig;
import com.zqq.model.User;
import com.zqq.service.UserService;
import com.zqq.test.Application;

@Controller
public class UserControllor {
	public static final Logger log=Logger.getLogger(UserControllor.class);
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping("/getAllUser")
	public String getAllUsers(Model model){
		List<User> users=userService.findAllUsers();
		model.addAttribute("users",users);
		log.info("访问第一个页面");
		return "user/showAllUsers";
	}
	@RequestMapping("/addUser")
	public String login(Model model){
		
		log.info("添加用户页面");
		return "user/addUser";
	}
	@RequestMapping("/showAllUsers")
	public String addUser(User user){
		int result=userService.addUser(user);
		if (result>0) {
			return "redirect:getAllUser";
		}else{
			return "500";
		}
	}
	@RequestMapping("/deleteById")
	public String deleteUserById(User user,Model model){
		int result=userService.deleteUserById(user.getUserId());
		if (result>0) {
			return "redirect:getAllUser";
		}else{
			return "500";
		}
	}
	@RequestMapping("/getUserById")
	public String getUserById(User user,Model model){
		user=userService.getUserById(user.getUserId());
		if (user!=null) {
			model.addAttribute("user",user);
			return "user/userInfo";
		}else{
			return "500";
		}
	}
}
