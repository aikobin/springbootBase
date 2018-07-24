package com.bin.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.bin.gateway.filter.PreRequestLogFilter;
/**
 * @author Thibaud Leprêtre
 */
@SpringBootApplication
@EnableZuulProxy
//开启单点登录的注解
//@EnableOAuth2Sso

@EnableDiscoveryClient
@EnableScheduling
public class ApiGatewayApplication {

    public static void main(String[] args) {
    	// Properties systemProps = System.getProperties();  
   	     //请将项目目录下的truststore放入c盘(写相对路径时会出错，只能写成系统绝对路径)
        // systemProps.put( "javax.net.ssl.trustStore", "C:\\truststore.jks");    
        //systemProps.put( "javax.net.ssl.trustStorePassword", "123456");  
      // System.setProperties(systemProps);  
         
        SpringApplication.run(ApiGatewayApplication.class, args);
        
    }

    
    @Bean
    public PreRequestLogFilter preRequestLogFilter() {
    	return new PreRequestLogFilter();
    }
    
  /*  @Bean
    UserInfoRestTemplateCustomizer userInfoRestTemplateCustomizer(SpringClientFactory springClientFactory) {
        return template -> {
            AccessTokenProviderChain accessTokenProviderChain = Stream
                    .of(
                            new AuthorizationCodeAccessTokenProvider(),
                            new ImplicitAccessTokenProvider(),
                            new ResourceOwnerPasswordAccessTokenProvider(),
                            new ClientCredentialsAccessTokenProvider())
                    .peek(tp -> tp.setRequestFactory(new RibbonClientHttpRequestFactory(springClientFactory)))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), AccessTokenProviderChain::new));
            template.setAccessTokenProvider(accessTokenProviderChain);
        };
    }*/

}
