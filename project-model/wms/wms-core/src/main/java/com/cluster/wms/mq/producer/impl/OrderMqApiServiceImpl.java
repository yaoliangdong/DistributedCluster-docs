package com.cluster.wms.mq.producer.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluster.framework.dto.ResultDto;
import com.cluster.wms.api.vo.OrderMqApiVo;
import com.cluster.wms.constant.WmsQueuesConstant;
import com.cluster.wms.mq.producer.OrderMqApiService;




/**
 * 订单实现类 MQ
 * @className OrderMqApiServiceImpl.java
 * @author    liangdong.yao
 * @Date      2017年5月12日 下午3:00:37
 * @version   1.0
 */
@Service("orderMqApiService")
public class OrderMqApiServiceImpl implements OrderMqApiService {


	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public ResultDto<String> sendOrder(OrderMqApiVo orderMqApiVo) { 
		
		ResultDto<String> dto = null;
		try {
			dto = new ResultDto<String>();
			rabbitTemplate.convertAndSend(WmsQueuesConstant.QUEUE_ORDER, orderMqApiVo);
			dto.setCode(ResultDto.OK_CODE);
			dto.setData("成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}