package com.Stylesmile.system.service;

import com.Stylesmile.system.dao.SysRoleMapper;
import com.Stylesmile.system.entity.SysRole;
import com.Stylesmile.system.query.SysRoleQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public Page<SysRole> getRoleList(SysRoleQuery sysRoleQuery) {
        return baseMapper.getRoleList(sysRoleQuery);
    }

    @Override
    public Boolean updateRole(SysRole user) {
        return baseMapper.updateRole(user);
    }

    @Override
    public Boolean deleteRole(String id) {
        return baseMapper.deleteRole(id);
    }

    @Override
    public Integer CheckDuplicate(String code) {
        return baseMapper.CheckDuplicate(code);
    }

}
