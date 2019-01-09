package com.stylesmile.system.controller;

import com.stylesmile.system.entity.SysMenu;
import com.stylesmile.system.service.SysMenuService;
import com.stylesmile.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 菜单管理
 *
 * @author chenye
 * @date 2018/11/24
 */
@RestController
public class SysMenuController {
    private final String BASE_URL_PATH = "/menu";
    private final String BASE_HTML_PATH = "/system/sysMenu";
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 菜单首页
     *
     * @return
     */
    @GetMapping(BASE_URL_PATH + "/index.html")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/menu");
        return view;
    }

    /**
     * 首页数据
     *
     * @return
     */
    @RequestMapping(BASE_URL_PATH + "/list.json")
    @ResponseBody
    public Result<List<SysMenu>> list() {
        List<SysMenu> list = sysMenuService.geList();
        return Result.success(list);
    }

    /**
     * 进入新增菜单页面
     *
     * @return
     */
    @GetMapping(BASE_URL_PATH + "/add.html")
    public ModelAndView add() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/menu_add");
        return view;
    }

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    @PostMapping(BASE_URL_PATH + "/add.json")
    @ResponseBody
    public Result add(SysMenu menu) {
        Boolean b = sysMenuService.saveOrUpdate(menu);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 进入编辑菜单页面
     *
     * @param id
     * @return
     */
    @GetMapping(BASE_URL_PATH + "/edit.html")
    public ModelAndView edit(int id) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/menu_edit");
        SysMenu menu = sysMenuService.getById(id);
        view.addObject("menu", menu);
        return view;
    }

    /**
     * 编辑菜单
     *
     * @param sysMenu
     * @return
     */
    @PostMapping(BASE_URL_PATH + "/edit.json")
    @ResponseBody
    public Result edit(SysMenu sysMenu) {
        Boolean b = sysMenuService.updateMenu(sysMenu);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    @PostMapping(BASE_URL_PATH + "/delete.json")
    @ResponseBody
    public Result delete(String id) {
        Boolean b = sysMenuService.deleteMenu(id);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

}
