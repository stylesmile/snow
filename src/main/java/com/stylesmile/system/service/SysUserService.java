package com.stylesmile.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseService;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.query.SysUserQuery;
import com.stylesmile.util.Result;

/**
 * 用户管理
 *
 * @Author: chenye
 * @Date: 2019/1/8
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 通过用户名密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    Result<String> getSysUserByNameAndPassword(String username, String password);

    /**
     * 查询用户
     *
     * @param sysUserQuery
     * @return
     */
    Page<SysUser> getUserList(SysUserQuery sysUserQuery);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    Boolean updateUser(SysUser user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    Boolean deleteUser(String id);

}
