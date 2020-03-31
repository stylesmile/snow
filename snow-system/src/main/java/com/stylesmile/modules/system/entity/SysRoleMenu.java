package com.stylesmile.modules.system.entity;

/**
 * @author StyleSmile
 * @date 2019/01/25
 */
public class SysRoleMenu {
    private Integer id;
    private Integer roleId;
    private Integer menuId;

    public SysRoleMenu(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public SysRoleMenu() {
    }
}
