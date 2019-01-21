package com.stylesmile.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.entity.SysUserRole;
import com.stylesmile.system.query.SysRoleQuery;
import com.stylesmile.system.service.SysUserRoleService;
import com.stylesmile.util.Result;
import com.stylesmile.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author StyleSmile
 * @date 2018/12/08
 */
@RestController
public class SysUserRoleController {

    private final String BASE_URL_PATH = "/userRole";
    private final String BASE_HTML_PATH = "/system/sysUserRole";
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 用户角色管理页面
     */
    @GetMapping(BASE_URL_PATH + "/userRole.html")
    @ResponseBody
    public ModelAndView userRole(String userId) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/user_role");
        view.addObject("userId", userId);
        return view;
    }

    /**
     * 通过用户id 查询该用户拥有的角色
     * 用户角色管理页面数据
     *
     * @param sysRoleQuery 用户id
     * @return Result
     */
    @GetMapping(BASE_URL_PATH + "/userRoleList.json")
    public Result selectRolePage(SysRoleQuery sysRoleQuery) {
        Page<SysRole> ipage = sysUserRoleService.getUserRoleList(sysRoleQuery);
        return Result.success(ipage);
    }

    /**
     * 用户角色添加 页面
     */
    @GetMapping(BASE_URL_PATH + "/userRoleAdd.html")
    @ResponseBody
    public ModelAndView userRoleAdd() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/user_role_add");
        return view;
    }

    /**
     * 增加用户拥有的角色
     */
    @PostMapping(BASE_URL_PATH + "/addRole.json")
    @ResponseBody
    public Result addRole(String roleIds, HttpSession session) {

        Boolean b = sysUserRoleService.addRole(roleIds, session);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 删除用户拥有的角色
     */
    @PostMapping(BASE_URL_PATH + "/deleteRole.json")
    @ResponseBody
    public Result deleteRole(String id) {
        Boolean b = sysUserRoleService.deleteRole(id);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

}
