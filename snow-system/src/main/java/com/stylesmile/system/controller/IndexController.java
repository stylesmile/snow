package com.stylesmile.system.controller;

import com.stylesmile.system.service.SysUserService;
import com.stylesmile.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    SysUserService sysUserService;

    /**
     * 登陆页面
     */
    @GetMapping("/")
    public String login() {
        return "/login";
    }

    /**
     * 登陆方法
     *
     * @param username 登陆用户名称
     * @param password 密码
     * @return Result
     */
    @PostMapping("/login.json")
    @ResponseBody
    public Result<String> login(String username, String password, HttpSession session) {
        return sysUserService.getSysUserByNameAndPassword(username, password,session);
    }

    /**
     * 后台首页
     */
    @GetMapping("/index.html")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/index");
        view.addObject("menu", "菜单");
        return view;
    }
}
