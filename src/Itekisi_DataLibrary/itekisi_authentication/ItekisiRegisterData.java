package Itekisi_DataLibrary.itekisi_authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import itekisi_api.itekisi_data.ItekisiRegister;
import itekisi_api.itekisi_data.UserApi;
import itekisi_models.Taxi;
import itekisi_models.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class ItekisiRegisterData {

    ItekisiRegister registerApiClient;
    UserApi userApi;
    static final String POSTURL = "https://localhost:44369/api/Account/Register";
    static final String POSTURL2 = "https://localhost:44369/api/Users";
    //the methods here resemble tasks
    public int statC = 0;

    //this methods registers a new user to the api
    public int registerUser(Map<String,String> data) throws IOException, NoSuchAlgorithmException, InterruptedException {

        registerApiClient = new ItekisiRegister();
        userApi = new UserApi();
        int FinalStatCode= 0;
        int statCode = registerApiClient.Register(POSTURL, data);
        if(statCode<404){
            FinalStatCode=200;
        }
        return FinalStatCode;
    }

    public User getUserId(String username){
        userApi = new UserApi();
        User user=new User();
        if (userApi!=null){
            user = userApi.getUserData(username);
        }
       return user;
    }

   public int postUser(Map<String,String> data) throws InterruptedException, NoSuchAlgorithmException, IOException {
        //registerApiClient = new ItekisiRegister();
         int b =  0;
        if (registerApiClient!=null){
            b = registerApiClient.Register(POSTURL2,data);
        }
        return b;
    }

}
