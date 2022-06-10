package com.stylesmile.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseService;
import com.stylesmile.modules.system.entity.SysDepart;
import com.stylesmile.modules.system.entity.SysUser;
import com.stylesmile.modules.system.vo.LoginVo;
import com.stylesmile.modules.system.vo.query.SysUserQuery;
import com.stylesmile.common.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 获取session中的用户
     * @param httpServletRequest request
     * @return SysUser
     */
    SysUser getSessionUser(HttpServletRequest httpServletRequest);

    /**
     * 通过用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @param session  session
     * @return Result
     */
    Result<String> getSysUserByNameAndPassword(LoginVo loginVo, HttpSession session);

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

    /**
     * 清除部门缓存
     */
    void clearUserListCache();

    /**
     * 通过id 获取部门信息
     *
     * @param id 主键
     * @return SysDepart
     */
    SysDepart getUserByIdCache(Integer id);

    /**
     * 清理单个部门缓存
     */
    void clearUserCache(Integer id);
}
