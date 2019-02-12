package com.stylesmile.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author chenye
 * @date 2018/12/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
