package com.Stylesmile.system.service;

import com.Stylesmile.system.dao.SysMenuMapper;
import com.Stylesmile.system.entity.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper,SysMenu> implements SysMenuService{

    public List<SysMenu> geList() {
        return baseMapper.getMenuList();
    }

}
