package com.stylesmile.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenye
 * @date 2018/12/10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu {
    private int id;
    private String parentId;
    private String name;
    private String code;
    private String url;
    private String type;
    private String parentCode;
    private String sort;
}
