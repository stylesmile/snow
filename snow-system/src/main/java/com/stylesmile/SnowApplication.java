package com.stylesmile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 *
 * @author StyleSmile
 * @date 2019/1/16
 */
//@MapperScan("com.stylesmile.system.dao")
//开启缓存
@EnableCaching
@SpringBootApplication
public class SnowApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnowApplication.class, args);
    }

}
