package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        String result;//存放请求结果
        HttpGet get=new HttpGet("http://www.baidu.com");//定义get方法
        HttpClient client=new DefaultHttpClient();//定义客户端（模拟浏览器）
        HttpResponse response=client.execute(get);//用客户端发送请求
        result= EntityUtils.toString(response.getEntity(),"utf-8");//解析响应内容
        System.out.println(result);
    }
}
