package com.stylesmile.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author chenye
 * @date 2018/12/10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 父级id
     */
    @NotNull(message="parentId不能为空")
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
     * 资源定位地址
     */
    private String url;
    /**
     * 类型
     */
    private String type;
    /**
     * 排序
     */
    private Integer sort;
}
