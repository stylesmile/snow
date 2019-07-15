//package com.stylesmile.config;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//@Configuration
//public class CacheConfig {
//
//	/**
//	 * 给CacheHelper用的cacheManager
//	 *
//	 * @param bean
//	 * @return
//	 */
//	@Bean(name = "ehCacheManager")
//	public CacheManager cacheManager(EhCacheManagerFactoryBean bean) {
//		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("myEhcache.xml"));
//		cacheManagerFactoryBean.setShared(true);
//		return bean.getObject();
//	}
//}
