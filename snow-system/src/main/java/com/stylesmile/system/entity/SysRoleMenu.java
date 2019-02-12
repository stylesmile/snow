package com.stylesmile.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author StyleSmile
 * @date 2019/01/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenu {
    private Integer id;
    private Integer roleId;
    private Integer menuId;

    public SysRoleMenu(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }
}
