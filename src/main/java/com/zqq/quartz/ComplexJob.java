package com.zqq.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/23 17:16
 * @Description: com.zqq.model
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Configuration
public class ComplexJob implements SchedulingConfigurer {



    //任务，触发器
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        String cron= cronService.getAllgetAllCrons("1");
//        //lambada表达式
//        taskRegistrar.addTriggerTask(
//                () ->
//                //写任务
//                System.err.println(LocalDateTime.now()+"任务一"),
//                triggerContext -> {
//                   return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//
//        );


    }
}
