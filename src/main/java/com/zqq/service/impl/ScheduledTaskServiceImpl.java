package com.zqq.service.impl;

import com.zqq.mapper.ScheduledTaskMapper;
import com.zqq.model.ScheduledTaskBean;
import com.zqq.quartz.ScheduledTaskJob;
import com.zqq.service.ScheduledTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/28 14:44
 * @Description: com.zqq.service.impl 定时任务实现
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Service
@Slf4j
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

    @Autowired
    private ScheduledTaskMapper scheduledTaskMapper;


    // 可重入锁
    private ReentrantLock lock=new ReentrantLock();
    //定时任务线程池
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    /**
     * 所有定时任务存放的Map
     * key:任务Key
     * value:任务实现
     */
    @Autowired
    @Qualifier(value = "scheduledTaskJobMap")
    private Map<String, ScheduledTaskJob> scheduledTaskJobMap;
    //存放已经启动的任务Map
    private Map<String, ScheduledFuture> scheduledFutureMap=new ConcurrentHashMap<>();

    /**
     * 所有任务列表
     * @return
     */
    @Override
    public List<ScheduledTaskBean> taskList() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>获取任务列表开始<<<<<<<<<<<<<<<<<<<<<<<<");
        //数据库查询所有任务=>未做分页
        List<ScheduledTaskBean> taskBeanList=scheduledTaskMapper.getAllTask();
        if (CollectionUtils.isEmpty(taskList())){
            return new ArrayList<>();
        }
        for (ScheduledTaskBean taskBean:taskBeanList){
            String taskKey=taskBean.getTaskKey();
            //是否启动标记处理
            taskBean.setStartFlag(this.isStart(taskKey));
        }
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>获取任务列表结束<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return taskBeanList;
    }

    /**
     * 根据任务key 启动任务
     * @param taskKey
     * @return
     */
    @Override
    public Boolean start(String taskKey) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>启动任务{}开始>>>>>>>>>>>>>>>>>>>>>>",taskKey);
        //添加锁放一个线程启动，防止多人启动多次
        lock.lock();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>添加任务启动锁完毕！<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        try{
            //校验是否已经启动
            if(this.isStart(taskKey)){
                log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>当前任务已经启动，无需重复启动<<<<<<<<<<<<<<<<<<<<<<<<<");
                return false;
            }
            //校验任务是否存在
            if (!scheduledTaskJobMap.containsKey(taskKey)){
                return false;
            }
            //根据key数据库获取任务配置信息
            ScheduledTaskBean scheduledTaskBean=scheduledTaskMapper.getByKey(taskKey);
            //启动任务
            this.doStartTask(scheduledTaskBean);
        } finally {
            //释放锁
            lock.unlock();
            log.info(">>>>>>>>>>>>>>>>>>释放任务启动锁完毕<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }

        log.info(">>>>>>>>>>>>>>>>>>>>>启动任务{}结束<<<<<<<<<<<<<<<<<<<<<<<<",taskKey);
        return true;

    }

    /**
     * 根据Key 重启任务
     * @param taskKey 任务Key
     * @return
     */
    @Override
    public Boolean stop(String taskKey) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>进入停止任务{}",taskKey);
        //当前任务实例是否存在
        boolean taskStartFlag=scheduledFutureMap.containsKey(taskKey);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>当前任务实例是否存在{}",taskStartFlag);
        if (taskStartFlag){
            //获取任务实例
            ScheduledFuture scheduledFuture=scheduledFutureMap.get(taskKey);
            //关闭实例
            scheduledFuture.cancel(true);
        }
        log.info(">>>>>>>>>>>>>>>结束停止任务{}<<<<<<<<<<<",taskKey);
        return taskStartFlag;
    }

    /**
     * 根据任务key 重启任务
     * @param taskKey 任务Key
     * @return
     */
    @Override
    public Boolean restart(String taskKey) {
        log.info(">>>>>>>>>>>>>>>>>>>>进入重启任务{}<<<<<<<<<<<<<<<<<<<",taskKey);
        //先停止
        this.stop(taskKey);
        //再启动
        return this.start(taskKey);
    }

    /**
     * 程序启动时初始化==>启动所有正常状态的任务
     * @param scheduledTaskBeanList
     */
    @Override
    public void initAllTask(List<ScheduledTaskBean> scheduledTaskBeanList) {
        log.info("程序启动==>初始化所有任务开始！size={}",scheduledTaskBeanList.size());
        if (CollectionUtils.isEmpty(scheduledTaskBeanList)){
            return ;
        }
        for(ScheduledTaskBean scheduledTask:scheduledTaskBeanList){
            //任务Key
            String taskKey=scheduledTask.getTaskKey();
            //校验是否已经启动
            if (this.isStart(taskKey)){
                continue;
            }
            //启动任务
            this.doStartTask(scheduledTask);
            log.info("程序启动==>初始化所有任务结束！Size={}",scheduledTaskBeanList.size());
        }
    }

    /**
     * 执行启动任务
     */
    private void doStartTask(ScheduledTaskBean scheduledTask){
        //任务Key
        String taskKey=scheduledTask.getTaskKey();
        //定时表达式
        String taskCron=scheduledTask.getTaskCron();
        //获取需要定时调度的接口
        ScheduledTaskJob scheduledTaskJob=scheduledTaskJobMap.get(taskKey);
        log.info(">>>>>任务[{}],cron={}",scheduledTask.getTaskDesc(),taskCron);
        ScheduledFuture scheduledFuture=threadPoolTaskScheduler.schedule(scheduledTaskJob, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger cronTrigger=new CronTrigger(taskCron);
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        });
        //将启动的任务放入Map
        scheduledFutureMap.put(taskKey,scheduledFuture);
    }

    /**
     * 判断任务是否已经启动
     * @return
     */
    private Boolean isStart(String taskKey){
        //校验是否已经启动
        if (scheduledFutureMap.containsKey(taskKey)){
            if (!scheduledFutureMap.get(taskKey).isCancelled()){
                return true;
            }
        }
        return false;
    }
}
