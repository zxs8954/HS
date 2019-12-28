package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("getCookies.uri");
        HttpGet get=new HttpGet(url+uri);
        System.out.println(url+uri);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        store=client.getCookieStore();
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        //声明对象存储结果
        String result;
        String uri=bundle.getString("postWithCookies");
        DefaultHttpClient client=new DefaultHttpClient();//声明client对象
        HttpPost post=new HttpPost(url+uri);//声明请求方法
        client.setCookieStore(store);//设置cookies信息
        post.setHeader("content-type","application/json");//设置请求头信息
        //添加参数
        JSONObject param=new JSONObject();
        param.put("name","zhangsan");
        param.put("age","12");
        //将信息添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        HttpResponse response=client.execute(post);//执行请求
        //获取响应结果
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果
        JSONObject resultJosn=new JSONObject(result);
        String success=(String) resultJosn.get("zhangsan");
        String name=(String) resultJosn.get("name");
        String status=(String)resultJosn.get("status");
        //断言
        Assert.assertEquals(success,"success");
        Assert.assertEquals(name,"zhangsan");
        Assert.assertEquals(status,"1");








    }
}
