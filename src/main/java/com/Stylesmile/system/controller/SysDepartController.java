package com.Stylesmile.system.controller;

import com.Stylesmile.system.entity.SysUser;
import com.Stylesmile.system.query.SysUserQuery;
import com.Stylesmile.system.service.SysUserService;
import com.Stylesmile.util.Result;
import com.Stylesmile.util.UUIDUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chenye
 * @date 2018/12/08
 */
@RestController
public class SysDepartController {

    private final String base_url_path = "/depart";
    private final String base_html_path = "/system/sysUser";
    @Autowired
    private SysUserService sysUserService;

    @GetMapping(base_url_path + "/index.html")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(base_html_path+"/index");
        return view;
    }

    @RequestMapping(base_url_path + "/add.html")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView(base_html_path+"/add");
        return view;
    }

    @RequestMapping(base_url_path + "/add.json")
    @ResponseBody
    public Result add(SysUser user) {
        user.setId(UUIDUtil.getUUID());
        Boolean b = sysUserService.saveOrUpdate(user);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @RequestMapping(base_url_path + "/edit.html")
    public ModelAndView edit(String id) {
        ModelAndView view = new ModelAndView(base_html_path+"/edit");
        SysUser user = sysUserService.getById(id);
        view.addObject("user", user);
        return view;
    }

    @RequestMapping(base_url_path + "/edit.json")
    @ResponseBody
    public Result edit(SysUser user) {
        SysUser oldUser = sysUserService.getById(user.getId());
        Boolean b = sysUserService.updateUser(user);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
    @PostMapping(base_url_path + "/delete.json")
    @ResponseBody
    public Result delete(String id) {
        Boolean b = sysUserService.deleteUser(id);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @RequestMapping(base_url_path + "/list.json")
    public Result selectUserPage(SysUserQuery sysUserQuery) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        Page<SysUser> page=sysUserService.getUserList(sysUserQuery);
        return Result.success(page);
    }

}
