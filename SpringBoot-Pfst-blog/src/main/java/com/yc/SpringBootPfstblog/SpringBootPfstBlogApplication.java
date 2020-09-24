package com.yc.SpringBootPfstblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.SpringBootPfstblog.web.LoginInterceptor;

@SpringBootApplication
@MapperScan("com.yc.SpringBootPfstblog")
public class SpringBootPfstBlogApplication implements WebMvcConfigurer{

	@Override   //拦截器注册方法  参数：拦截器注册器
	public void addInterceptors(InterceptorRegistry registry) {
		 
		WebMvcConfigurer.super.addInterceptors(registry);
		InterceptorRegistration	ir=registry.addInterceptor(new LoginInterceptor());
		ir.addPathPatterns("/toAddArticle","/addrticle.do");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPfstBlogApplication.class, args);
	}

}
