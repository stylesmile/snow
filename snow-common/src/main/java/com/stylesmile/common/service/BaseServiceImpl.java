package com.stylesmile.common.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stylesmile.constant.SessionConstant;
import com.stylesmile.constant.UserConstant;

import javax.servlet.http.HttpSession;

/**
 * 公共service
 *
 * @author StyleSmile
 * @date 2019/1/8 /21:18
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    public Object getCurrentUser(HttpSession session) {
        return session.getAttribute(SessionConstant.LOGIN_USER);
    }

}
