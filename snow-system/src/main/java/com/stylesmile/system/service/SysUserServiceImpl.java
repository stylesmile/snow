package com.stylesmile.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.system.dao.SysUserMapper;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.query.SysUserQuery;
import com.stylesmile.util.Result;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户管理
 * @Author: chenye
 * @Date: 2019/1/8
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    /**
     * 通过用户名密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Result<String> getSysUserByNameAndPassword(String username, String password) {
        SysUser user = baseMapper.getSysUserByNameAndPassword(username, password);
        if (user != null) {
            return Result.success("登陆成功");
        } else {
            return Result.fail("用户名或者密码错误");
        }
    }

    /**
     * 查询用户
     *
     * @param sysUserQuery
     * @return
     */
    @Override
    public Page<SysUser> getUserList(SysUserQuery sysUserQuery) {
        return baseMapper.getUserList(sysUserQuery);
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
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
