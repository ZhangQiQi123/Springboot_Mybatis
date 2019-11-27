package com.zqq.common.event;

import com.zqq.model.ErrorInfo;
import com.zqq.model.GrayrouteInfo;
import org.springframework.context.ApplicationEvent;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 11:34
 * @Description: 业务属性event,主要应用于异步消息通知
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
public class BusinessEvent  extends ApplicationEvent {

    private ErrorInfo errorInfo;
    private GrayrouteInfo grayrouteInfo;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BusinessEvent(Object source,ErrorInfo errorInfo) {
        super(source);
        this.errorInfo=errorInfo;
    }

    public BusinessEvent(Object source,GrayrouteInfo grayrouteInfo) {
        super(source);
        this.grayrouteInfo=grayrouteInfo;
    }
    public ErrorInfo getErrorInfo(){
        return errorInfo;
    }
    public GrayrouteInfo getGrayrouteInfo(){
        return grayrouteInfo;
    }
}
