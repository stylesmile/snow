package com.stylesmile.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseService;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.entity.SysUserRole;
import com.stylesmile.system.query.SysRoleQuery;
import com.stylesmile.system.query.SysUserQuery;
import com.stylesmile.util.Result;

import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
public interface SysUserRoleService extends BaseService<SysUserRole> {

    /**
     * 用户增加角色
     *
     * @param id
     * @return
     */
    Boolean addRole(String id, HttpSession session);

    Boolean deleteRole(String id);

    /**
     * 通过用户id 查询该用户拥有的角色
     *
     * @param sysRoleQuery 用户id
     * @return Page
     */
    Page<SysRole> getUserRoleList(SysRoleQuery sysRoleQuery);
}
