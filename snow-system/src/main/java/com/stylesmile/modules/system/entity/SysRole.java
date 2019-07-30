package com.stylesmile.modules.system.entity;

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
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编号
     */
    private String code;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 删除标识 0.未删除，1.删除
     */
    private Integer delFlag;
}
