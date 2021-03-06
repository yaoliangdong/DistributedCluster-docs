package com.cluster.framework.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cluster.framework.mapper.BaseMapper;
import com.cluster.framework.service.BaseService;

/**
 * 基础service抽象类
 * 
 * @className BaseServiceImpl.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 上午11:24:15
 * @version   1.0
 */
public abstract class BaseServiceImpl implements BaseService{

	public abstract BaseMapper getMapper();
	
	@Transactional
	public <T> int deleteById(T entity) throws RuntimeException {
		try {
			return getMapper().deleteByPrimarayKeyForModel(entity);
		} catch (Exception e) {
			throw new RuntimeException("",e);
		}
	}

	@Transactional
	public <T> int add(T entity) throws RuntimeException {
		try {
			return getMapper().insertSelective(entity);
		} catch (Exception e) {
			throw new RuntimeException("",e);
		}
	}

	public <T> T findById(T entity) throws RuntimeException {
		try {
			return (T) getMapper().selectByPrimaryKey(entity);
		} catch (Exception e) {
			throw new RuntimeException("",e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(String id) throws RuntimeException {
		try {
			return (T) getMapper().selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException("",e);
		}
	}
	
	public <T> List<T> findByBiz(Map<String, Object> params) throws RuntimeException {
		try {
			return getMapper().selectByParams(params);
		} catch (Exception e) {
			throw new RuntimeException("",e);
		}
	}

	@Transactional
	public <T> int modifyById(T entity) throws RuntimeException {
		try {
			return getMapper().updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new RuntimeException("",e);
		}
	}

	public int findCount(Map<String,Object> params) throws RuntimeException {
		try {
			return getMapper().selectCount(params);
		} catch (Exception e) {
			throw new RuntimeException("",e);
		}
	}
	
}
