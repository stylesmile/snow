package com.stylesmile.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.query.SysUserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户mapper
 *
 * @author chenye
 * @date 2018/11/18
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 通过用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return SysUser
     */
    SysUser getSysUserByNameAndPassword(@Param("username") String usernamed);

    /**
     * 用户i班级
     *
     * @param user 用户
     * @return Boolean
     */
    Boolean updateUser(SysUser user);

    /**
     * 删除
     *
     * @param id 用户id
     * @return Boolean
     */
    Boolean deleteUser(@Param("id") String id);

    /**
     * 查询用户list
     *
     * @param sysUserQuery 条件
     * @return Page
     */
    Page<SysUser> getUserList(SysUserQuery sysUserQuery);

}
