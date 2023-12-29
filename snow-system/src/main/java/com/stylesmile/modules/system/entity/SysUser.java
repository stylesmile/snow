package com.stylesmile.modules.system.entity;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 * @author chenye
 * @date 2018/12/10
 */
public class SysUser {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 登陆用户名
     */
    @NotEmpty(message = "登录名不能为空")
    private String username;
    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空")
    private String nickname;
    /**
     * 秘密啊
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, message = "密码长度不能小于6位")
    private String password;
    /**
     * 手机好嘛
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 删除标识 0.未删除，1.删除
     */
    private Integer delFlag;

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SysUser(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public SysUser() {
    }
}
