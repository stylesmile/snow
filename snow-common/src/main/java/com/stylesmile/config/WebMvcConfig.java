package com.stylesmile.config;

import com.stylesmile.constant.SessionConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 *
 * @author chenye
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPattern后跟拦截地址，excludePathPatterns后跟排除拦截地址
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                //登录页面
                .excludePathPatterns("/").excludePathPatterns("/login.html").excludePathPatterns("/login.json")
                //注册页面
                .excludePathPatterns("/register.html")
                //注册方法
                .excludePathPatterns("/register.json")
                //静态资源
                .excludePathPatterns("/common/**").excludePathPatterns("/js/**").excludePathPatterns("/css/**").excludePathPatterns("/plugins/**");
    }

    class MyInterceptor implements HandlerInterceptor {
        /**
         * 在请求处理之前进行调用（Controller方法调用之前
         */
        @Override
        public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            HttpSession session = httpServletRequest.getSession();
            //获取登录的session信息
            Object user = session.getAttribute(SessionConstant.LOGIN_USER);
            if (null == user) {
                //未登录自动跳转界面
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.html");
                return false;
            } else {
                return true;
            }
        }

        /**
         * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
         */
        @Override
        public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

            System.out.println("postHandle被调用\n");
        }

        /**
         * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
         */
        @Override
        public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
            System.out.println("afterCompletion被调用\n");
        }
    }
}
