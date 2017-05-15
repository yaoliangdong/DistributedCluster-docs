package com.cluster.oms.mq.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cluster.oms.service.OrderService;
import com.cluster.wms.api.vo.OrderMqApiVo;


/**
 * 订单MQ 消费者
 * @className OrderConsumer.java
 * @author    liangdong.yao
 * @Date      2017年5月12日 下午4:13:46
 * @version   1.0
 */
@Component
public class OrderConsumer {

	@Autowired
	private OrderService orderService;
	
	public void onMessage(OrderMqApiVo orderMqApiVo){
		
		System.out.println(orderMqApiVo);
		orderService.add(orderMqApiVo);
	}

}
