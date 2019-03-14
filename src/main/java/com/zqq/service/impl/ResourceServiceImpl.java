package com.zqq.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zqq.mapper.ResourceMapper;
import com.zqq.model.Resource;
import com.zqq.service.ResourceService;
import com.zqq.util.PageInfo;
@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceMapper resourceMapper;
	
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}

	@Override
	public int addResource(Resource resource) {
		return resourceMapper.insertResource(resource);
	}

	@Override
	public int deleteResourceId(String resourceId) {
		return resourceMapper.deleteResourceById(resourceId);
	}

	@Override
	public int updateResourceTyId(Resource resource) {
		return resourceMapper.updateResourceById(resource);
	}

	@Override
	public Resource getResourceById(String resourceId) {
		return resourceMapper.selectResourceById(resourceId);
	}

	@Override
	public List<Resource> getAllResources() {
		return resourceMapper.selectAllResources();
	}

	@Override
	public Page<Resource> getResourceByPage(Integer pageNo,Integer pageSize,String resourceName,String resourceUrl,Date createTime) {
		PageHelper.startPage(pageNo, pageSize);
		Map<String, Object> params=new HashMap<>();
		params.put("pageNo", pageNo);
		params.put("pageSize", pageSize);
		params.put("resourceName", resourceName);
		params.put("resourceUrl", resourceUrl);
		params.put("createTime", createTime);
		return resourceMapper.selectAllResourceByPage(params);
	}

	@Override
	public List<Resource> getResourceByTypeId(int resourceTypeId) {
		return resourceMapper.selectResourceByType(resourceTypeId);
	}

	@Override
	public List<Resource> getResourceByResourceId(String resourceId) {
		return resourceMapper.selectResourceByResourceId(resourceId);
	}

	@Override
	public List<Resource> getResourceByParameterId() {
		return resourceMapper.selectResourceByParameterId();
	}

	@Override
	public Resource getResourceByResourceName(String resourceName) {
		return resourceMapper.selectResourceByResourceName(resourceName);
	}

}
