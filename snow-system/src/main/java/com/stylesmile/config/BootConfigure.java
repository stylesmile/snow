package com.stylesmile.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置 spring-boot
 * <p>
 * Configuration 配置注解
 * EnableCaching 开启缓存
 * EnableTransactionManagement 开启事务
 */
@Configuration
@MapperScan("com.stylesmile.system.dao")
@EnableCaching
@EnableTransactionManagement
public class BootConfigure {

}
