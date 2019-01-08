package com.Stylesmile.system.controller;

import com.Stylesmile.system.entity.SysRole;
import com.Stylesmile.system.query.SysRoleQuery;
import com.Stylesmile.system.service.SysRoleService;
import com.Stylesmile.util.Result;
import com.Stylesmile.util.UUIDUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.server.InactiveGroupException;

/**
 * @author chenye
 * @date 2018/12/08
 */
@RestController
public class SysRoleController {

    final String base_url_path = "/role";
    final String base_html_path = "/system/sysRole";
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping(base_url_path + "/index.html")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(base_html_path + "/role");
        return view;
    }


    @GetMapping(base_url_path + "/add.html")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView(base_html_path + "/role_add");
        return view;
    }

    @RequestMapping(base_url_path + "/add.json")
    @ResponseBody
    public Result add(SysRole role) {
        role.setId(UUIDUtil.getUUID());
        //判断编号code是否重复
        Integer count = sysRoleService.CheckDuplicate(role.getCode());
        if (count>0){
            return Result.fail("编号重复!");
        }
        Boolean b = sysRoleService.save(role);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
    @GetMapping(base_url_path + "/edit.html")
    public ModelAndView edit(String id) {
        ModelAndView view = new ModelAndView(base_html_path + "/role_edit");
        SysRole role = sysRoleService.getById(id);
        view.addObject("role", role);
        return view;
    }

    @PostMapping(base_url_path + "/edit.json")
    @ResponseBody
    public Result edit(SysRole role) {
        SysRole oldRole = sysRoleService.getById(role.getId());
        Boolean b = sysRoleService.updateRole(role);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @PostMapping(base_url_path + "/delete.json")
    @ResponseBody
    public Result delete(String id) {
        Boolean b = sysRoleService.deleteRole(id);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @RequestMapping(base_url_path + "/list.json")
    public Result selectRolePage(SysRoleQuery sysRoleQuery) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        //IPage<SysRole> ipage=sysRoleService.getRoleList(page, state);
        Page<SysRole> ipage = sysRoleService.getRoleList(sysRoleQuery);
        return Result.success(ipage);
    }


}

