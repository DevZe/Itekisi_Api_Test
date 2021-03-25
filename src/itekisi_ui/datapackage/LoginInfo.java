package itekisi_ui.datapackage;

import Itekisi_DataLibrary.itekisi_authentication.ItekisiAuthenticationData;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LoginInfo {

    Map<String, String> user;
    String Username, Password;

    public boolean iscLog() {
        return cLog;
    }

    boolean cLog;

    public Map<String, String> getUser() {
        return user;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }


    //this method checks if the credentials are empty
    public boolean canLoggin(String username, String password) {
        Username = username;
        Password = password;
        if (username != null || password != null) {
            cLog = true;
        }
        return cLog;
    }

    //this method is for logging in, it returns 1 or 0
    public int login() throws InterruptedException, NoSuchAlgorithmException, IOException {
        user = new HashMap<>();
        user.put("username", Username);
        user.put("password", Password);
        user.put("grant_type", "password");//grant Type
        int a = 0;
        ItekisiAuthenticationData itekisiAuthenticationData = new ItekisiAuthenticationData();
        if (itekisiAuthenticationData != null) {
            itekisiAuthenticationData.getAuth(user);
            int grant_Code = itekisiAuthenticationData.responseCode;

            if (grant_Code == 200) {
                a = 1;
            } else {
                a = 0;
            }
        }
        return  a;
    }


}