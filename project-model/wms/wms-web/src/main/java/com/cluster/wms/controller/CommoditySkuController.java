package com.cluster.wms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cluster.framework.dto.ResultDto;
import com.cluster.wms.model.CommoditySku;
import com.cluster.wms.service.CommoditySkuService;


/**
 * 商品信息
 * @className CommoditySkuController.java
 * @author    liangdong.yao
 * @Date      2017年4月26日 上午9:41:46
 * @version   1.0
 */
@Controller
@RequestMapping("commoditySku")
public class CommoditySkuController {
	
	@Autowired
	private CommoditySkuService commoditySkuService;
	

	/**
	 * 商品列表
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 上午9:42:06
	 * @version 1.0
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,ModelMap map){
		
		List<CommoditySku> list = commoditySkuService.findByBiz(null);
		map.addAttribute("list", list);
		
		return "commoditySku/list";
	}
	
	/**
	 * 下单 走dubbo中间件
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 上午11:23:11
	 * @version 1.0
	 * @throws IOException 
	 */
	@RequestMapping("proOrderByDubbo")
	public String proOrderByDubbo(HttpServletRequest request,HttpServletResponse response,String id) throws IOException{
		
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();  
		Map attributes = principal.getAttributes();  
		String name=(String) attributes .get("name");
		
		ResultDto<String> dto = commoditySkuService.proOrderByDubbo(id,name);
		if(!ResultDto.OK_CODE.equals(dto.getCode())){
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<h1 style=\"color:red\">"+dto.getData()+"</h1>");
			out.close();
		}
		
		return "redirect:/commoditySku/list.do";
	}
	
	/**
	 * 下单 走MQ中间件
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 上午11:23:27
	 * @version 1.0
	 */
	@RequestMapping("proOrderByMQ")
	public String proOrderByMQ(HttpServletResponse response,String id){
		
		
		return "redirect:/list.do";
	}
}
