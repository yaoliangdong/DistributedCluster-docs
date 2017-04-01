package com.cluster.wms.controller;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cluster.wms.mapper.DaoTestMapper;

/**
 * cas登录与注销测试
 * @className CasTestController.java
 * @author    liangdong.yao
 * @Date      2017年3月23日 下午4:38:22
 * @version   1.0
 */
@Controller
@RequestMapping("/casTest")
public class CasTestController {
	
	@Autowired
	private DaoTestMapper daoTestMapper;
	
	
	@Autowired
	private RedisTemplate<Serializable,Object> redisTemplate;
	
	/**
	 * 登录成功页
	 * @author  liangdong.yao
	 * @Date    2017年3月23日 下午4:38:25
	 * @version 1.0
	 */
	@RequestMapping("/index")
	public void test(HttpServletRequest request,HttpServletResponse response){
		try {
			AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();  
			Map attributes = principal.getAttributes();  
			String name=(String) attributes .get("name");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			//db连接测试
			List<Map> dbTest = daoTestMapper.selectTest();
			//redis集群连接测试
			redisTemplate.opsForValue().setIfAbsent("testKey", "testValue");
			String redisTest = (String) redisTemplate.opsForValue().get("testKey");
			
			out.print("<h1>welcome,"+principal.getName()+","+name+"</h1>");
			out.print("test db connection:"+dbTest);
			out.print("<br />test redis connection:"+redisTest);
			out.print("<a href='logout.do'><h1>logout...</h1></a>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 注销登录
	 * @author  liangdong.yao
	 * @Date    2017年3月23日 下午4:38:08
	 * @version 1.0
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		//1.注销应用的session 2.注销cas(跳转到cas-server的logout方法) 3.重定向到service参数值地址
		session.invalidate();
		return "redirect:https://cas.cluster.com:8060/cas/logout?service=http://wms.cluster.com:8050/wms-web/casTest/index.do";
	}
}
