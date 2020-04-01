package com.stylesmile.modules.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.modules.system.entity.SysUser;
import com.stylesmile.modules.system.query.SysUserQuery;
import com.stylesmile.modules.system.service.SysUserService;
import com.stylesmile.common.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 用户管理
 *
 * @author StyleSmile
 * @date 2018/12/08
 */
@Controller
public class SysUserController {

    private final String BASE_URL_PATH = "/user";
    private final String BASE_HTML_PATH = "/system/sysUser";

    @Resource
    private SysUserService sysUserService;

    /**
     * 菜单管理
     */
    @GetMapping(BASE_URL_PATH + "/index.html")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/user");
        return view;
    }

    /**
     * 首页数据
     */
    @GetMapping(BASE_URL_PATH + "/list.json")
    @ResponseBody
    public Result selectUserPage(SysUserQuery sysUserQuery) {
        Page<SysUser> page = sysUserService.getUserList(sysUserQuery);
        return Result.success(page);
    }

    /**
     * 进入新增用户页面
     */
    @GetMapping(BASE_URL_PATH + "/add.html")
    public ModelAndView add() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/user_add");
        return view;
    }

    /**
     * 新增用户
     */
    @PostMapping(BASE_URL_PATH + "/add.json")
    @ResponseBody
    public Result add(SysUser user) {
        return Result.bool(sysUserService.saveOrUpdate(user));
    }

    /**
     * 进入编辑用户页面
     *
     * @param id 主键
     */
    @GetMapping(BASE_URL_PATH + "/edit.html")
    public ModelAndView edit(String id) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/user_edit");
        SysUser user = sysUserService.getById(id);
        view.addObject("user", user);
        return view;
    }

    /**
     * 编辑用户
     */
    @PostMapping(BASE_URL_PATH + "/edit.json")
    @ResponseBody
    public Result edit(SysUser user) {
        Boolean b = sysUserService.updateUser(user);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 删除用户
     */
    @PostMapping(BASE_URL_PATH + "/delete.json")
    @ResponseBody
    public Result delete(Integer id) {
        Boolean b = sysUserService.deleteUser(id);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

}
