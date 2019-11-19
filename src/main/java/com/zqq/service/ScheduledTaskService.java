package com.zqq.service;

import com.zqq.model.ScheduledTaskBean;

import java.util.List;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/28 14:38
 * @Description: com.zqq.service 定时任务接口
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
public interface ScheduledTaskService {

    /**
     * 所有任务列表
     */
    List<ScheduledTaskBean> taskList();

    /**
     * 根据任务Key,启动任务
     */
    Boolean start(String taskKey);

    /**
     * 根据任务key,停止任务
     * @param taskKey 任务Key
     * @return true or false
     */
    Boolean stop(String taskKey);

    /**
     * 根据任务Key 重启任务
     * @param taskKey 任务Key
     * @return true or false
     */
    Boolean restart(String taskKey);

    void initAllTask(List<ScheduledTaskBean> scheduledTaskBeanList);
}
