package com.cluster.wms.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cluster.framework.dto.ResultDto;
import com.cluster.framework.mapper.BaseMapper;
import com.cluster.framework.service.impl.BaseServiceImpl;
import com.cluster.oms.api.service.OrderApiService;
import com.cluster.oms.api.vo.OrderApiVo;
import com.cluster.wms.mapper.CommoditySkuMapper;
import com.cluster.wms.model.CommoditySku;
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
    
	@Override
	public BaseMapper getMapper() {
		return commoditySkuMapper;
	}

	public ResultDto<String> proOrderByDubbo(String id,String userId) {
		CommoditySku sku = commoditySkuMapper.selectByPrimaryKey(id);
		
		if(sku.getQty()<1){
			ResultDto<String> dto = new ResultDto<String>();
			dto.setCode(ResultDto.VALIDATE_CODE);
			dto.setData("库存不足");
			return dto;
		}
		
		//1.扣减库存
		commoditySkuMapper.updateQty(id);
		//2.增加订单记录
		OrderApiVo order = new OrderApiVo();
		order.setId(UUID.randomUUID().toString().replace("-", ""));
		order.setBarcode(sku.getBarcode());
		order.setComCode(sku.getComCode());
		order.setName(sku.getName());
		order.setQty(1);
		order.setSkuCode(sku.getSkuCode());
		order.setTitle(sku.getTitle());
		order.setUserId(userId);
		return orderApiService.insert(order);
		
		
	}

	public ResultDto<String> proOrderByMQ(String id, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}