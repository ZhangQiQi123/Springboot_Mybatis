package com.zqq.util;

import org.json.JSONObject;
import org.json.XML;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/19 15:13
 * @Description: com.zqq.test
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
public class JSONUtils {

    /**
     * JSON 转化为 XML
     * @param json
     * @return
     *//*
    public static String JsonToXml(String json){

        JSONObject jsonObject = new JSONObject(json);
        return XML.toString(jsonObject) ;
    }

    *//**
     * XML 转化为 JSON
     * @param xml
     * @return
     *//*
    public static String XmlToJson(String xml){

        JSONObject jsonObject = XML.toJSONObject(xml);
        return jsonObject.toString();
    }

    *//**
     * Map 转化为 JSON
     * @param map
     * @return
     *//*
    public static String MapToJson(Map map){

        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }

    *//**
     * JSON 转化为 Map
     * @param json
     * @return
     *//*
    public static Map JsonToMap(String json){

        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.toMap();
    }

    *//**
     * Bean对象 转化为 JSON
     * @param object
     * @return
     *//*
    public static String BeanToJson(Object object){

        JSONObject jsonObject = new JSONObject(object);
        return jsonObject.toString();
    }

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("userName","张三");
        map.put("sex","男");
        map.put("age",25);
        map.put("createDate",new Date());

        String json = MapToJson(map);
        System.out.println(json);

        Map map1 = JsonToMap(json);
        System.out.println(map1);

        String xml = JsonToXml(json);
        System.out.println(xml);

        String json1 = XmlToJson(xml);
        System.out.println(json1);

        // bean to json
        UserInfo userInfo=new UserInfo(001,"张三",25,"男",new Date());
        String json2 = BeanToJson(userInfo);
        System.out.println(json2);
    }*/
}
