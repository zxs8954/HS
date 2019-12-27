package com.demo.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Util {
    public HttpClient httpClient(){
        DefaultHttpClient client=new DefaultHttpClient();
        return client;
    }
    public HttpPost getPost(String url){
        HttpPost post=new HttpPost(url);
        return post;
    }
    public String getResult(HttpResponse response) throws IOException {
        String result;
        result=EntityUtils.toString(response.getEntity());
        return result;
    }
}
