package com.zqq.mapper;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zqq.model.Resource;

public interface ResourceMapper {

	int insertResource(Resource resource);
	
	int deleteResourceById(String resourceId);
	
	int updateResourceById(Resource resource);
	
	Resource selectResourceById(String resourceId);
	
	List<Resource> selectAllResources();
	
	List<Resource> selectResourceByType(int resourceTypeId);
	
	List<Resource> selectResourceByResourceId(String resourceId);
	
	List<Resource> selectResourceByParameterId();
	
	Resource selectResourceByResourceName(String resourceName);
	
	Page<Resource> selectAllResourceByPage(Map<String, Object> params);
}
