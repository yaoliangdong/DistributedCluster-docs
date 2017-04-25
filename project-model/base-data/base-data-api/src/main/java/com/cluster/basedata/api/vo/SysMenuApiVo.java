package com.cluster.basedata.api.vo;

import com.cluster.framework.model.BaseEntity;

/**
 * 
 * @author  liangdong.yao
 * @date    2017-04-07 11:31:41
 * @version 1.0.0
 */
public class SysMenuApiVo extends BaseEntity{

	private static final long serialVersionUID = 1L;

	/**
     * 系统编码.
     */
    private String code;

    /**
     * 系统名字.
     */
    private String name;

    /**
     * 系统域名.
     */
    private String domain;

    /**
     * 系统端口号.
     */
    private String port;

    /**
     * 系统web路径.
     */
    private String path;
    
    /**
     * 链接.
     */
    private String href;

    /**
     * 排序.
     */
    private Integer sort;
    
	/**
     * 
     * {@linkplain #code}
     *
     * @return the value of sys_menu.code
     */
    public String getCode() {
        return code;
    }

    /**
     * {@linkplain #code}
     * @param code the value for sys_menu.code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of sys_menu.name
     */
    public String getName() {
        return name;
    }

    /**
     * {@linkplain #name}
     * @param name the value for sys_menu.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * {@linkplain #domain}
     *
     * @return the value of sys_menu.domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * {@linkplain #domain}
     * @param domain the value for sys_menu.domain
     */
    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    /**
     * 
     * {@linkplain #port}
     *
     * @return the value of sys_menu.port
     */
    public String getPort() {
        return port;
    }

    /**
     * {@linkplain #port}
     * @param port the value for sys_menu.port
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * 
     * {@linkplain #path}
     *
     * @return the value of sys_menu.path
     */
    public String getPath() {
        return path;
    }

    /**
     * {@linkplain #path}
     * @param path the value for sys_menu.path
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 
     * {@linkplain #href}
     *
     * @return the value of sys_menu.href
     */
    public String getHref() {
        return href;
    }

    /**
     * {@linkplain #href}
     * @param href the value for sys_menu.href
     */
    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }
    
    /**
     * 
     * {@linkplain #sort}
     *
     * @return the value of sys_menu.sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * {@linkplain #sort}
     * @param sort the value for sys_menu.sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}