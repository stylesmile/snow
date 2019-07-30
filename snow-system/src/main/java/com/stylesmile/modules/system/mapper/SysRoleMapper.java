package com.stylesmile.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.modules.system.entity.SysRole;
import com.stylesmile.modules.system.query.SysRoleQuery;
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
    Boolean deleteRole(@Param("id") String id);

    /**
     * 检查角色编号是否重复角色
     *
     * @param code 角色编号
     * @return Boolean
     */
    Integer checkDuplicate(@Param("code") String code);


}
