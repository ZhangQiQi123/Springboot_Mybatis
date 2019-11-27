package com.zqq;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.xml.namespace.QName;

@SpringBootApplication
@MapperScan("com.zqq.mapper")
@ServletComponentScan
//apollo启动
//@EnableApolloConfig
//Quartz启动
//@EnableScheduling
@Slf4j
public class Application {
	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(Application.class);
		app.run(args);
		log.info(">>>>>>>>>>>>>>>>>>>启动成功<<<<<<<<<<<<<<<<<<<<");

	}
	


}
