package com.zqq.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.Page;
import com.zqq.model.Role;
import com.zqq.model.User;
import com.zqq.service.UserService;
import com.zqq.util.PageInfo;

@Controller
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping("/index")
	public String index(Model model){

		log.info("访问首页");
		return "index";
	}
	
	@RequestMapping("/getAllUser")
	public String getAllUsers(Model model){
		List<User> users=userService.findAllUsers();
		model.addAttribute("users",users);
		log.info("访问第一个页面");
		return "user/showAllUsers";
	}
	
	
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String, Object> addUser(User user,Role role, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		Date createTime=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setCreateTime(createTime);
		user.setUpdateTime(createTime);
		user.setRole(role);
		int result=userService.addUser(user);
		String msg;
		if (result>0) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("/deleteUserById")
	@ResponseBody
	public Map<String, Object> deleteUserById(int userId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		String msg;
		int result=userService.deleteUserById(userId);
		if (result>0) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		return map;
	}

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
	@RequestMapping("/updateUserInfoById")
	@ResponseBody
	public Map<String, Object> updateUserInfoById(int userId,String userName,int roleId,String phone,HttpServletResponse response) throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<String,Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date updateTime=sdf.parse(sdf.format(new Date()));
		String msg;
		int result=userService.updateUserById(userId,userName,roleId,phone,updateTime);
		if (result>0) {
			msg="success";
		}else{
			msg="faile";
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("/updateUserPwdById")
	@ResponseBody
	public Map<String, Object> updateUserPwdById(User user,HttpServletResponse response) throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<String,Object>();
		Date updateTime=new Date();
		user.setUpdateTime(updateTime);
		String msg;
		int result=userService.updateUserPwd(user);
		if (result>0) {
			msg="success";
		}else{
			msg="faile";
		}
		map.put("msg", msg);
		return map;
	}
	/**
	 * 
	 * @param response
	 * @param pageNo 当前页
	 * @param pageSize 每页显示记录数
	 * @param userName
	 * @param roleId
	 * @param createTime
	 * @return
	 * @throws Exception
	 * @throws ParseException
	 */
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
		return pageInfo;
	}
	@RequestMapping("/getUserByUserName")
	@ResponseBody
	public Map<String, Object> getUserByUserName(String userName,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		User user=userService.checkUserName(userName);
		String msg="";
		if (user!=null) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		map.put("user", user);
		return map;
	}
	
}
