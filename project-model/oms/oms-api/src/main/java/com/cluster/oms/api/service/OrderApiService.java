package com.cluster.oms.api.service;

import com.cluster.framework.dto.ResultDto;
import com.cluster.oms.api.vo.OrderApiVo;


/**
 * 订单外发布接口
 * 
 * @className OrderApiService.java
 * @author    liangdong.yao
 * @Date      2017年4月26日 下午1:42:40
 * @version   1.0
 */
public interface OrderApiService {

	
	/**
	 * 插入订单信息
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 下午1:43:14
	 * @version 1.0
	 */
	public ResultDto<String> insert(OrderApiVo order);
    
}