package itekisi_authentication;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class ItekisiAuthenticationData {

     HttpRequest httpRequest;
     ItekisiHttpClientAuthenticator authentication;
     static final String url = "https://localhost:44369/token";

    public int getAuth(Map<String,String> data) throws IOException, InterruptedException, NoSuchAlgorithmException {


        int statusCode=0;
        if(authentication==null){
            authentication = new ItekisiHttpClientAuthenticator();
            statusCode = authentication.dataAuthentication(url,data);
        }
        return statusCode;
    }
}
