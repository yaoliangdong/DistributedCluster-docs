package com.cluster.oms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cluster.oms.api.vo.OrderApiVo;
import com.cluster.oms.service.OrderService;



/**
 * 订单信息
 * @className OrderController.java
 * @author    liangdong.yao
 * @Date      2017年4月26日 上午10:24:57
 * @version   1.0
 */
@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	

	
	/**
	 * 订单列表
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 上午10:25:03
	 * @version 1.0
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,ModelMap map){
		
		List<OrderApiVo> list = orderService.findByBiz(null);
		map.addAttribute("list", list);
		
		return "order/list";
	}
	

	
}
