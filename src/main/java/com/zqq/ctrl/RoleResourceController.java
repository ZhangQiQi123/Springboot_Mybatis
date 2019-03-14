package com.zqq.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqq.model.Resource;
import com.zqq.model.RoleResource;
import com.zqq.service.ResourceService;
import com.zqq.service.RoleResourceService;

@Controller
public class RoleResourceController {

	@Autowired
	private RoleResourceService roleResourceService;
	@Autowired
	private ResourceService resourceService;

	public void setRoleResourceService(RoleResourceService roleResourceService) {
		this.roleResourceService = roleResourceService;
	}
	
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@RequestMapping("/getRoleResourceByRoleId")
	@ResponseBody
	public Map<String, Object> getRoleResourceByRoleId(int roleId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		List<RoleResource> roleResources=roleResourceService.getRoleResourcesByRoleId(roleId);
		String msg;
		if (roleResources!=null) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		map.put("result", roleResources);
		return map;
	}
	
	@RequestMapping("/deleteRoleResourceByRoleId")
	@ResponseBody
	public Map<String, Object> deleteRoleResourceByRoleId(int roleId, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		String msg;
		int result=roleResourceService.deleteRoleResourceByRoleId(roleId);
		if (result>=0) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", "success");
		return map;
	}
	
	@RequestMapping("/addRoleResource")
	@ResponseBody
	public Map<String, Object> addRoleResource(int roleId,String resourceId, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		String msg="";
		if (resourceId.length()==3) {
			//查询权限表中resourceId like 这个字符串的，的所有resourceId
			List<Resource> resources=resourceService.getResourceByResourceId(resourceId);
			if (resources!=null) {
				for (Resource resource : resources) {
					RoleResource roleResource=new RoleResource();
					roleResource.setRoleId(roleId);
					roleResource.setResourceId(resource.getResourceId());
					int result=roleResourceService.addRoleResource(roleResource);
					if (result>0) {
						msg="success";
					}else{
						msg="error";
					}
				}
			}
		}else{
			RoleResource roleResource=new RoleResource();
			roleResource.setRoleId(roleId);
			roleResource.setResourceId(resourceId);
			int result=roleResourceService.addRoleResource(roleResource);
			if (result>0) {
				msg="success";
			}else{
				msg="error";
			}
		}
		map.put("msg", msg);
		return map;
	}
	
}
