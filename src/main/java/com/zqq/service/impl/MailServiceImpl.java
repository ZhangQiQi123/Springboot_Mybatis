package com.zqq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailSender {

//	 @Autowired
//     private JavaMailSender mailSender; //框架自带的
//
//     @Value("${spring.mail.username}")  //发送人的邮箱  比如155156641XX@163.com
//     private String from;
//
//    /**
//     * 发邮件
//     * @param title 标题
//     * @param content 内容
//     * @param email 接收方邮箱
//     */
//     @Async  //意思是异步调用这个方法
//     public void sendMail(String title, String content, String email) {
//	    SimpleMailMessage message = new SimpleMailMessage();
//	    message.setFrom(from); // 发送人的邮箱
//	    message.setSubject(title); //标题
//	    message.setTo(email); //发给谁  对方邮箱
//	    message.setText(content); //内容
//	    mailSender.send(message); //发送
//     }

    @Override
    public void send(SimpleMailMessage simpleMessage) throws MailException {

    }

    @Override
    public void send(SimpleMailMessage... simpleMessages) throws MailException {

    }
}
