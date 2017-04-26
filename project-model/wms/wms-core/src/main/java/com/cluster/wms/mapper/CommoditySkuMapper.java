package com.cluster.wms.mapper;

import org.apache.ibatis.annotations.Param;

import com.cluster.framework.mapper.BaseMapper;

/**
 * commodity_sku数据库操作接口
 * 
 * @author  liangdong.yao
 * @date    2017-04-26 11:12:10
 * @version 1.0.0
 */
public interface CommoditySkuMapper extends BaseMapper {

	/**
	 * 扣减库存
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 上午11:33:36
	 * @version 1.0
	 */
	public void updateQty(@Param("id") String id);
}