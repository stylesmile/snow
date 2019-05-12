package com.stylesmile.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseService;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.query.SysUserQuery;
import com.stylesmile.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
public interface SysUserService extends BaseService<SysUser> {

    SysUser getSessionUser(HttpServletRequest httpServletRequest);

    /**
     * 通过用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @param session  session
     * @return Result
     */
    Result<String> getSysUserByNameAndPassword(String username, String password, HttpSession session);

    /**
     * 查询用户
     *
     * @param sysUserQuery 条件
     * @return Page
     */
    Page<SysUser> getUserList(SysUserQuery sysUserQuery);

    /**
     * 修改用户
     *
     * @param user 用户信息
     * @return Boolean
     */
    Boolean updateUser(SysUser user);

    /**
     * 删除用户
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteUser(Integer id);

    /**
     * 通过用户id ,请求路径判断是否有该路径的权限
     *
     * @param url    请求路径
     * @param userId 用户id
     * @return Integer
     */
    Integer queryPermission(String url, Integer userId);
}
