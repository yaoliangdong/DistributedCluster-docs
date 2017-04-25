package com.cluster.basedata.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cluster.basedata.model.SysUser;
import com.cluster.basedata.service.SysUserService;


/**
 * 系统用户
 * @className SysUserController.java
 * @author    liangdong.yao
 * @Date      2017年4月25日 下午1:54:27
 * @version   1.0
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 用户列表
	 * @author  liangdong.yao
	 * @Date    2017年4月25日 下午5:04:43
	 * @version 1.0
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,ModelMap map){
		
		List<SysUser> userList = sysUserService.findByBiz(null);
		map.addAttribute("list", userList);
		
		return "sysUser/list";
	}
	

	
}
