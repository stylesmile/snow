package com.stylesmile.modules.system.service.impl;

import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.common.constant.UserConstant;
import com.stylesmile.modules.system.entity.SysMenu;
import com.stylesmile.modules.system.entity.SysUser;
import com.stylesmile.modules.system.mapper.SysMenuMapper;
import com.stylesmile.modules.system.service.SysMenuService;
import com.stylesmile.modules.system.service.SysUserService;
import com.stylesmile.modules.system.vo.tree.MenuTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 菜单管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    SysUserService sysUserService;

    /**
     * 查询菜单
     *
     * @return List<SysMenu>
     */
    @Override
    public List<SysMenu> getList() {
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

    /**
     * 通过用户id获取当前用户的菜单
     *
     * @param httpServletRequest request
     * @return MenuTree
     */
    @Override
    public MenuTree getMenuListByUserId(HttpServletRequest httpServletRequest) {
        //获取session中的用户
        SysUser sysUser = sysUserService.getSessionUser(httpServletRequest);
        Integer userId = sysUser.getUsername() == UserConstant.SUPPER_ADMIN ? sysUser.getId() : null;
        //通过用户id获取菜单list
        List<SysMenu> sysMenuList = baseMapper.getMenuListByUserId(userId);
        //list to tree
        return MenuTree.listToTree(sysMenuList);
    }

}
