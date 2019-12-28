package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);//默认识别resources文件夹中后缀为.properties文件
        url=bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("getCookies.uri");
        String testUrl=url+uri;
        System.out.println(testUrl);
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        store=client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();
        for(Cookie cookie:cookieList){
            String name =cookie.getName();
            String value= cookie.getValue();
            System.out.println("Cookie name="+name);
            System.out.println("Cookie value="+value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String result;
        String uri=bundle.getString("getWithCookies");
        HttpGet get=new HttpGet(url+uri);
        DefaultHttpClient client=new DefaultHttpClient();
        client.setCookieStore(store);//设置cookies信息
        HttpResponse response=client.execute(get);
        int statusCode=response.getStatusLine().getStatusCode();//获取响应状态码
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }
}
