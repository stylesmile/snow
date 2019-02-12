package com.stylesmile.system.controller;

import com.stylesmile.system.service.SysRoleMenuService;
import com.stylesmile.util.ConvertUtil;
import com.stylesmile.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户管理
 *
 * @author StyleSmile
 * @date 2018/12/08
 */
@RestController
public class SysRoleMenuController {

    private final String BASE_URL_PATH = "/roleMenu";
    private final String BASE_HTML_PATH = "/system/sysRoleMenu";
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 用户角色管理页面
     */
    @GetMapping(BASE_URL_PATH + "/roleMenu.html")
    @ResponseBody
    public ModelAndView userRole(Integer roleId) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/role_menu");
        view.addObject("roleId", roleId);
        view.addObject("roleMenuList", sysRoleMenuService.getRoleMenuList(roleId));
        return view;
    }

    /**
     * 首页数据
     *
     * @return List
     */
    @PostMapping(BASE_URL_PATH + "/roleMenu.json")
    @ResponseBody
    public Result<List<Integer>> roleMenu(Integer roleId) {
        return Result.success(sysRoleMenuService.getRoleMenuList(roleId));
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
     * 角色增加菜单
     *
     * @param roleId  角色id
     * @param menuIds 以逗号分隔的菜单id
     * @return Boolean
     */
    @PostMapping(BASE_URL_PATH + "/saveRoleMenu.json")
    @ResponseBody
    public Result saveRoleMenu(Integer roleId, String menuIds) {
        //增加
        return Result.bool(sysRoleMenuService.addRoleMenu(roleId, menuIds));
    }

    /**
     * 删除角色拥有的菜单
     */
    @PostMapping(BASE_URL_PATH + "/deleteRoleMenu.json")
    @ResponseBody
    public Result deleteRoleMenu(String ids) {
        //批量删除
        return Result.bool(sysRoleMenuService.removeByIds(ConvertUtil.strToLongList(ids)));
    }

}
