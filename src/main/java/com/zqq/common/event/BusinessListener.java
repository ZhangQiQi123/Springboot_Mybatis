package com.zqq.common.event;

import com.zqq.model.ErrorInfo;
import com.zqq.model.GrayrouteInfo;
import com.zqq.service.ErrorInfoService;
import com.zqq.service.GrayrouteInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 11:47
 * @Description: 业务监听类
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Component
@Slf4j
public class BusinessListener implements ApplicationListener<BusinessEvent> {
    @Resource(name="errorInfoService")
    private ErrorInfoService errorInfoService;
    @Resource(name="grayrouteInfoService")
    private GrayrouteInfoService grayrouteInfoService;

    @Override
    public void onApplicationEvent(BusinessEvent event) {
        try{
            ErrorInfo errorInfo=event.getErrorInfo();
            if (null != errorInfo){
                errorInfoService.insert(errorInfo);
                return;
            }
            GrayrouteInfo grayrouteInfo=event.getGrayrouteInfo();
            if (null != grayrouteInfo){
                grayrouteInfoService.insert(grayrouteInfo);
            }
        }catch (Exception e){
            log.error("event insert error |",e);
        }

    }
}
