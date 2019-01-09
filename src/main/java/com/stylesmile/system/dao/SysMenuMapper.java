package com.stylesmile.system.dao;

import com.stylesmile.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenuList();

    Boolean updateMenu(SysMenu sysMenu);

    Boolean deleteMenu(String id);
}
