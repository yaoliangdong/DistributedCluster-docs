package com.cluster.wms.service;

import com.cluster.framework.dto.ResultDto;
import com.cluster.framework.service.BaseService;

/**
 * commodity_sku数据库操作接口
 * 
 * @author  liangdong.yao
 * @date    2017-04-26 09:37:53
 * @version 1.0.0
 */
public interface CommoditySkuService extends BaseService {

	/**
	 * 下单 走dubbo中间件
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 上午11:27:21
	 * @version 1.0
	 */
	public ResultDto<String> sendOrderByDubbo(String id,String userId);
	
	/**
	 * 下单 走MQ中间件
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 上午11:27:23
	 * @version 1.0
	 */
	public ResultDto<String> sendOrderByMQ(String id,String userId);
}