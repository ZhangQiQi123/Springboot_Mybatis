package com.zqq;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
<<<<<<< HEAD:src/main/java/com/zqq/Application.java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======

>>>>>>> 08dee62ec31037cde87a825a152904bd88559788:src/main/java/com/zqq/test/Application.java
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
<<<<<<< HEAD:src/main/java/com/zqq/Application.java
public class Application{
	public static final Logger log=LoggerFactory.getLogger(Application.class);
=======
public class Application {
	public static final Logger log=Logger.getLogger(Application.class);
>>>>>>> 08dee62ec31037cde87a825a152904bd88559788:src/main/java/com/zqq/test/Application.java

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(Application.class);
		app.run(args);
		log.info(">>>>>>>>>>>>>>>>>>>启动成功<<<<<<<<<<<<<<<<<<<<");
	}
	


}
