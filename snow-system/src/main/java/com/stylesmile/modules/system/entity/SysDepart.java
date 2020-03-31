package com.stylesmile.modules.system.entity;

/**
 * @author chenye
 * @date 2018/12/10
 */
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public SysDepart(Integer id, Integer parentId, String name, String code, String sort) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.code = code;
        this.sort = sort;
    }

    public SysDepart() {
    }
}
