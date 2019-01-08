package com.Stylesmile.system.entity;

import lombok.Data;

/**
 * @author chenye
 * @date 2018/12/10
 */
@Data
public class SysMenu {
    private int id;
    private String parentId;
    private String name;
    private String code;
    private String parentCode;
    private String sort;

    public SysMenu() {}

    public SysMenu(int id, String parentId, String name, String code, String parentCode, String sort) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.code = code;
        this.parentCode = parentCode;
        this.sort = sort;
    }
}
