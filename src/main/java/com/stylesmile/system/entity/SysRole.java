package com.stylesmile.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenye
 * @date 2018/12/10
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysRole {
    private String id;
    private String name;
    private String code;
    private Integer sort;
    private Integer delFlag;
}
