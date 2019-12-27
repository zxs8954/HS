package com.demo.APITest;

import com.demo.util.Util;
import com.demo.util.Util.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
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
        response =util.httpClient().execute(post);
        result=util.getResult(response);
        System.out.println(result);
    }
}
