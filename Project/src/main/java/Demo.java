import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.BeforeTest;
import org.apache.http.client.HttpClient;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class  Demo{
    public static void main(String[] args) {

    }
    @BeforeTest
    public void function() throws IOException {
        ResourceBundle bundle;
        bundle = ResourceBundle.getBundle("APIAddress", Locale.CHINA);
        String url="http://www.baidu.com" ;
      //  url=bundle.getString("test.url");
        HttpGet get =new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        System.out.println(response.getStatusLine().getStatusCode());
    }
}