package com.stylesmile.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseService;
import com.stylesmile.modules.system.entity.SysRole;
import com.stylesmile.modules.system.entity.SysUserRole;
import com.stylesmile.modules.system.query.SysRoleQuery;

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
     * @param useId 用户id
     * @param roleIds 角色id
     * @return Boolean
     */
    Boolean addRole(Integer useId, String roleIds, HttpSession session);

    /**
     * 删除角色
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteRole(Integer id);

    /**
     * 通过用户id 查询该用户拥有的角色
     *
     * @param sysRoleQuery 用户id
     * @return Page<SysRole>
     */
    Page<SysRole> getUserRoleList(SysRoleQuery sysRoleQuery);
}
