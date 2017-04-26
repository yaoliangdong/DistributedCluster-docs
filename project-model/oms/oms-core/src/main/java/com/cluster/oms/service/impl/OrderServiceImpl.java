package com.cluster.oms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cluster.framework.mapper.BaseMapper;
import com.cluster.framework.service.impl.BaseServiceImpl;
import com.cluster.oms.mapper.OrderMapper;
import com.cluster.oms.service.OrderService;

/**
 * 
 * @author  liangdong.yao
 * @date    2017-04-26 10:21:16
 * @version 1.0.0
 */
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

	@Override
	public BaseMapper getMapper() {
		return orderMapper;
	}

    
}