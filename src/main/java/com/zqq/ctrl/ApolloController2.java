package com.zqq.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/2 20:23
 * @Description: com.zqq.ctrl
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@RestController
@RequestMapping("/apollo")
public class ApolloController2 {
    @Value("${server.port}")
    private String serverPort;

    @Value("${dev.name}")
    private String name;

    @Value("${spring.datasource.url}")
    private String dbUrl;

//    @Value("${server.servlet-path}")
//    private String serviceName;

    @GetMapping("/getServerPort")
    public String getServerPort(){
        return serverPort;
    }
    @GetMapping("/getDevName")
    public String getDevName(){
        return name;
    }
    @GetMapping("/getdbUrl")
    public String getDbUrl(){
        return dbUrl;
    }
//    @GetMapping("/getServiceName")
//    public String getServiceName(){
//        return serviceName;
//    }

}
