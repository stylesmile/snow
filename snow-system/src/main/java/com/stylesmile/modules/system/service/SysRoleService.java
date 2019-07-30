package com.stylesmile.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseService;
import com.stylesmile.modules.system.entity.SysRole;
import com.stylesmile.modules.system.query.SysRoleQuery;

/**
 * @Description: 角色管理
 * @Author: StyleSmile
 * @Date: 2019/1/8
 */
public interface SysRoleService extends BaseService<SysRole> {
    /**
     * 查询角色
     *
     * @param sysRoleQuery 条件
     * @return Page
     */
    Page<SysRole> getRoleList(SysRoleQuery sysRoleQuery);

    /**
     * 修改角色
     *
     * @param role 角色信息
     * @return Boolean
     */
    Boolean updateRole(SysRole role);

    /**
     * 删除角色
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteRole(String id);

    /**
     * 检查code是否重复
     *
     * @param code 编号
     * @return Integer
     */
    Integer checkDuplicate(String code);

}
