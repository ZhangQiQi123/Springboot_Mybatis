package com.zqq.common.apollo;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/30 14:28
 * @Description: com.zqq.common.apollo
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Component
@Slf4j
public class ApolloListen {

    //监听application命名空间
    @ApolloConfigChangeListener(value = {"namespace1"})
    private void anotherOnChange(ConfigChangeEvent changeEvent){
        String nameSpace=changeEvent.getNamespace();
        Set<String> changeKeys=changeEvent.changedKeys();
        changeKeys.forEach(key -> {
            ConfigChange change=changeEvent.getChange(key);
            log.info(String.format("Found change - Key: %s, oldValue: %s, "+" newValue: %s, changeType: %s",change.getPropertyName(),change.getOldValue(),change.getNewValue(),change.getChangeType()));
        });
    }
}
