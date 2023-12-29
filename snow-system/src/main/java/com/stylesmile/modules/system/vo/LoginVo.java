package com.stylesmile.modules.system.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

@Data
public class LoginVo {
    @Length(min = 6, max = 18, message = "用户名长度不能小于6位，大于18位")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码名不能为空")
    @Length(min = 6, max = 18, message = "密码长度不能小于6位，大于18位")
    private String password;
}
