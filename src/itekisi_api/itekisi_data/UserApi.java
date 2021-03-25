package itekisi_api.itekisi_data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import itekisi_api.ApiClient;
import itekisi_models.Taxi;
import itekisi_models.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class UserApi {

    ApiClient apiClient;
    List<User> users;
    ObjectMapper mapper ;
    static final String POSTURL = "https://localhost:44369/api/Users";
    static final String GETURL = "https://localhost:44369/api/Users";
    String Body="";

    //this method gets a user
    public User getUserData(String username){
        apiClient = new ApiClient();
        mapper = new ObjectMapper();
        User user = new User();
        try {
            if (apiClient!=null | mapper!=null) {

                Body = apiClient.getAsync(GETURL);
                users = mapper.readValue(Body, new TypeReference<List<User>>() {
                });
                for (int i = 0;i < users.size();i++){
                    if (users.get(i).Username==username){
                        user =users.get(i);
                    }
                }
            }
        }catch (IOException | InterruptedException | NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return user;
    }

    //this method posts a new user
    public int postUserData(Map<String,String> user) throws IOException, NoSuchAlgorithmException, InterruptedException {
        apiClient = new ApiClient();
        return apiClient.postAsync(POSTURL, user);
    }
}
