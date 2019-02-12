package com.stylesmile.system.controller;

import com.stylesmile.system.entity.SysDepart;
import com.stylesmile.system.service.SysDepartService;
import com.stylesmile.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理
 *
 * @author chenye
 * @date 2018/11/24
 */
@RestController
public class SysDepartController {
    private final String BASE_URL_PATH = "/depart";
    private final String BASE_HTML_PATH = "/system/sysDepart";
    @Resource
    private SysDepartService sysDepartService;

    /**
     * 部门首页
     */
    @GetMapping(BASE_URL_PATH + "/index.html")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/depart");
        return view;
    }

    /**
     * 首页数据
     *
     * @return List
     */
    @GetMapping(BASE_URL_PATH + "/list.json")
    @ResponseBody
    public Result<List<SysDepart>> list() {
        return Result.success(sysDepartService.getList());
    }

    /**
     * 进入新增部门页面
     */
    @GetMapping(BASE_URL_PATH + "/add.html")
    public ModelAndView add(String parentId) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/depart_add");
        view.addObject("parentId", parentId);
        return view;
    }

    /**
     * 新增部门
     *
     * @param depart 部门信息
     * @return Result
     */
    @PostMapping(BASE_URL_PATH + "/add.json")
    @ResponseBody
    public Result add(SysDepart depart) {
        return Result.bool(sysDepartService.save(depart));
    }

    /**
     * 进入编辑部门页面
     *
     * @param id 主键
     */
    @GetMapping(BASE_URL_PATH + "/edit.html")
    public ModelAndView edit(Long id) {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/depart_edit");
        SysDepart depart = sysDepartService.getById(id);
        view.addObject("depart", depart);
        return view;
    }

    /**
     * 编辑部门
     *
     * @param sysDepart 部门
     */
    @PostMapping(BASE_URL_PATH + "/edit.json")
    @ResponseBody
    public Result edit(SysDepart sysDepart) {
        return Result.bool(sysDepartService.updateById(sysDepart));
    }

    /**
     * 删除部门
     *
     * @param id 主键
     */
    @PostMapping(BASE_URL_PATH + "/delete.json")
    @ResponseBody
    public Result delete(String id) {
        return Result.bool(sysDepartService.deleteDepart(id));
    }
}
