package com.Stylesmile.system.dao;

import com.Stylesmile.system.entity.SysRole;
import com.Stylesmile.system.query.SysRoleQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenye
 * @date 2018/12/31
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    Page<SysRole> getRoleList(SysRoleQuery sysRoleQuery);

    Boolean updateRole(SysRole role);

    Boolean deleteRole(@Param("id") String id);

    Integer CheckDuplicate(@Param("code") String code);

}
