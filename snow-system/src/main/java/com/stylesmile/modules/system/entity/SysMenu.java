package com.stylesmile.modules.system.entity;

import javax.validation.constraints.NotNull;

/**
 * @author chenye
 * @date 2018/12/10
 */
public class SysMenu {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 父级id
     */
    @NotNull(message = "parentId不能为空")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public SysMenu() {
    }
}
