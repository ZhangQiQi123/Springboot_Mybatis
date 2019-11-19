package com.zqq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/25 9:47
 * @Description: com.zqq.model
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Entity
public class ScheduledTaskBean {

    @Id
    @Column(name="id")
    private int id;//id
    @Column(name = "task_key")
    @GeneratedValue(generator="UUID")
    private String taskKey;//任务key值 唯一
    @Column(name = "task_desc")
    private String taskDesc;//任务描述
    @Column(name = "task_cron")
    private String taskCron;//任务表达式
    @Column(name = "int_start_flag")
    private Integer initStartFlag;// 程序初始化是否启动 1 是 0 否

    private boolean startFlag;//当前是否已启动


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskCron() {
        return taskCron;
    }

    public void setTaskCron(String taskCron) {
        this.taskCron = taskCron;
    }

    public Integer getInitStartFlag() {
        return initStartFlag;
    }

    public void setInitStartFlag(Integer initStartFlag) {
        this.initStartFlag = initStartFlag;
    }

    public boolean isStartFlag() {
        return startFlag;
    }

    public void setStartFlag(boolean startFlag) {
        this.startFlag = startFlag;
    }
}
