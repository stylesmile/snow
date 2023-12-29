package com.stylesmile.common.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stylesmile.common.constant.SessionConstant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 公共service
 *
 * @author StyleSmile
 * @date 2019/1/8 /21:18
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    /**
     * get session中的用户
     *
     * @param session 会话
     * @return Object
     */
    @Override
    public Object getCurrentUser(HttpSession session) {
        return session.getAttribute(SessionConstant.LOGIN_USER);
    }

    /**
     * 获取 HttpRequest
     * 中的
     *
     * @return HttpRequest
     */
    @Override
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    /**
     * 获取 HttpServletResponse
     *
     * @return HttpServletResponse
     */
    @Override
    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
