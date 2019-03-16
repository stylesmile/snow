package com.stylesmile.log.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author chenye
 * @date 2019/2/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogLogin {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    @NotEmpty(message = "名称不能为空")
    private String name;
    /**
     * 登陆用户名
     */
    @NotEmpty(message = "用户id不能为空")
    private Integer userId;
    /**
     * 昵称
     */
    @NotEmpty(message = "用户名不能为空")
    private String username;
    ;
    /**
     * 秘密啊
     */
    private Date createTime;

    public LogLogin(String name,Integer userId, String username) {
        this.name = name;
        this.userId = userId;
        this.username = username;
    }
}
