package com.zqq.util;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/19 15:20
 * @Description: com.zqq.test
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
public class JSONUtils2 {
    public static String BeanToJson(Object object){

        String json = JSON.toJSONString(object);
        return json;
    }

    public static <T>T JsonToBean(String json,Class<T> clazz){

        return JSON.parseObject(json,clazz);
    }

    public static void main(String[] args) {

        UserInfo userInfo=new UserInfo(001,"张三",25,"男",new Date());
        String json = BeanToJson(userInfo);
        System.out.println(json);
        UserInfo userInfo1 = JsonToBean(json,UserInfo.class);
        System.out.println(userInfo1);
    }

}
