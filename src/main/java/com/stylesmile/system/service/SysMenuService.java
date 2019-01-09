package com.stylesmile.system.service;

import com.stylesmile.common.service.BaseService;
import com.stylesmile.system.entity.SysMenu;

import java.util.List;

/**
 * @Description: 菜单管理
 * @Author: chenye
 * @Date: 2019/1/8 21:23
 */
public interface SysMenuService extends BaseService<SysMenu> {

    /**
     * 查询菜单列表
     *
     * @return
     */
    List<SysMenu> geList();

    /**
     * 修改菜单
     *
     * @param sysMenu
     * @return
     */
    Boolean updateMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Boolean deleteMenu(String id);

}
