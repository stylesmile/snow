package com.stylesmile.system.service;

import com.stylesmile.common.service.BaseService;
import com.stylesmile.system.entity.SysMenu;

import java.util.List;

/**
 * 菜单管理
 *
 * @author chenye
 * @date 2019/1/8 21:23
 */
public interface SysMenuService extends BaseService<SysMenu> {

    /**
     * 查询菜单列表
     *
     * @return List<SysMenu>
     */
    List<SysMenu> geList();

    /**
     * 修改菜单
     *
     * @param sysMenu 菜单信息
     * @return Boolean
     */
    Boolean updateMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteMenu(String id);

}
