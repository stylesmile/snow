package com.Stylesmile.system.service;

import com.Stylesmile.system.entity.SysRole;
import com.Stylesmile.system.query.SysRoleQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface SysRoleService extends BaseService<SysRole> {

    Page<SysRole> getRoleList(SysRoleQuery sysRoleQuery);

    Boolean updateRole(SysRole user);

    Boolean deleteRole(String id);

    Integer CheckDuplicate(String code);

}
