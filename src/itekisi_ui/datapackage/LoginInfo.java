package itekisi_ui.datapackage;

import itekisi_authentication.ItekisiAuthenticationData;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LoginInfo {

    Map<String,String> user;


    //this method checks if the user can login
    public boolean canLoggin(String username,String password){

        if(username!=null || password!=null){
            return true;
        }
        return false;
    }
    //   |  |

    //this is the login method that the ui calls
    public int login(String username,String password) throws InterruptedException, NoSuchAlgorithmException, IOException {
        user = new HashMap<>();
        user.put("username",username);
        user.put("password",password);
        user.put("grant_type","password");

        ItekisiAuthenticationData itekisiAuthenticationData = new ItekisiAuthenticationData();
        return itekisiAuthenticationData.getAuth(user);
    }


}
