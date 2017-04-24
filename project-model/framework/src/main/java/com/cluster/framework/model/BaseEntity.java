package com.cluster.framework.model;

import java.io.Serializable;

/**
 * 公共实体类
 * @className BaseEntity.java
 * @author    liangdong.yao
 * @Date      2017年4月11日 上午9:45:03
 * @version   1.0
 */
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
