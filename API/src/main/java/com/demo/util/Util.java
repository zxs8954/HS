package com.demo.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        return result;
    }
    // 处理unicode 转中文工具类，直接粘贴就好
    public String unicodeDecode(String string) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(string);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            string = string.replace(matcher.group(1), ch + "");
        }
        return string;
    }
}
