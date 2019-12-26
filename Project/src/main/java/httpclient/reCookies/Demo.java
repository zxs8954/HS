package httpclient.reCookies;

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
import java.util.List;
import java.util.ResourceBundle;

public class Demo {
    private CookieStore store;
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application");
        this.url = bundle.getString("url");
    }

    @Test
    public void getCookies() throws IOException {
        String uri = bundle.getString("getCookies");
        String testUrl = this.url + uri;
        String result;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name + "--" + value);
        }
        System.out.println("----------");
        System.out.println("-----1----");
        System.out.println("----------");
    }

    @Test(dependsOnMethods = {"getCookies"})
    public void getWithCookies() throws IOException {
        String uri = bundle.getString("getWithCookiesUri");
        String result;
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        System.out.println("----------");
        System.out.println("-----2----");
        System.out.println("----------");
    }
    @Test(dependsOnMethods = {"getCookies"})
    public void postWithCookies() throws IOException {
        String result;
        String uri=bundle.getString("postUri");
        String testUrl=this.url+uri;
        HttpPost post=new HttpPost(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        client.setCookieStore(this.store);
        post.setHeader("content-type","application/json");
        JSONObject param=new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        StringEntity entity=new StringEntity(param.toString());
        post.setEntity(entity);
        HttpResponse response=client.execute(post);
        result=EntityUtils.toString(response.getEntity());
        System.out.println(result);
        JSONObject resultJSON=new JSONObject(result);
        String name=(String) resultJSON.get("name");
        String age=(String) resultJSON.get("age");
        Assert.assertEquals("胡汉三",name);
        Assert.assertEquals("十二岁",age);















        System.out.println(testUrl);
    }
}