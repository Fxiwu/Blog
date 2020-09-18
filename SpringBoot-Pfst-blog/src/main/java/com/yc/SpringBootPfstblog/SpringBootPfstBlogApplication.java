package com.yc.SpringBootPfstblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.yc.SpringBootPfstblog")
public class SpringBootPfstBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPfstBlogApplication.class, args);
	}

}
