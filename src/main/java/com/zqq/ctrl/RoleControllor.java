package com.zqq.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqq.model.Role;
import com.zqq.service.RoleService;

@Controller
public class RoleControllor {
	
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
	
}
