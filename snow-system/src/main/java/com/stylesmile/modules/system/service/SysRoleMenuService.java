package com.stylesmile.modules.system.service;

import com.stylesmile.common.service.BaseService;
import com.stylesmile.modules.system.entity.SysRoleMenu;

import java.util.List;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenu> {

    /**
     * 角色增加菜单
     *
     * @param roleId  角色id
     * @param menuIds 以逗号分隔的菜单id
     * @return Boolean
     */
    Boolean addRoleMenu(Integer roleId, String menuIds);

    /**
     * 通过角色id 查询该用户拥有的菜单
     *
     * @param roleId 角色id
     * @return List<SysRoleMenu>
     */
    List<Integer> getRoleMenuList(Integer roleId);
}
