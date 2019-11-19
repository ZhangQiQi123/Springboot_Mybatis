package com.zqq.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/23 15:27
 * @Description: com.zqq.quartz
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */

@Configuration
//@EnableScheduling//开启任务调度
public class SimpleJob {

    @Scheduled(cron = "0/2 * * * * ?")//调度器
    protected void run() {
        System.out.println(LocalDateTime.now());
    }

    @Scheduled(cron = "0/5 * * * * ?")//调度器
    protected void run2() {
        System.out.println(LocalDateTime.now()+"------------");
    }
}
