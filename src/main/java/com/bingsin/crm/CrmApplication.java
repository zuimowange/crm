package com.bingsin.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bingsin.crm.config.TokenInterceptor;


@SpringBootApplication
public class CrmApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}
	
	/**
	 * 配置拦截器
	 */
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/**/login");
    }
}
