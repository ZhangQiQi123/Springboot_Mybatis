package com.zqq.common.apollo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/30 16:06
 * @Description: com.zqq.common.apollo -----------------------------------2.注入Bean 的方式获取Key
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "dev")
@RefreshScope
public class DevConfig {

    private String mobile;

    private String name;

    private String namespaceemail;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespaceemail() {
        return namespaceemail;
    }

    public void setNamespaceemail(String namespaceemail) {
        this.namespaceemail = namespaceemail;
    }
}
