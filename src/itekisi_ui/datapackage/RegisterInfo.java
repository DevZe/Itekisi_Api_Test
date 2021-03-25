package itekisi_ui.datapackage;


import Itekisi_DataLibrary.itekisi_authentication.ItekisiRegisterData;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class RegisterInfo {

    Map<String,String> newUser;

    public String getUsername() {
        return Username;
    }

    String Username;
    String Password;

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    String ConfirmPassword;
    ItekisiRegisterData itekisiRegister;
    //this methods sets the newUser and returns 0 or 1
    public int signUpNewUser(String username,String password) throws InterruptedException, NoSuchAlgorithmException, IOException {
        /*this.Username = username;
        this.Password = password;*/
        newUser = new HashMap<>();

        newUser.put("email", username);
        newUser.put("password", password);
        newUser.put("confirmPassword",password);
        int a = 0;
        itekisiRegister = new ItekisiRegisterData();
        if (itekisiRegister != null) {

            int grant_Code = itekisiRegister.registerUser(newUser);
            if ((grant_Code < 404 )) {
                a = 1;
            } else {
                a = 2;
            }
        }
        return a;
    }



    public int createUserId(String username) throws InterruptedException, NoSuchAlgorithmException, IOException {

        newUser = new HashMap<>();
        newUser.put("Id",itekisiRegister.getUserId(username).Id);
        newUser.put("Username", username);
        newUser.put("password", Password);
        int a = 0;
        itekisiRegister = new ItekisiRegisterData();
        if (itekisiRegister != null) {

            int grant_Code = itekisiRegister.postUser(newUser);
            if ((grant_Code < 404 )) {
                a = 1;
            } else {
                a = 2;
            }
        }
        return a;
    }
}
