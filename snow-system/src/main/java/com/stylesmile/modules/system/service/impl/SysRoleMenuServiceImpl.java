package com.stylesmile.modules.system.service.impl;

import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.modules.system.entity.SysRoleMenu;
import com.stylesmile.modules.system.mapper.SysRoleMenuMapper;
import com.stylesmile.modules.system.service.SysRoleMenuService;
import com.stylesmile.common.util.ConvertUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    /**
     * 角色增加菜单
     *
     * @param roleId  角色id
     * @param menuIds 以逗号分隔的菜单id
     */
    @Override
    public Boolean addRoleMenu(Integer roleId, String menuIds) {
        List<Integer> all = ConvertUtil.strToLongList(menuIds);
        //待删除
        List<Integer> delIds = new ArrayList<>();
        //待新增的list
        List<SysRoleMenu> sysRoleMenuList = new ArrayList<>();
        //数据库中该角色的menuId 集合
        List<Integer> dbs = getRoleMenuList(roleId);

        //待删除
        for (Integer id : dbs) {
            //如果新的集合中的数据，数据库没有
            if (!all.contains(id)) {
                delIds.add(id);
            }
        }
        if (delIds.size() > 0) {
            //批量删除
            this.removeByIds(delIds);
        }
        //待新增
        for (Integer id : all) {
            if (!dbs.contains(id)) {
                SysRoleMenu sysRoleMenu = new SysRoleMenu(roleId, id);
                sysRoleMenuList.add(sysRoleMenu);
            }
        }
        if (sysRoleMenuList.size() > 0) {
            //批量新增
            this.saveBatch(sysRoleMenuList);
        }
        return true;
    }

    /**
     * 通过角色id 查询该用户拥有的菜单
     *
     * @param roleId 角色id
     * @return List<SysRoleMenu>
     */
    @Override
    public List<Integer> getRoleMenuList(Integer roleId) {
        return baseMapper.getRoleMenuList(roleId);
    }
}
