package com.stylesmile.system.controller;

import com.stylesmile.log.aop.LogLoginAnnotation;
import com.stylesmile.system.service.SysMenuService;
import com.stylesmile.system.service.SysUserService;
import com.stylesmile.system.tree.MenuTree;
import com.stylesmile.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 首页
 *
 * @author chenye
 * @date 2018/11/18
 */
@Slf4j
@Controller
public class IndexController {

    @Resource
    SysUserService sysUserService;
    @Resource
    SysMenuService sysMenuService;


    /**
     * 登陆页面
     */
    @GetMapping(value = {"/", "/login.html"})
    public String login() {
        return "/login";
    }

    /**
     * 登陆方法
     *
     * @param username 登陆用户名称
     * @param password 密码
     * @return Result
     * <p>
     * LogLoginAnnotation 为登陆日志aop
     */
    @LogLoginAnnotation("登陆日志")
    @PostMapping("/login.json")
    @ResponseBody
    public Result<String> login(String username, String password, HttpSession session) {
        return sysUserService.getSysUserByNameAndPassword(username, password, session);
    }

    /**
     * 后台管理系统首页
     */
    @GetMapping("/index.html")
    public ModelAndView index(HttpServletRequest httpServletRequest) {
        ModelAndView view = new ModelAndView("/index");

        //通过用户id获取当前用户的菜单
        MenuTree menuTree = sysMenuService.getMenuListByUserId(httpServletRequest);
        view.addObject("menuList", menuTree.getChildren());
        return view;
    }

}
