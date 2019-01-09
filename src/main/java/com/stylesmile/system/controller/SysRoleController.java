package com.stylesmile.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.query.SysRoleQuery;
import com.stylesmile.system.service.SysRoleService;
import com.stylesmile.util.Result;
import com.stylesmile.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 角色管理
 *
 * @author StyleSmile
 * @date 2018/12/08
 */
@RestController
public class SysRoleController {

    final String BASE_URL_PATH = "/role";
    final String BASE_HTML_PATH = "/system/sysRole";
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping(BASE_URL_PATH + "/index.html")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/role");
        return view;
    }


    @GetMapping(BASE_URL_PATH + "/add.html")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/role_add");
        return view;
    }

    @RequestMapping(BASE_URL_PATH + "/add.json")
    @ResponseBody
    public Result add(SysRole role) {
        role.setId(UUIDUtil.getUUID());
        //判断编号code是否重复
        Integer count = sysRoleService.CheckDuplicate(role.getCode());
        if (count > 0) {
            return Result.fail("编号重复!");
        }
        Boolean b = sysRoleService.save(role);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @GetMapping(BASE_URL_PATH + "/edit.html")
    public ModelAndView edit(String id) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/role_edit");
        SysRole role = sysRoleService.getById(id);
        view.addObject("role", role);
        return view;
    }

    @PostMapping(BASE_URL_PATH + "/edit.json")
    @ResponseBody
    public Result edit(SysRole role) {
        Boolean b = sysRoleService.updateRole(role);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @PostMapping(BASE_URL_PATH + "/delete.json")
    @ResponseBody
    public Result delete(String id) {
        Boolean b = sysRoleService.deleteRole(id);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @RequestMapping(BASE_URL_PATH + "/list.json")
    public Result selectRolePage(SysRoleQuery sysRoleQuery) {
        Page<SysRole> ipage = sysRoleService.getRoleList(sysRoleQuery);
        return Result.success(ipage);
    }


}

