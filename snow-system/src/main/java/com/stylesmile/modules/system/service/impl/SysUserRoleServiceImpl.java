package com.stylesmile.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.modules.system.entity.SysRole;
import com.stylesmile.modules.system.entity.SysUserRole;
import com.stylesmile.modules.system.mapper.SysUserRoleMapper;
import com.stylesmile.modules.system.query.SysRoleQuery;
import com.stylesmile.modules.system.service.SysUserRoleService;
import com.stylesmile.common.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    /**
     * 用户添加角色
     *
     * @param userId  用户id
     * @param roleIds 以逗号分隔的角色id字符串
     * @param session session
     * @return Boolean
     */
    @Override
    public Boolean addRole(Integer userId, String roleIds, HttpSession session) {
        List<Integer> roleIdss = ConvertUtil.strToLongList(roleIds);
        List<SysUserRole> sysUserRoleList = new ArrayList<>();
        for (Integer roleId : roleIdss) {
            SysUserRole userRole = new SysUserRole(userId, roleId);
            sysUserRoleList.add(userRole);
        }
        if (sysUserRoleList.size() == 0) {
            return false;
        }
        this.saveBatch(sysUserRoleList);
        return true;
    }

    @Override
    public Boolean deleteRole(Integer id) {
        return sysUserRoleMapper.deleteById(id) > 0 ? true : false;
    }

    /**
     * 通过用户id 查询 该用户拥有的角色
     *
     * @param sysRoleQuery 用户id
     * @return Page<SysRole>
     */
    @Override
    public Page<SysRole> getUserRoleList(SysRoleQuery sysRoleQuery) {
        return baseMapper.getUserRoleList(sysRoleQuery);
    }
}
