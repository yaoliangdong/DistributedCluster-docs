package com.cluster.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cluster.basedata.mapper.SysMenuMapper;
import com.cluster.basedata.service.SysMenuService;
import com.cluster.framework.service.impl.BaseServiceImpl;

/**
 * 
 * @author  liangdong.yao
 * @date    2017-04-07 11:31:41
 * @version 1.0.0
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl implements SysMenuService {

	@Resource
    private SysMenuMapper sysMenuMapper;


}