package com.stylesmile.system.dao;

import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.query.SysUserQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> getUserList();

    SysUser getSysUserByNameAndPassword(@Param("username") String username, @Param("password") String password);

    Boolean updateUser(SysUser user);

    Boolean deleteUser(@Param("id") String id);

    IPage<SysUser> getUserListPage(Page<SysUser> page, QueryWrapper<SysUser> sysUserQueryWrapperw);

    Page<SysUser> getUserList(SysUserQuery sysUserQuery);

}
