package itekisi_authentication;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.Executors;

public class ItekisiHttpClientAuthenticator {


    HttpRequest  request;
    HttpClient client;
    HttpResponse<String> response;


//this method gets
    public int dataAuthentication(String url,Map<String,String> data) throws NoSuchAlgorithmException, IOException, InterruptedException {
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
                .setHeader("content-Type","application/json")
                .setHeader("client_id","Itekisi_Api_Test")
                .build();

        response = client.send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());


        return response.statusCode();
    }

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
