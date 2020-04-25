package com.stylesmile.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.modules.system.entity.SysRole;
import com.stylesmile.modules.system.mapper.SysRoleMapper;
import com.stylesmile.modules.system.vo.query.SysRoleQuery;
import com.stylesmile.modules.system.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * 角色 RoleService
 *
 * @author StyleSmile
 * @date 2019/1/8
 */
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

    /**
     * 删除
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteRole(String id) {
        return baseMapper.deleteRole(id);
    }

    /**
     * 检查角色编号是否重复角色
     *
     * @param code 角色编号
     * @return Integer
     */
    @Override
    public Integer checkDuplicate(String code) {
        return baseMapper.checkDuplicate(code);
    }

}
