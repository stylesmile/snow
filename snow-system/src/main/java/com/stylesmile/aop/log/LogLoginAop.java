package com.stylesmile.aop.log;


import com.stylesmile.log.service.LogLoginService;
import com.stylesmile.system.entity.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * 登陆日志AOP
 *
 * @author chenye
 * @date 2019/2/26
 */
@Component
//将一个类定义为一个切面类
@Aspect
//标记切面类的处理优先级,i值越小,优先级别越高.PS:可以注解类,也能注解到方法上
//@Order(10)
public class LogLoginAop {

    private static final Logger log = LoggerFactory.getLogger(LogLoginAop.class);

    @Resource
    private LogLoginService logLoginService;

    /**
     * 切入点描述 这个是controller包的切入点
     */
    @Pointcut("execution(public * com.stylesmile.system.controller..*.*(..))")
    public void controllerLog() {
        //签名，可以理解成这个切入点的一个名称
    }

    /**
     * 后置通知，扫描stylesmile包及此包下的所有带有SystemLogAnnotation注解的方法
     * Created on 2019/2/26
     *
     * @param joinPoint 前置参数
     */
    //@After(("execution(public * com.stylesmile.system.controller..*.*(..)) && @annotation(LogLoginAnnotation)"))
    //@After("execution(public * com.stylesmile.system.controller..*.*(..))")
    @Before("controllerLog()&& @annotation(LogLogin)")
    public void doAfterAdvice(JoinPoint joinPoint) {
        log.info("=========================================用户操作日志-后置通知开始执行......=========================================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            log.info("name:{},value:{}", name, request.getParameter(name));
        }
        try {
            //从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature1 = (MethodSignature) joinPoint.getSignature();
            //获取切入点所在的方法
            Method method1 = signature1.getMethod();
            //获取操作
            LogLogin myLog = method1.getAnnotation(LogLogin.class);
            if (myLog != null) {
                String value = myLog.value();
                //保存登陆日志信息入库
                addSystemLog(value, request.getRemoteAddr());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("=========================================用户操作日志-后置通知结束执行......=========================================");
    }

    /**
     * 保存操作日志
     *
     * @param operationContent 操作内容
     */
    public void addSystemLog(String operationContent, String ip) {
        // 获取此次请求的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取当前登录人的信息
        SysUser sysUser = (SysUser) logLoginService.getCurrentUser(request.getSession());
        if (null != sysUser) {
            //status = 1 登陆成功
            com.stylesmile.log.entity.LogLogin  logLogin = new com.stylesmile.log.entity.LogLogin(operationContent, sysUser.getId(), sysUser.getUsername(), ip, 1);
            logLoginService.save(logLogin);
        } else {
            //status = 0 登陆未成功
            //LogLogin logLogin = new LogLogin(operationContent, sysUser.getId(), sysUser.getUsername(), ip, 0);
            //logLoginService.save(logLogin);
        }
    }

}
