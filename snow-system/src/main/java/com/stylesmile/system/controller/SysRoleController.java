package com.stylesmile.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stylesmile.system.entity.SysRole;
import com.stylesmile.system.query.SysRoleQuery;
import com.stylesmile.system.service.SysRoleService;
import com.stylesmile.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 角色管理
 *
 * @author StyleSmile
 * @date 2018/12/08
 */
@RestController
public class SysRoleController {

    private final String BASE_URL_PATH = "/role";
    private final String BASE_HTML_PATH = "/system/sysRole";
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 角色管理首页
     */
    @GetMapping(BASE_URL_PATH + "/index.html")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/role");
        return view;
    }

    /**
     * 角色管理首页数据
     *
     * @param sysRoleQuery 角色查询对象
     * @return Result
     */
    @GetMapping(BASE_URL_PATH + "/list.json")
    public Result selectRolePage(SysRoleQuery sysRoleQuery) {
        Page<SysRole> ipage = sysRoleService.getRoleList(sysRoleQuery);
        return Result.success(ipage);
    }

    /**
     * 进入角色添加页面
     */
    @GetMapping(BASE_URL_PATH + "/add.html")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/role_add");
        return view;
    }

    /**
     * 角色添加
     *
     * @param role 角色信息
     */
    @PostMapping(BASE_URL_PATH + "/add.json")
    @ResponseBody
    public Result add(SysRole role) {
        //判断编号code是否重复
        Integer count = sysRoleService.checkDuplicate(role.getCode());
        if (count > 0) {
            return Result.fail("编号重复!");
        }
        return Result.bool(sysRoleService.save(role));
    }

    /**
     * 进入角色编辑页面
     *
     * @param id 主键
     */
    @GetMapping(BASE_URL_PATH + "/edit.html")
    public ModelAndView edit(String id) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/role_edit");
        SysRole role = sysRoleService.getById(id);
        view.addObject("role", role);
        return view;
    }

    /**
     * 角色编辑
     *
     * @param role 角色信息
     * @return Result
     */
    @PostMapping(BASE_URL_PATH + "/edit.json")
    @ResponseBody
    public Result edit(SysRole role) {
        return Result.bool(sysRoleService.updateRole(role));
    }

    /**
     * 删除角色
     *
     * @param id 主键
     * @return Result
     */
    @PostMapping(BASE_URL_PATH + "/delete.json")
    @ResponseBody
    public Result delete(String id) {
        return Result.bool(sysRoleService.deleteRole(id));
    }

}

