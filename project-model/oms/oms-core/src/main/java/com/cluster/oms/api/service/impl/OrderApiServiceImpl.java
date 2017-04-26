package com.cluster.oms.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluster.framework.dto.ResultDto;
import com.cluster.oms.api.service.OrderApiService;
import com.cluster.oms.api.vo.OrderApiVo;
import com.cluster.oms.mapper.OrderMapper;

/**
 * 系统菜单对外发布接口实现类
 * 
 * @className SysMenuApiServiceImpl.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 下午2:28:08
 * @version   1.0
 */
@Service
public class OrderApiServiceImpl implements OrderApiService{
	
	
	@Autowired
	private OrderMapper orderMapper;

	public ResultDto<String> insert(OrderApiVo order) {
		ResultDto<String> dto = null;
		try {
			dto = new ResultDto<String>();
			orderMapper.insert(order);
			dto.setCode(ResultDto.OK_CODE);
			dto.setData("成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
