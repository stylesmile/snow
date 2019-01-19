package com.stylesmile.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.system.dao.SysRoleMapper;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.query.SysRoleQuery;
import org.springframework.stereotype.Service;

/**
 * @Description: 修改
 * @Author: StyleSmile
 * @Date: 2019/1/8
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
     * @param id
     * @return
     */
    @Override
    public Boolean deleteRole(String id) {
        return baseMapper.deleteRole(id);
    }

    /**
     * 检查code是否重复
     *
     * @param code
     * @return
     */
    @Override
    public Integer CheckDuplicate(String code) {
        return baseMapper.CheckDuplicate(code);
    }

}
