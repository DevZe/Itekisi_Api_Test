package itekisi_api.itekisi_data;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.Executors;

public class ItekisiRegister {

     static HttpClient client = null;
     HttpRequest request ;
     HttpResponse<String> response;

    //this method posts a new user

    public int Register(String url, Map<String,String> data) throws NoSuchAlgorithmException, IOException, InterruptedException {

        //setup a client set a new builder and httpclient parameters
        client = HttpClient
                .newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .executor(Executors.newFixedThreadPool(3))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .priority(2)
                .proxy(ProxySelector.getDefault())
                .sslContext(SSLContext.getDefault())
                .version(HttpClient.Version.HTTP_2)
                .sslParameters(new SSLParameters())
                .build();

        request = HttpRequest.newBuilder()
                .POST(ofFormData(data))
                .uri(URI.create(String.format(url)))
                .header("content-Type","application/x-www-form-urlencoded")
                .setHeader("User-Agent","Itekisi_Api_Test")
                .build();

        response = client.send(request,HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.statusCode());

        return response.statusCode();
    }

    //this is the method that forms our data to string
    public HttpRequest.BodyPublisher ofFormData(Map<String,String> data){
        StringBuilder builder =new StringBuilder();
        for(Map.Entry<String,String> entry: data.entrySet()){
            if (builder.length() > 0){
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString()));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
}
