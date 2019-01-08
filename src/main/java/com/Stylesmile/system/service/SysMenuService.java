package com.Stylesmile.system.service;

import com.Stylesmile.system.entity.SysMenu;

import java.util.List;

public interface SysMenuService extends BaseService<SysMenu>{

    List<SysMenu> geList();

}
