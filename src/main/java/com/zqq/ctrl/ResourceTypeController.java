package com.zqq.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqq.model.ResourceType;
import com.zqq.service.ResourceTypeService;

@Controller
public class ResourceTypeController {

	@Autowired
	private ResourceTypeService resourceTypeService;

	public void setResourceTypeService(ResourceTypeService resourceTypeService) {
		this.resourceTypeService = resourceTypeService;
	}
	
	@RequestMapping("/getAllResourceType")
	@ResponseBody
	public Map<String, Object> getAllResourceType(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		List<ResourceType> resourceTypes=resourceTypeService.getResourceType();
		String msg;
		if (resourceTypes!=null) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		map.put("result", resourceTypes);
		return map;
	}
}
