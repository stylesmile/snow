//package com.stylesmile.log.aop;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stylesmile.log.entity.LogLogin;
//import com.stylesmile.log.service.LogLoginService;
//import com.stylesmile.system.entity.SysUser;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 日志切面类
// */
//@Aspect
//@Component
//public class LogAspect {
//
//    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
//        @Resource
//    private LogLoginService logLoginService;
//    // ..表示包及子包 该方法代表controller层的所有方法
//    @Pointcut("execution(public * com.stylesmile.system.controller..*.*(..))")
//    public void controllerMethod() {
//    }
//
//
//    @Before("controllerMethod()")
//    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
//
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        StringBuffer requestLog = new StringBuffer();
//        requestLog.append("请求信息：").append("URL = {" + request.getRequestURI() + "},\t").append("HTTP_METHOD = {" + request.getMethod() + "},\t").append("IP = {" + request.getRemoteAddr() + "},\t").append("CLASS_METHOD = {" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "},\t");
//
//        if (joinPoint.getArgs().length == 0) {
//            requestLog.append("ARGS = {} ");
//        } else {
//            requestLog.append("ARGS = " + new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(joinPoint.getArgs()[0]) + "");
//        }
//
//        logger.info(requestLog.toString());
//    }
//    /**
//     * 保存操作日志
//     *
//     * @param operationContent 操作内容
//     */
//    public void addSystemLog(String operationContent) {
//        // 获取此次请求的request对象
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        // 获取当前登录人的信息
//        SysUser sysUser = (SysUser) logLoginService.getCurrentUser(request.getSession());
//        LogLogin logLogin = new LogLogin(operationContent, sysUser.getId(), sysUser.getUsername());
//        logLoginService.save(logLogin);
//    }
//
//
//}
