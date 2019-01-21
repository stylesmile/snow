package com.stylesmile.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.system.constant.UserConstant;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.entity.SysUserRole;
import com.stylesmile.system.mapper.SysUserMapper;
import com.stylesmile.system.mapper.SysUserRoleMapper;
import com.stylesmile.system.query.SysUserQuery;
import com.stylesmile.util.Result;
import com.stylesmile.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    /**
     * 通过用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return Result
     */
    @Override
    public Result<String> getSysUserByNameAndPassword(String username, String password, HttpSession session) {
        SysUser user = baseMapper.getSysUserByNameAndPassword(username, password);
        if (user != null) {
            session.setAttribute(UserConstant.LOGIN_USER, user);
            return Result.success("登陆成功");
        } else {
            return Result.fail("用户名或者密码错误");
        }
    }

    /**
     * 查询用户
     *
     * @param sysUserQuery 条件
     * @return Page
     */
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
        return baseMapper.updateUser(user);
    }

    /**
     * 删除用户
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteUser(String id) {
        return baseMapper.deleteUser(id);
    }

}
