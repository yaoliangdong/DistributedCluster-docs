package com.cluster.basedata.model;

import com.cluster.framework.model.BaseEntity;

/**
 * 
 * @author  liangdong.yao
 * @date    2017-04-07 11:31:41
 * @version 1.0.0
 */
public class SysUser extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 用户名.
     */
    private String name;

    /**
     * 登录名.
     */
    private String loginName;

    /**
     * 登录密码.
     */
    private String pass;

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of sys_user.name
     */
    public String getName() {
        return name;
    }

    /**
     * {@linkplain #name}
     * @param name the value for sys_user.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * {@linkplain #loginName}
     *
     * @return the value of sys_user.login_name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * {@linkplain #loginName}
     * @param loginName the value for sys_user.login_name
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 
     * {@linkplain #pass}
     *
     * @return the value of sys_user.pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * {@linkplain #pass}
     * @param pass the value for sys_user.pass
     */
    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }
}