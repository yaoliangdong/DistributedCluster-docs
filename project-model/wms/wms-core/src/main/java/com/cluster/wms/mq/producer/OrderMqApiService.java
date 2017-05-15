package com.cluster.wms.mq.producer;

import com.cluster.framework.dto.ResultDto;
import com.cluster.wms.api.vo.OrderMqApiVo;



/**
 * 订单实现类 MQ
 * @className OrderMqApiService.java
 * @author    liangdong.yao
 * @Date      2017年5月12日 下午2:58:38
 * @version   1.0
 */
public interface OrderMqApiService {

	
	/**
	 * 下单 走MQ中间件
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 上午11:27:23
	 * @version 1.0
	 */
	public ResultDto<String> sendOrder(OrderMqApiVo orderMqApiVo);
}