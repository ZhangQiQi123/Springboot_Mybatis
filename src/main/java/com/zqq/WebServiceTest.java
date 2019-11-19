package com.zqq;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/15 11:06
 * @Description: com.zqq
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Slf4j
public class WebServiceTest {
    public static void main(String[] args) {
        JaxWsDynamicClientFactory clientFactory=JaxWsDynamicClientFactory.newInstance();
        String aaa="";

        Client client=clientFactory.createClient("http://localhost:9999/WS_Server/web-service/?wsdl");
        Object[] result=null;
        try {
            //如果有命名空间的话
            QName operationName = new QName("http://impl.service/","sayHello"); //如果有命名空间需要加上这个，第一个参数为命名空间名称，第二个参数为WebService方法名称
//            result = client.invoke(operationName,"张奇奇");//后面为WebService请求参数数组
            //如果没有命名空间的话
            result = client.invoke("sayHello", "张奇奇"); //注意第一个参数是字符串类型，表示WebService方法名称，第二个参数为请求参数
        } catch (Exception e) {
            String errMsg = "WebService发生异常！";
            result = new Object[] { errMsg };
            log.error(errMsg, e);
        }
    }
}
