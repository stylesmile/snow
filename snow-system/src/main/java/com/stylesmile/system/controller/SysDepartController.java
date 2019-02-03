package com.stylesmile.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.query.SysUserQuery;
import com.stylesmile.system.service.SysUserService;
import com.stylesmile.util.Result;
import com.stylesmile.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 部门管理
 *
 * @author chenye
 * @date 2018/12/08
 */
@RestController
public class SysDepartController {

    private final String BASE_URL_PATH = "/depart";
    private final String BASE_HTML_PATH = "/system/sysDepart";

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(BASE_URL_PATH + "/index.html")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/index");
        return view;
    }

    @GetMapping(BASE_URL_PATH + "/add.html")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/add");
        return view;
    }

    @PostMapping(BASE_URL_PATH + "/add.json")
    @ResponseBody
    public Result add(SysUser user) {
        user.setId(UUIDUtil.getUUID());
        return Result.bool(sysUserService.saveOrUpdate(user));
    }

    @GetMapping(BASE_URL_PATH + "/edit.html")
    public ModelAndView edit(String id) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/edit");
        SysUser user = sysUserService.getById(id);
        view.addObject("user", user);
        return view;
    }

    @PostMapping(BASE_URL_PATH + "/edit.json")
    @ResponseBody
    public Result edit(SysUser user) {
        return Result.bool(sysUserService.updateUser(user));
    }

    @PostMapping(BASE_URL_PATH + "/delete.json")
    @ResponseBody
    public Result delete(String id) {
        return Result.bool(sysUserService.deleteUser(id));
    }

    @PostMapping(BASE_URL_PATH + "/list.json")
    public Result selectUserPage(SysUserQuery sysUserQuery) {
        return Result.success(sysUserService.getUserList(sysUserQuery));
    }

}
