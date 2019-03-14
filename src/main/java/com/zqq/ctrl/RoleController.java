package com.zqq.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.zqq.model.Role;
import com.zqq.model.User;
import com.zqq.service.RoleService;
import com.zqq.util.PageInfo;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	@RequestMapping("/getAllRoles")
	@ResponseBody
	public Map<String, Object> getAllRoles(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Role> roles=roleService.findAllRoles();
		Map<String, Object> map=new HashMap<String, Object>();
		String msg;
		if (roles!=null) {
			msg="success";
		}else{
			msg="faile";
		}
		map.put("msg", msg);
		map.put("result", roles);
		return map;
	}
	@RequestMapping("/getRoleById")
	@ResponseBody
	public Map<String, Object> getRoleById(Role role){
		Map<String, Object> map=new HashMap<String, Object>();
		int roleId=role.getRoleId();
		role=roleService.getRoleById(roleId);
		String msg;
		if (role!=null) {
			msg="success";
		}else{
			msg="faile";
		}
		map.put("msg", msg);
		map.put("result", role);
		return map;
	}
	@RequestMapping("/getRolesByPages")
	@ResponseBody
	public Object getRolesByPages(HttpServletResponse response,Integer pageNo,Integer pageSize,String roleName,String createTime) throws ParseException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		if (createTime!="") {
			date=sdf.parse(createTime);
		}else{
			date=null;
		}
		Page<Role> roles=roleService.getRolesByPage(pageNo, pageSize, roleName, date);
		// 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
		PageInfo<Role> pageInfo = new PageInfo<>(roles);
		return pageInfo;
	}
	
	@RequestMapping("/getRoleByRoleName")
	@ResponseBody
	public Map<String, Object> getRoleByRoleName(String roleName,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		Role role=roleService.getRoleByRoleName(roleName);
		String msg;
		if (role!=null) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		map.put("result", role);
		return map;
	}
	
	@RequestMapping("/addRole")
	@ResponseBody
	public Map<String, Object> addRole(Role role,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		Date date=new Date();
		role.setCreateTime(date);
		role.setUpdateTime(date);
		int result=roleService.addRole(role);
		String msg;
		if (result>0) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("/deleteRoleById")
	@ResponseBody
	public Map<String, Object> deleteRoleById(int roleId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		String msg;
		int result=roleService.deleteRoleById(roleId);
		if (result>0) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		return map;
	}
	
}
