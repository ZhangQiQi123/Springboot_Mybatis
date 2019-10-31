package com.zqq.common.apollo;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/31 9:35
 * @Description: com.zqq.common.apollo 配置刷新监控
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Component
@Slf4j
public class ApolloConfigRefresh {

    @Resource
    private DevConfig devConfig;

    @Resource
    private RefreshScope refreshScope;

    //监听哪个命名空间
    @ApolloConfigChangeListener(value = "namespace1")
    public void autoChange(ConfigChangeEvent changeEvent){
        boolean configChange=false;
        for (String cKey : changeEvent.changedKeys()){
            if (cKey.startsWith("dev")){
                configChange=true;
                break;
            }
        }
        if (!configChange){
            return;
        }
        refreshScope.refresh("devConfig");
    }
}
