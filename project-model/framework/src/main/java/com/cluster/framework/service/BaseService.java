package com.cluster.framework.service;

import java.util.List;
import java.util.Map;

/**
 * 基础service接口
 * 
 * @className BaseService.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 上午11:24:02
 * @version   1.0
 */
public interface BaseService {

	public <T> int deleteById(T modelType) throws RuntimeException;

	public <T> int add(T modelType) throws RuntimeException;
	
	public <T> T findById(T modelType) throws RuntimeException;
	public <T> T findById(String id) throws RuntimeException;
	
	/**
	 * 根据参数查询
	 * 
	 * @param modelType 固定参数
	 * @param params    页面其他参数
	 * @return
	 * @throws RunTimeException
	 */
	public <T> List<T> findByBiz(Map<String, Object> params) throws RuntimeException;

	/**
	 * 根据id修改实体
	 * 
	 * @param modelType
	 * @return
	 * @throws RunTimeException
	 */
	public <T> int modifyById(T modelType) throws RuntimeException;

	/**
	 * 根据参数查询总记录数
	 * 
	 * @param params
	 * @return
	 * @throws RunTimeException
	 */
	public int findCount(Map<String, Object> params) throws RuntimeException;

}
