package com.stylesmile.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author chenye
 * @date 2018/12/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser  {
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

}
