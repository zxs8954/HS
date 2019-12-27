package com.demo.APITest;

import com.demo.util.Util;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ResourceBundle;

public class Demo {
    private String host;
    private ResourceBundle bundle;
    Util util = new Util();


    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("API");
        this.host = bundle.getString("Host");
    }

    @Test
    public void getPoem() throws IOException {
        String result;
        HttpResponse response;
        String uri = bundle.getString("poem");
        String url = this.host + uri;
        HttpPost post = util.getPost(url);
        response = util.httpClient().execute(post);
        result = util.getResult(response);
        result = util.unicodeDecode(result);
        Reporter.log(result);
        System.out.println(result);
    }

    @Test
    public void getWeather() throws IOException {
        String result;
        HttpResponse response;
        String uri = bundle.getString("weather");
        String testUrl = host + uri;
        HttpPost post = util.getPost(testUrl);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("lacation","º¼ÖÝÊÐ");
        jsonObject.put("type","all");
        StringEntity entity=new StringEntity(jsonObject.toString(),"UTF-8");
        post.setEntity(entity);
        response=util.httpClient().execute(post);
        result=util.getResult(response);
        result=util.unicodeDecode(result);
        JSONObject jsonObject1=new JSONObject(result);
        Reporter.log(result);
        System.out.println(result);
        String aa=(String)jsonObject.get("method") ;
        System.out.println(jsonObject.get(aa));
    }
}
