package com.stylesmile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author StyleSmile
 * @date 2019/1/16
 */
@MapperScan("com.stylesmile.modules.*.mapper")
@SpringBootApplication
public class SnowApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnowApplication.class, args);
    }

}
