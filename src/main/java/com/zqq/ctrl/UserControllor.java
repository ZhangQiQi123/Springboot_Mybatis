package com.zqq.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
=======
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

<<<<<<< HEAD
import com.github.pagehelper.Page;
import com.zqq.mapper.UserMapper;
import com.zqq.model.Role;
import com.zqq.model.User;
import com.zqq.service.UserService;
import com.zqq.util.PageInfo;

@Controller
public class UserControllor {
	  public static final Logger log = LoggerFactory.getLogger(UserControllor.class);
	 


	
=======

import com.zqq.config.JdbcConfig;
import com.zqq.model.User;
import com.zqq.service.UserService;
import com.zqq.test.Application;

@Controller
public class UserControllor {
	public static final Logger log=Logger.getLogger(UserControllor.class);
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;

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
<<<<<<< HEAD
	@RequestMapping("/showAllUser")
	public String addUser(User user){
		user.setCreateTime(new Date());
=======
	@RequestMapping("/showAllUsers")
	public String addUser(User user){
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788
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
<<<<<<< HEAD
//	@RequestMapping("/getUserById")
//	public String getUserById(User user,Model model){
//		user=userService.getUserById(user.getUserId());
//		if (user!=null) {
//			model.addAttribute("user",user);
//			return "user/userInfo";
//		}else{
//			return "500";
//		}
//	}
	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(User user,ModelMap model,HttpServletResponse response,HttpSession session){
		response.setHeader("Access-Control-Allow-Origin", "*");
		User u=userService.getUserByUserNameAndPwd(user);
		Map<String, Object> map=new HashMap<String, Object>();
		String msg;
		User data;
		if (u!=null) {
			msg="success";
			session.setAttribute("loginUser",u);
			data=u;
		}else{
			msg="faile";
			data=null;
		}
		map.put("msg", msg);
		map.put("result", data);
		return map;
	}
	@RequestMapping("/logOut")
	@ResponseBody
	public Map<String, Object> logOut(HttpSession session,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<String, Object>();
		if (session.getAttribute("loginUser")!=null) {
			session.removeAttribute("loginUser");
		}		
		String msg="success";
		map.put("msg", msg);
		return map;
	}
	
	@RequestMapping("/getUserById")
	@ResponseBody
	public Map<String, Object> getUserById(User user,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<String,Object>();
		String msg;
		user=userService.getUserById(user.getUserId());
		if (user!=null) {
			msg="success";
		}else{
			msg="falile";
		}
		map.put("msg", msg);
		map.put("result", user);
		return map;
	}
	@RequestMapping("/updateUserPwdById")
	@ResponseBody
	public Map<String, Object> updateUserPwdById(User user,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<String,Object>();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			user.setUpdateTime(sdf.parse(sdf.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String msg;
		int result=userService.updateUserById(user);
		if (result>0) {
			msg="success";
		}else{
			msg="faile";
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("/getAllUserByPage")
	@ResponseBody
	public Object getAllUserByPage(HttpServletResponse response,Integer pageNo,Integer pageSize,String userName,String roleId,String createTime) throws Exception, ParseException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		if (createTime!="") {
			date=sdf.parse(createTime);
		}else{
			date=null;
		}
		Integer roleid;
		if (roleId!="") {
			roleid=Integer.parseInt(roleId);
		}else{
			roleid=null;
		}
		Page<User> users = userService.findByPage(pageNo, pageSize, userName, roleid, date);
		// 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
		PageInfo<User> pageInfo = new PageInfo<>(users);
		
		Map<String, Object> map=new HashMap<String,Object>();
		return pageInfo;
=======
	@RequestMapping("/getUserById")
	public String getUserById(User user,Model model){
		user=userService.getUserById(user.getUserId());
		if (user!=null) {
			model.addAttribute("user",user);
			return "user/userInfo";
		}else{
			return "500";
		}
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788
	}
}
