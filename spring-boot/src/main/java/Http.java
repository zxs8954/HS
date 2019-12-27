import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.Closeable;

public class Http {
    public static void main(String[] args) {
        String url="http://127.0.0.1:8888/get/with/cookie";
        CloseableHttpClient client= HttpClients.createDefault();
        HttpGet get=new HttpGet(url);
        client.

    }
}
