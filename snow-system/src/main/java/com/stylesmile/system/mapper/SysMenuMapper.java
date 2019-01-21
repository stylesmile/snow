package com.stylesmile.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stylesmile.system.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 删除
     *
     * @return list
     */
    List<SysMenu> getMenuList();

    /**
     * 更新菜单
     *
     * @param sysMenu 菜单
     * @return Boolean
     */
    Boolean updateMenu(SysMenu sysMenu);

    /**
     * 删除
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteMenu(String id);
}
