package httpclient.reCookies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo {
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("url");
    }
    @Test
    public void get(){

    }
}
