package com.zqq.mapper;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zqq.model.ResourceType;

public interface ResourceTypeMapper {
	
	int insertResourceType(ResourceType resourceType);
	
	int deleteResourceTypeById(int resourceTypeId);
	
	int updateResourceTypeById(ResourceType resourceType);
	
	ResourceType selectResourceTypeById(int resourceTypeId);
	
	List<ResourceType> selectResourceType();
	
	Page<ResourceType> selectResourceTypeByPage(Map<String, Object> params);
}
