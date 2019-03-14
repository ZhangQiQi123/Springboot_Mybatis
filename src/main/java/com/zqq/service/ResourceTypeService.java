package com.zqq.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zqq.model.ResourceType;

public interface ResourceTypeService {

int insertResourceType(ResourceType resourceType);
	
	int deleteResourceTypeById(int resourceTypeId);
	
	int updateResourceTypeById(ResourceType resourceType);
	
	ResourceType getResourceTypeById(int resourceTypeId);
	
	List<ResourceType> getResourceType();
	
	Page<ResourceType> getResourceTypeByPage(Map<String, Object> params);
}
