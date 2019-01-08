package com.Stylesmile.system.service;

import com.Stylesmile.system.dao.SysUserMapper;
import com.Stylesmile.system.entity.SysUser;
import com.Stylesmile.system.query.SysUserQuery;
import com.Stylesmile.util.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService{

    @Override
    public Result<String> getSysUserByNameAndPassword(String username, String password) {
        SysUser user = baseMapper.getSysUserByNameAndPassword(username,password);
        if(user!=null){
            return Result.success("登陆成功");
        }else{
            return Result.fail("用户名或者密码错误");
        }
    }

    public List<SysUser> geList() {
        return baseMapper.getUserList();
    }


    @Override
    public Page<SysUser> getUserList( SysUserQuery sysUserQuery) {
        return baseMapper.getUserList(sysUserQuery);
    }

    @Override
    public Boolean updateUser(SysUser user) {
        return baseMapper.updateUser(user);
    }

    @Override
    public Boolean deleteUser(String id) {
        return baseMapper.deleteUser(id);
    }

}
