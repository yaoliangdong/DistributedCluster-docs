package com.cluster.framework.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 基础数据库操作接口
 * 
 * @className BaseMapper.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 上午11:21:44
 * @version   1.0
 */
public interface BaseMapper {

	public int deleteByPrimaryKey(String id);
	
	public <T> int insert(T entity);
	
	public <T> int insertSelective(T entity);
	
	public <T> T selectByPrimaryKey(T entity);
	public <T> T selectByPrimaryKey(String id);
	
	public <T> List<T> selectByParams(@Param("params") Map<String, Object> params);
	
	public <T> int updateByPrimaryKeySelective(T entity);
	
	public <T> int updateByPrimaryKey(T entity);
	
	public int selectCount(@Param("params") Map<String, Object> params);
	
	public <T> int deleteByPrimarayKeyForModel(T entity);
}
