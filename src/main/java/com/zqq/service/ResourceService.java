package com.zqq.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.zqq.model.Resource;

public interface ResourceService {

	/**
	 * 添加
	 * @param resource
	 * @return
	 */
	int addResource(Resource resource);
	/**
	 * 删除
	 * @param resourceId
	 * @return
	 */
	int deleteResourceId(String resourceId);
	/**
	 * 修改
	 * @param resource
	 * @return
	 */
	int updateResourceTyId(Resource resource);
	/**
	 * 查询实体
	 * @param resourceId
	 * @return
	 */
	Resource getResourceById(String resourceId);
	/**
	 * 查询所有
	 * @return
	 */
	List<Resource> getAllResources();
	/**
	 * 根据权限类型查询
	 * @param resourceTypeId
	 * @return
	 */
	List<Resource> getResourceByTypeId(int resourceTypeId);
	/**
	 * 根据ID查询
	 * @param resourceId
	 * @return
	 */
	List<Resource> getResourceByResourceId(String resourceId);
	/**
	 * 获取父节点
	 * @return
	 */
	List<Resource> getResourceByParameterId();
	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	Page<Resource> getResourceByPage(Integer pageNo,Integer pageSize,String resourceName,String resourceUrl,Date createTime);
	/**
	 * 根据权限名称查询
	 * @param resourceName
	 * @return
	 */
	Resource getResourceByResourceName(String resourceName);
}
