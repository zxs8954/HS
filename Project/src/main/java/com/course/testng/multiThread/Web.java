package com.course.testng.multiThread;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.nio.charset.Charset;

public class Web {
    @Test(invocationCount = 1,threadPoolSize = 1)
    public void openChrome(){
        ChromeDriver chrome = new ChromeDriver();
        chrome.get("http://wwwtest.hzdtv.tv:8080/tvportal/media3_test/media3_test.jsp");
        chrome.findElementByXPath("/html/body/table/tbody/tr[13]/td[6]/strong/a").click();
        chrome.findElementByXPath("/html/body/table/tbody/tr[1]/td[5]/strong/a").click();
        String js = "var oTxt = document.getElementById('nav5_2').focus()";
        chrome.executeScript(js);
        System.out.println(Thread.currentThread().getId());

    }
//    @Test(invocationCount = 100000,threadPoolSize = 3000)
//    public void function() throws IOException {
//        String result;
//        String url = "http://127.0.0.1:8888/getwithparam?name=huhansan&sex=20";
//        HttpGet get = new HttpGet(url);
//        HttpClient client =new DefaultHttpClient();
//        HttpResponse response = client.execute(get);
//        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println(result+Thread.currentThread().getId());
//        }
    }

