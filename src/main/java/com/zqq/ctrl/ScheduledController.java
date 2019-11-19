package com.zqq.ctrl;

import com.zqq.model.ScheduledTaskBean;
import com.zqq.service.ScheduledTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/28 15:55
 * @Description: com.zqq.ctrl
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@RestController
@RequestMapping("/scheduled")
public class ScheduledController {
    @Autowired
    private ScheduledTaskService scheduledTaskService;

    /**
     * 所有任务列表
     * @return
     */
    @RequestMapping("/taskList")
    public List<ScheduledTaskBean> taskBeanList(){
        return scheduledTaskService.taskList();
    }

    /**
     * 根据任务Key=>启动任务
     * @return
     */
    @RequestMapping("/start")
    public String start(@RequestParam("taskKey") String taskKey){
        scheduledTaskService.start(taskKey);
        return "start success";
    }

    /**
     * 根据任务key=>停止任务
     * @return
     */
    @RequestMapping("/stop")
    public String stop(@RequestParam("taskKey") String taskKey){
        scheduledTaskService.stop(taskKey);
        return "stop success";
    }

    /**
     * 根据任务Key=>重启任务
     * @return
     */
    @RequestMapping("/restart")
    public String restart(@RequestParam("taskKey") String taskKey){
        scheduledTaskService.restart(taskKey);
        return "restart success";
    }
}
