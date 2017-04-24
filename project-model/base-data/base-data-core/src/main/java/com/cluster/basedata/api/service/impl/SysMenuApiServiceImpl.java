package com.cluster.basedata.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluster.basedata.api.service.SysMenuApiService;
import com.cluster.basedata.api.vo.SysMenuApiVo;
import com.cluster.basedata.mapper.SysMenuMapper;
import com.cluster.framework.dto.ResultDto;

/**
 * 系统菜单对外发布接口实现类
 * 
 * @className SysMenuApiServiceImpl.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 下午2:28:08
 * @version   1.0
 */
@Service
public class SysMenuApiServiceImpl implements SysMenuApiService{
	
	
	@Autowired
	private SysMenuMapper sysMenuMapper;

	public ResultDto<List<SysMenuApiVo>> getSysMenu(String userId) {
		ResultDto<List<SysMenuApiVo>> dto = null;
		try {
			dto = new ResultDto<List<SysMenuApiVo>>();
			List<SysMenuApiVo> data = sysMenuMapper.selectByParams(null);
			dto.setCode(ResultDto.OK_CODE);
			dto.setData(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
