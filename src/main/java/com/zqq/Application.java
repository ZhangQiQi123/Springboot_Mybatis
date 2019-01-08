package com.zqq;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.zqq.mapper")
@ComponentScan(basePackages={"com.zqq.ctrl","com.zqq.service"})
@ServletComponentScan
public class Application{
	public static final Logger log=LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(Application.class);
		app.run(args);
		log.info(">>>>>>>>>>>>>>>>>>>启动成功<<<<<<<<<<<<<<<<<<<<");
	}
	


}
