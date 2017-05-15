package com.cluster.wms.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cluster.framework.dto.ResultDto;
import com.cluster.framework.mapper.BaseMapper;
import com.cluster.framework.service.impl.BaseServiceImpl;
import com.cluster.oms.api.service.OrderApiService;
import com.cluster.oms.api.vo.OrderApiVo;
import com.cluster.wms.api.vo.OrderMqApiVo;
import com.cluster.wms.mapper.CommoditySkuMapper;
import com.cluster.wms.model.CommoditySku;
import com.cluster.wms.mq.producer.OrderMqApiService;
import com.cluster.wms.service.CommoditySkuService;

/**
 * 
 * @author  liangdong.yao
 * @date    2017-04-26 09:37:53
 * @version 1.0.0
 */
@Service("commoditySkuService")
public class CommoditySkuServiceImpl extends BaseServiceImpl implements CommoditySkuService {

    @Resource
    private CommoditySkuMapper commoditySkuMapper;
    
    @Resource
    private OrderApiService orderApiService;
    
    @Resource
    private OrderMqApiService orderMqApiService; 
    
	@Override
	public BaseMapper getMapper() {
		return commoditySkuMapper;
	}

	public ResultDto<String> sendOrderByDubbo(String id,String userId) {
		CommoditySku sku = commoditySkuMapper.selectByPrimaryKey(id);
		
		if(sku.getQty()<1){
			ResultDto<String> dto = new ResultDto<String>();
			dto.setCode(ResultDto.VALIDATE_CODE);
			dto.setData("库存不足");
			return dto;
		}
		
		//1.扣减库存
		commoditySkuMapper.updateQty(id);
		//2.增加订单记录   调用dubbo示例
		OrderApiVo orderApiVo = new OrderApiVo();
		orderApiVo.setId(UUID.randomUUID().toString().replace("-", ""));
		orderApiVo.setBarcode(sku.getBarcode());
		orderApiVo.setComCode(sku.getComCode());
		orderApiVo.setName(sku.getName());
		orderApiVo.setQty(1);
		orderApiVo.setSkuCode(sku.getSkuCode());
		orderApiVo.setTitle(sku.getTitle());
		orderApiVo.setUserId(userId);
		return orderApiService.sendOrder(orderApiVo);
	}

	public ResultDto<String> sendOrderByMQ(String id, String userId) {
		CommoditySku sku = commoditySkuMapper.selectByPrimaryKey(id);
		
		if(sku.getQty()<1){
			ResultDto<String> dto = new ResultDto<String>();
			dto.setCode(ResultDto.VALIDATE_CODE);
			dto.setData("库存不足");
			return dto;
		}
		
		//1.扣减库存
		commoditySkuMapper.updateQty(id);
		//2.增加订单记录   走MQ示例
		OrderMqApiVo orderMqApiVo = new OrderMqApiVo();
		orderMqApiVo.setId(UUID.randomUUID().toString().replace("-", ""));
		orderMqApiVo.setBarcode(sku.getBarcode());
		orderMqApiVo.setComCode(sku.getComCode());
		orderMqApiVo.setName(sku.getName());
		orderMqApiVo.setQty(1);
		orderMqApiVo.setSkuCode(sku.getSkuCode());
		orderMqApiVo.setTitle(sku.getTitle());
		orderMqApiVo.setUserId(userId);
		return orderMqApiService.sendOrder(orderMqApiVo);
	}

}