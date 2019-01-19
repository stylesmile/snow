package com.stylesmile.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.query.SysUserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser getSysUserByNameAndPassword(@Param("username") String username, @Param("password") String password);

    Boolean updateUser(SysUser user);

    Boolean deleteUser(@Param("id") String id);

    Page<SysUser> getUserList(SysUserQuery sysUserQuery);

}
