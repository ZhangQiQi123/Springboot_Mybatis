package com.zqq.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zqq.common.myBatis.BaseMapper;
import com.zqq.common.service.BaseService;

import tk.mybatis.mapper.entity.Example;
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true,rollbackFor=Exception.class)
public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	protected BaseMapper<T> baseMapper;
	
	public BaseMapper<T> getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public List<T> selectAll() {
		return baseMapper.selectAll();
	}

	@Override
	public T selectByKey(Object key) {
		return baseMapper.selectByPrimaryKey(key);
	}
	
	@Override
	@Transactional
	public int save(T entity) {
		return baseMapper.insert(entity);
	}

	@Override
	public int delete(Object key) {
		return baseMapper.deleteByPrimaryKey(key);
	}

	@Override
	@Transactional
	public int batchDelete(List<String> list, String property, Class<T> clazz) {
		Example example=new Example(clazz);
		example.createCriteria().andIn(property, list);
		return baseMapper.deleteByExample(example);
	}

	@Override
	@Transactional
	public int updateAll(T entity) {
		return baseMapper.updateByPrimaryKey(entity);
	}

	@Override
	@Transactional
	public int updateNotNull(T entity) {
		return baseMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public List<T> selectByExample(Object example) {
		return baseMapper.selectByExample(example);
	}

}
