package com.cluster.parentweb.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cluster.basedata.api.vo.SysMenuApiVo;
import com.cluster.framework.constant.Constant;
import com.cluster.framework.util.RedisUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1、获取当前登录用户ID 2、根据用户ID从redis cluster中获取用户菜单 3、如果菜单集合为空则跳转cas登录页
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();  
		Map attributes = principal.getAttributes();
		String userId = (String)attributes.get("id");
		
		List<SysMenuApiVo> data = redisUtil.get(Constant.REDIS_KEY_USER_SYS_MENU_+userId,List.class);
		
		if(null == data || data.size()==0){
			String path = request.getScheme() + "://" 
							+ request.getServerName() + ":"
							+ request.getServerPort() + ""
							+ request.getContextPath() + "/index.do";
			System.out.println(path);
			response.sendRedirect(path);
			return false;
		}
		return true;
	}
}
