package com.stylesmile.modules.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenye
 * @date 2018/12/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysDepart {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 父级id
     */
    private Integer parentId;
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
    private String sort;
}
