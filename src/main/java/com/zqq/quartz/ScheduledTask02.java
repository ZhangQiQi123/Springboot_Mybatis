package com.zqq.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/25 10:20
 * @Description: com.zqq.quartz
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
public class ScheduledTask02 implements  ScheduledTaskJob  {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTask02.class);

    @Override
    public void run() {
        LOGGER.info("ScheduledTask => 02 run 当前线程名称 {} ", Thread.currentThread().getName());
    }
}
