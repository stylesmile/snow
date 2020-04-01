package com.stylesmile.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.constant.CacheConstant;
import com.stylesmile.common.constant.SessionConstant;
import com.stylesmile.common.constant.UserConstant;
import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.common.util.Result;
import com.stylesmile.modules.system.entity.SysDepart;
import com.stylesmile.modules.system.entity.SysUser;
import com.stylesmile.modules.system.mapper.SysUserMapper;
import com.stylesmile.modules.system.query.SysUserQuery;
import com.stylesmile.modules.system.service.SysUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * 获取session中的用户
     *
     * @param httpServletRequest request
     * @return SysUser
     */
    @Override
    public SysUser getSessionUser(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        //获取登录的session信息
        Object user = session.getAttribute(SessionConstant.LOGIN_USER);
        return (SysUser) user;
    }

    /**
     * 通过用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return Result
     */
    @Override
    public Result<String> getSysUserByNameAndPassword(String username, String password, HttpSession session) {
        SysUser user = baseMapper.getSysUserByNameAndPassword(username);
        if (null != user && password.equals(user.getPassword())) {
            session.setAttribute(SessionConstant.LOGIN_USER, user);
            return Result.successMessage("登陆成功");
        } else {
            //数据库查不到超级管理员 用户，超级管理员用户就读取系统中写死的用户名，密码
            if (null == user && UserConstant.SUPPER_ADMIN.equals(username) && UserConstant.SUPPER_ADMIN_PASSWORD.equals(password)) {
                session.setAttribute(SessionConstant.LOGIN_USER, new SysUser(username));
                return Result.successMessage("登陆成功");
            }
            return Result.failMessage("用户名或者密码错误");
        }
    }

    /**
     * 查询用户
     *
     * @param sysUserQuery 条件
     * @return Page
     */
    @Cacheable(value = CacheConstant.userCache.USER_LIST_CACHE)
    @Override
    public Page<SysUser> getUserList(SysUserQuery sysUserQuery) {
        return baseMapper.getUserList(sysUserQuery);
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return Boolean
     */
    @Override
    public Boolean updateUser(SysUser user) {
        Boolean bool = baseMapper.updateUser(user);
        this.clearUserListCache();
        this.clearUserCache(user.getId());
        return bool;
    }

    /**
     * 删除用户
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteUser(Integer id) {
        Boolean bool = baseMapper.deleteUser(id);
        this.clearUserListCache();
        this.clearUserCache(id);
        return bool;
    }

    /**
     * 通过用户id ,请求路径判断是否有该路径的权限
     *
     * @param url    请求路径
     * @param userId 用户id
     * @return Integer
     */
    @Override
    public Integer queryPermission(String url, Integer userId) {
        return baseMapper.queryPermission(url, userId);
    }


    @CacheEvict(value = CacheConstant.userCache.USER_LIST_CACHE, key = "#id")
    @Override
    public void clearUserListCache() {
    }

    @Cacheable(value = CacheConstant.userCache.USER_CACHE, key = "#id")
    @Override
    public SysDepart getUserByIdCache(Integer id) {
        return null;
    }

    @CacheEvict(value = CacheConstant.userCache.USER_CACHE, key = "#id")
    @Override
    public void clearUserCache(Integer id) {
    }

}
