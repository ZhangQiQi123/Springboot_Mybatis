package com.zqq.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zqq.mapper")
@ComponentScan(basePackages={"com.zqq.ctrl","com.zqq.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(Application.class);
		app.run(args);

	}

}
