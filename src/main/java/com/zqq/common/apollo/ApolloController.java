package com.zqq.common.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/10/30 14:05
 * @Description: com.zqq.ctrl
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@RestController
//默认获取application(如果有namespace，要传入)
@EnableApolloConfig("namespace1")
public class ApolloController {
    //---------------------------------1.配置中心直接注入到属性
    @Value("${dev.namespace.email}")
    private String key;



    @Resource
    private DevConfig devConfig;

    @RequestMapping("/apollo")
    public String apollo(){
        return "Value:"+devConfig.getNamespaceemail()+", Bean:"+devConfig.getMobile()+", name:"+devConfig.getName();
    }
}
