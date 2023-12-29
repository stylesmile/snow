package com.stylesmile.modules.system.controller;

import com.stylesmile.modules.system.service.SysDepartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 部门用户管理
 *
 * @author chenye
 * @date 2019/08/07
 */
@Controller
public class SysDepartUserController {

    private final String BASE_URL_PATH = "/departUser";
    private final String BASE_HTML_PATH = "/system/sysDepartUser";

    @Resource
    private SysDepartService sysDepartService;

    /**
     * 部门用户首页
     */
    @GetMapping(BASE_URL_PATH + "/index.html")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/departUser");
        view.addObject("data", sysDepartService.getList(""));
        return view;
    }

}
