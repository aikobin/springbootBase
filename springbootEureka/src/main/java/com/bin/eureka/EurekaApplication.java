package com.bin.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka做服务发现。
 * @author bin
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
  public static void main(String[] args) {
	 // Properties systemProps = System.getProperties();  
	     //请将项目目录下的truststore放入c盘(写相对路径时会出错，只能写成系统绝对路径)
     // systemProps.put( "javax.net.ssl.trustStore", "C:\\truststore.jks");  
      
      //systemProps.put( "javax.net.ssl.trustStorePassword", "123456");  
     // System.setProperties(systemProps);  
    SpringApplication.run(EurekaApplication.class, args);
  }
}