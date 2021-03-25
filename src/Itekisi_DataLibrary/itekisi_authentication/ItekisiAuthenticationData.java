package Itekisi_DataLibrary.itekisi_authentication;

import itekisi_api.itekisi_data.ItekisiHttpClientAuthenticator;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

//This is a authentication data class
public class ItekisiAuthenticationData {

     ItekisiHttpClientAuthenticator authentication;
     static final String url = "https://localhost:44369/token";//URL of auth/token api


    public int responseCode;
    public String reponseBody;



    //this method gets the user and returns the status code

    public void getAuth(Map<String,String> data) throws IOException, InterruptedException, NoSuchAlgorithmException {
        reponseBody="";
        responseCode=0;
        if(authentication==null){
            authentication = new ItekisiHttpClientAuthenticator();
            reponseBody = authentication.dataAuthentication(url,data).body();
            responseCode = authentication.statusCode;
        }
    }
}
