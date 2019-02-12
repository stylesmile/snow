package com.stylesmile.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stylesmile.system.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 查询全部菜单
     *
     * @return list
     */
    List<SysMenu> getMenuList();

    /**
     * 通过用户id获取当前用户的菜单
     *
     * @param userId 用户id
     * @return List<SysMenu>
     */
    List<SysMenu> getMenuListByUserId(@Param("userId") Integer userId);

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
    Boolean deleteMenu(@Param("id") String id);

}
