package com.zqq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.zqq.mapper.ResourceTypeMapper;
import com.zqq.model.ResourceType;
import com.zqq.service.ResourceTypeService;
@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {

	@Autowired
	private ResourceTypeMapper resourceTypeMapper;
	
	
	
	public void setResourceTypeMapper(ResourceTypeMapper resourceTypeMapper) {
		this.resourceTypeMapper = resourceTypeMapper;
	}

	@Override
	public int insertResourceType(ResourceType resourceType) {
		return resourceTypeMapper.insertResourceType(resourceType);
	}

	@Override
	public int deleteResourceTypeById(int resourceTypeId) {
		return resourceTypeMapper.deleteResourceTypeById(resourceTypeId);
	}

	@Override
	public int updateResourceTypeById(ResourceType resourceType) {
		return resourceTypeMapper.updateResourceTypeById(resourceType);
	}

	@Override
	public ResourceType getResourceTypeById(int resourceTypeId) {
		return resourceTypeMapper.selectResourceTypeById(resourceTypeId);
	}

	@Override
	public List<ResourceType> getResourceType() {
		return resourceTypeMapper.selectResourceType();
	}

	@Override
	public Page<ResourceType> getResourceTypeByPage(Map<String, Object> params) {
		return resourceTypeMapper.selectResourceTypeByPage(params);
	}

}
