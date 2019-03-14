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
import com.zqq.mapper.ResourceMapper;
import com.zqq.model.Resource;
import com.zqq.service.ResourceService;
import com.zqq.util.PageInfo;

@Controller
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	@RequestMapping("/getAllResource")
	@ResponseBody
	public Map<String, Object> getAllResource(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		List<Resource> resources=resourceService.getAllResources();
		String msg;
		if (resources!=null) {
			msg="success";
		}else{
			msg="error";
		}
		map.put("msg", msg);
		map.put("result", resources);
		return map;
	}
	
	@RequestMapping("/getResourceByPage")
	@ResponseBody
	public Object getResourceByPage(Integer pageNo,Integer pageSize,String resourceName,String resourceUrl,String createTime,HttpServletResponse response) throws ParseException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		if (createTime!="") {
			date=sdf.parse(createTime);
		}else{
			date=null;
		}
		Page<Resource> resources=resourceService.getResourceByPage(pageNo, pageSize, resourceName, resourceUrl, date);
		PageInfo<Resource> pageInfo=new PageInfo<>(resources);
		return pageInfo;
	}
	@RequestMapping("/getResourceByParamater")
	@ResponseBody
	public Object getResourceByParamater(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Resource> resources=resourceService.getResourceByParameterId();
		return resources;
	}
	@RequestMapping("/getResourceByResourceName")
	@ResponseBody
	public Object getResourceByResourceName(String resourceName,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Resource resource=resourceService.getResourceByResourceName(resourceName);
		return resource;
	}
}
