package com.stylesmile.modules.system.controller;

import com.stylesmile.modules.system.entity.SysMenu;
import com.stylesmile.modules.system.service.SysMenuService;
import com.stylesmile.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
     */
    @GetMapping(BASE_URL_PATH + "/index.html")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/menu");
        return view;
    }

    /**
     * 首页数据
     *
     * @return List
     */
    @GetMapping(BASE_URL_PATH + "/list.json")
    @ResponseBody
    public Result<List<SysMenu>> list() {
        return Result.success(sysMenuService.getList());
    }

    /**
     * 进入新增菜单页面
     */
    @GetMapping(BASE_URL_PATH + "/add.html")
    public ModelAndView add(String parentId) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/menu_add");
        view.addObject("parentId", parentId);
        return view;
    }

    /**
     * 新增菜单
     *
     * @param menu 菜单信息
     * @return Result
     */
    @PostMapping(BASE_URL_PATH + "/add.json")
    @ResponseBody
    public Result add(SysMenu menu) {
        return Result.bool(sysMenuService.save(menu));
    }

    /**
     * 进入编辑菜单页面
     *
     * @param id 主键
     */
    @GetMapping(BASE_URL_PATH + "/edit.html")
    public ModelAndView edit(Long id) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/menu_edit");
        SysMenu menu = sysMenuService.getById(id);
        view.addObject("menu", menu);
        return view;
    }

    /**
     * 编辑菜单
     *
     * @param sysMenu 菜单
     */
    @PostMapping(BASE_URL_PATH + "/edit.json")
    @ResponseBody
    public Result edit(SysMenu sysMenu) {
        return Result.bool(sysMenuService.updateById(sysMenu));
    }

    /**
     * 删除菜单
     *
     * @param id 主键
     */
    @PostMapping(BASE_URL_PATH + "/delete.json")
    @ResponseBody
    public Result delete(String id) {
        return Result.bool(sysMenuService.deleteMenu(id));
    }
}
