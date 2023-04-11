package com.snew.snoweureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SnowEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowEurekaApplication.class, args);
	}

}
