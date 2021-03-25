package itekisi_api.itekisi_data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import itekisi_api.ApiClient;
import itekisi_models.Profile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class ProfileData {

    ApiClient apiClient;
    Profile prfl;
    ObjectMapper mapper ;
    static final String POSTURL = "https://localhost:44369/api/Profile/RegisterProfile";
    static final String GETURL = "https://localhost:44369/api/Profile/ProfileInfo";

    //the methods here should be tasks


    //this method gets a list of Taxis into
    public Profile registerProfile(Map<String,String> profile){
        apiClient = new ApiClient();
        mapper = new ObjectMapper();
        int statCode =0;
        try {
            if (apiClient!=null | mapper!=null) {

                statCode=apiClient.postAsync(POSTURL,profile);
                prfl = mapper.readValue(apiClient.response.body(), new TypeReference<Profile>() {
                }) ;
            }
        }catch (IOException | InterruptedException | NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return prfl;

    }

    //this method posts a new profile
    public int postProfileData(Map<String,String> profile) throws IOException, NoSuchAlgorithmException, InterruptedException {
        apiClient = new ApiClient();
        int staCode=0;
        if (apiClient!=null){
            staCode = apiClient.postAsync(POSTURL, profile);
        }
        return staCode;
    }
}
