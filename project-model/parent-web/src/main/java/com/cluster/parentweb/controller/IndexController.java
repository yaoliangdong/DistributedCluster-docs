package com.cluster.parentweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cluster.basedata.api.service.SysMenuApiService;
import com.cluster.basedata.api.vo.SysMenuApiVo;
import com.cluster.framework.constant.Constant;
import com.cluster.framework.dto.ResultDto;
import com.cluster.framework.util.RedisUtil;

/**
 * 总控制器
 * 
 * @className IndexController.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 下午2:43:36
 * @version   1.0
 */
@Controller
public class IndexController {
	
	@Autowired
	private SysMenuApiService sysMenuApiService;
	
	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 去到首页
	 * @author  liangdong.yao
	 * @Date    2017年4月7日 下午2:43:55
	 * @version 1.0
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request,ModelMap map){
		
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();  
		Map attributes = principal.getAttributes();
		String userId = (String)attributes.get("id");
		
		List<SysMenuApiVo> sysMenuList = redisUtil.get(Constant.REDIS_KEY_USER_SYS_MENU_+userId,List.class);
		
		if(null == sysMenuList || sysMenuList.size()==0){
			//调用dubbo服务 获取当前登录用户菜单
			ResultDto<List<SysMenuApiVo>> dto = sysMenuApiService.getSysMenu(null);
			if(ResultDto.OK_CODE.equals(dto.getCode())){
				sysMenuList = dto.getData();
				//将菜单存入redis缓存
				redisUtil.set(Constant.REDIS_KEY_USER_SYS_MENU_+userId, sysMenuList,99999L);
				
			}else{
				
			}
		}
		
		map.addAttribute("sysMenuList", sysMenuList);
		
		
		return "../../index";
	}
	
	/**
	 * 注销登录
	 * @author  liangdong.yao
	 * @Date    2017年4月26日 下午3:23:25
	 * @version 1.0
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session,String service){
		//1.注销应用的session 2.注销cas(跳转到cas-server的logout方法) 3.重定向到service参数值地址
		session.invalidate();
		return "redirect:https://cas.cluster.com:8060/cas/logout?service="+service;
	}
	
}
