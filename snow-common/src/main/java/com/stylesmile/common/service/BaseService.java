package com.stylesmile.common.service;

import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;

/**
 * common
 *
 * @Author StyleSmile
 * @Date 2019/1/8 /21:18
 */
public interface BaseService<T> extends IService<T> {
    /**
     * 获取当前登陆用户
     *
     * @return
     */
    Object getCurrentUser(HttpSession session);

}
