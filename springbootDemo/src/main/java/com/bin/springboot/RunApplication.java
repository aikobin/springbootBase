package com.bin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCaching //开启缓存
@EnableDiscoveryClient //开启eureka客户端
public class RunApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(RunApplication.class, args);
	}

}
