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
    private Long id;
    private Long roleId;
    private Long menuId;

    public SysRoleMenu(Long roleId, Long menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }
}
