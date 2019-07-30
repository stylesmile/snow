package com.stylesmile.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stylesmile.modules.system.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户mapper
 *
 * @author chenye
 * @date 2019/01/20
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    /**
     * 通过用户id 查询该用户拥有的菜单
     *
     * @param roleId 角色id
     * @return List<SysRoleMenu>
     */
    List<Integer> getRoleMenuList(Integer roleId);
}
