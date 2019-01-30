package com.stylesmile.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseService;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.entity.SysUserRole;
import com.stylesmile.system.query.SysRoleQuery;

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
     * @return Boolean
     */
    Boolean addRole(String id, HttpSession session);

    /**
     * 删除角色
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteRole(String id);

    /**
     * 通过用户id 查询该用户拥有的角色
     *
     * @param sysRoleQuery 用户id
     * @return Page<SysRole>
     */
    Page<SysRole> getUserRoleList(SysRoleQuery sysRoleQuery);
}
