package com.stylesmile.modules.system.entity;

import javax.validation.constraints.NotEmpty;

/**
 * @author chenye
 * @date 2018/12/10
 */
public class SysUserRole implements java.io.Serializable {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户id
     */
    @NotEmpty(message = "用户id不能为空")
    private Integer userId;
    /**
     * 用户id
     */
    @NotEmpty(message = "用户id不能为空")
    private Integer roleId;

    public SysUserRole(@NotEmpty(message = "用户id不能为空") Integer userId, @NotEmpty(message = "用户id不能为空") Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public SysUserRole() {
    }
}
