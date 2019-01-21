package com.stylesmile.system.service;

import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.system.mapper.SysMenuMapper;
import com.stylesmile.system.entity.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 角色管理
 * @Author: StyleSmile
 * @Date: 2019/1/8
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    /**
     * 查询菜单
     *
     * @return
     */
    @Override
    public List<SysMenu> geList() {
        return baseMapper.getMenuList();
    }

    /**
     * 修改菜单
     *
     * @param sysMenu
     * @return
     */
    @Override
    public Boolean updateMenu(SysMenu sysMenu) {
        return baseMapper.updateMenu(sysMenu);
    }

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteMenu(String id) {
        return baseMapper.deleteMenu(id);
    }

}
