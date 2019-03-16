package com.stylesmile.log.aop;


import com.stylesmile.log.service.LogLoginService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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

    @Pointcut("execution(public * com.stylesmile.system.controller..*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称

    /**
     * 后置通知，扫描stylesmile包及此包下的所有带有SystemLogAnnotation注解的方法
     * Created on 2019/2/26
     *
     * @param joinPoint          前置参数
     */
    //@After(("execution(public * com.stylesmile.system.controller..*.*(..)) && @annotation(LogLoginAnnotation)"))
    //@After("execution(public * com.stylesmile.system.controller..*.*(..))")
    @Before("controllerLog()")
    public void doAfterAdvice(JoinPoint joinPoint) {
        log.info("=========================================用户操作日志-后置通知开始执行......=========================================");
        //String value = logLoginAnnotation.value();
        System.out.println("...................");
        System.out.println("...................");
        System.out.println("...................");
        System.out.println("...................");
        //addSystemLog(value);
        log.info("=========================================用户操作日志-后置通知结束执行......=========================================");
    }

    /**
     * 保存操作日志
     *
     * @param operationContent 操作内容
     */
//    public void addSystemLog(String operationContent) {
//        // 获取此次请求的request对象
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        // 获取当前登录人的信息
//        SysUser sysUser = (SysUser) logLoginService.getCurrentUser(request.getSession());
//        LogLogin logLogin = new LogLogin(operationContent, sysUser.getId(), sysUser.getUsername());
//        logLoginService.save(logLogin);
//    }

    /**
     * <p>Discription:[根据request获取前台浏览器标识]</p>
     * Created on 2017年11月20日 下午7:30:08
     * @param request request对象
     * @return String 浏览器标识
     */
//	private static String getBrowserInfo(HttpServletRequest request) {
//		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
//		String browserInfo = userAgent.getBrowser().toString();
//		return browserInfo;
//	}
}
