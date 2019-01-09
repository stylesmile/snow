package com.stylesmile.system.service;

import com.stylesmile.common.service.BaseService;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.query.SysRoleQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/** 
 * @Description: 角色管理
 * @Author:       StyleSmile
 * @Date:         2019/1/8
 */ 
public interface SysRoleService extends BaseService<SysRole> {
    /**
     * 查询角色
     * @param sysRoleQuery
     * @return
     */
    Page<SysRole> getRoleList(SysRoleQuery sysRoleQuery);

    /**
     * 修改角色
     * @param user
     * @return
     */
    Boolean updateRole(SysRole user);
    /**
     * 删除角色
     * @param id
     * @return
     */
    Boolean deleteRole(String id);

    /**
     * 检查code是否重复
     * @param code
     * @return
     */
    Integer CheckDuplicate(String code);

}
