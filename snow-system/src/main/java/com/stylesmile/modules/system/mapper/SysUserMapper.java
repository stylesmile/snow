package com.stylesmile.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.modules.system.entity.SysUser;
import com.stylesmile.modules.system.query.SysUserQuery;
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
     * @return SysUser
     */
    SysUser getSysUserByNameAndPassword(@Param("username") String username);

    /**
     * 编辑用户
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
    Boolean deleteUser(@Param("id") Integer id);

    /**
     * 查询用户list
     *
     * @param sysUserQuery 条件
     * @return Page
     */
    Page<SysUser> getUserList(SysUserQuery sysUserQuery);

    /**
     * 根据url查询用户是否有该url的权限
     *
     * @param url 路径
     * @return Page
     */
    Integer queryPermission(@Param("url") String url, @Param("userId") Integer userId);

}
