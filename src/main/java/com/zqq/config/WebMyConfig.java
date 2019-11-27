package com.zqq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 15:28
 * @Description: 默认首页跳转
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Configuration
public class WebMyConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

}
