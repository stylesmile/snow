package com.stylesmile.system.service;

import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.system.entity.SysMenu;
import com.stylesmile.system.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    /**
     * 查询菜单
     *
     * @return List<SysMenu>
     */
    @Override
    public List<SysMenu> geList() {
        return baseMapper.getMenuList();
    }

    /**
     * 修改菜单
     *
     * @param sysMenu 菜单信息
     * @return Boolean
     */
    @Override
    public Boolean updateMenu(SysMenu sysMenu) {
        return baseMapper.updateMenu(sysMenu);
    }

    /**
     * 删除菜单
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteMenu(String id) {
        return baseMapper.deleteMenu(id);
    }

}
