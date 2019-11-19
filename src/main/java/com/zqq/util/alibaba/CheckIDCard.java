package com.zqq.util.alibaba;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 身份证实名核验
 * Title:CheckIDCard
 * Description:
 * @author zhangqiqi
 * @date 2019年11月18日
 */
public class CheckIDCard {

	public static void main(String[] args) throws IOException {
		String url = "https://eid.shumaidata.com/eid/check";
        String appCode = "120fb451bc7c45708942b0574b0a9237";

        Map<String, String> params = new HashMap<>();
        params.put("idcard", "412728199409073111");
        params.put("name", "张奇奇");
        String result = postForm(appCode, url, params);
        System.out.println(result);
	}
	/**
     * 用到的HTTP工具包：okhttp 3.13.1
     * <dependency>
     * <groupId>com.squareup.okhttp3</groupId>
     * <artifactId>okhttp</artifactId>
     * <version>3.13.1</version>
     * </dependency>
     */
    public static String postForm(String appCode, String url, Map<String, String> params) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();
        FormBody.Builder formbuilder = new FormBody.Builder();
        Iterator<String> it = params.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            formbuilder.add(key, params.get(key));
        }
        FormBody body = formbuilder.build();
        Request request = new Request.Builder().url(url).addHeader("Authorization", "APPCODE " + appCode).post(body).build();
        Response response = client.newCall(request).execute();
        System.out.println("返回状态码" + response.code() + ",message:" + response.message());
        String result = response.body().string();
        return result;
    }

}
