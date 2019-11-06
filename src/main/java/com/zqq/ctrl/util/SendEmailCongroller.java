package com.zqq.ctrl.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqq.service.impl.MailServiceImpl;
/**
 * 发送邮件
 * @author 17612
 * 步骤：1.pom.xml
 * 		<dependency>  
 *		    <groupId>org.springframework.boot</groupId>
 *		    <artifactId>spring-boot-starter-mail</artifactId>
 *		 </dependency>
 *		2.application-dev.properties
 *		#腾讯企业邮箱发送邮件
 *		spring.mail.host=smtp.exmail.qq.com
 *		#发送邮箱
 *		spring.mail.username=zhang_qiqi@hulftchina.com
 *		#授权码
 *		spring.mail.password=i56cLCPY4dkYtfQG
 *		spring.mail.properties.mail.smtp.auth=true
 *		spring.mail.properties.mail.smtp.starttls.enable=true
 *		spring.mail.properties.mail.smtp.starttls.required=true
 */
@Controller
public class SendEmailCongroller {

	@Autowired
	private MailServiceImpl mailService;
	
	@ResponseBody
	@RequestMapping("/sendMail")
	public String sendEmail(){
//		mailService.sendMail("自定义标题1", "ZhangQiQi", "17612197279@163.com");
//		mailService.sendMail("自定义标题2", "LiLing", "1270442681@qq.com");
		return "success";
	}
}
