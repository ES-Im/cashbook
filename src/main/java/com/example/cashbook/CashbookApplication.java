package com.example.cashbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.cashbook.interceptor.AdminInterceptor;
import com.example.cashbook.interceptor.MemberInterceptor;
import com.example.cashbook.interceptor.OffInterceptor;

@SpringBootApplication
public class CashbookApplication implements WebMvcConfigurer {
	@Autowired AdminInterceptor adminInterceptor;
	@Autowired MemberInterceptor memberInterceptor;
	@Autowired OffInterceptor offInterceptor;
	
	public static void main(String[] args) {
		SpringApplication.run(CashbookApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//adminSession
		registry.addInterceptor(adminInterceptor).addPathPatterns("/member/**").addPathPatterns("/off/**");
		//memberSession
		registry.addInterceptor(memberInterceptor).addPathPatterns("/admin/**").addPathPatterns("/off/**");
		//offSession
		registry.addInterceptor(offInterceptor).addPathPatterns("/admin/**").addPathPatterns("/member/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	

}
