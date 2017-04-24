package com.cluster.basedata.api.service;

import java.util.List;

import com.cluster.basedata.api.vo.SysMenuApiVo;
import com.cluster.framework.dto.ResultDto;

/**
 * 系统菜单对外发布接口
 * 
 * @className SysMenuApiService.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 下午2:05:10
 * @version   1.0
 */
public interface SysMenuApiService {

	/**
	 * 获取当前登录用户菜单集合
	 * @author  liangdong.yao
	 * @Date    2017年4月7日 下午2:25:54
	 * @version 1.0
	 */
	public ResultDto<List<SysMenuApiVo>> getSysMenu(String userId);
    
}