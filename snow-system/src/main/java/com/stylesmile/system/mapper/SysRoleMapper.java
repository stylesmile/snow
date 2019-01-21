package com.stylesmile.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.query.SysRoleQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenye
 * @date 2018/12/31
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 查询
     *
     * @param sysRoleQuery 查询条件
     * @return Page
     */
    Page<SysRole> getRoleList(SysRoleQuery sysRoleQuery);

    Boolean updateRole(SysRole role);

    Boolean deleteRole(@Param("id") String id);

    Integer checkDuplicate(@Param("code") String code);


}
