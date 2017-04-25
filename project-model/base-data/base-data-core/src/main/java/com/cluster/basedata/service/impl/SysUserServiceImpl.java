package com.cluster.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cluster.basedata.mapper.SysUserMapper;
import com.cluster.basedata.service.SysUserService;
import com.cluster.framework.mapper.BaseMapper;
import com.cluster.framework.service.impl.BaseServiceImpl;

/**
 * 
 * @author  liangdong.yao
 * @date    2017-04-07 11:31:41
 * @version 1.0.0
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

	@Override
	public BaseMapper getMapper() {
		return sysUserMapper;
	}

}