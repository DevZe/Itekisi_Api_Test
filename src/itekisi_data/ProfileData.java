package itekisi_data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import itekisi_api.ApiClient;
import itekisi_models.Profile;
import itekisi_models.Taxi;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class ProfileData {

    ApiClient apiClient;
    List<Profile> profiles;
    ObjectMapper mapper ;
    static final String POSTURL = "https://localhost:44369/api/profile/RegisterProfile";
    static final String GETURL = "https://localhost:44369/api/profile/Profiles";

    //the methods here should be tasks


    //this method gets a list of Taxis into taxiList
    public List<Profile> getProfileData(){
        apiClient = new ApiClient();
        mapper = new ObjectMapper();
        try {
            if (apiClient!=null | mapper!=null) {

                apiClient.getAsync(GETURL);
                profiles = mapper.readValue(apiClient.response.body(), new TypeReference<List<Profile>>() {
                });
            }
        }catch (IOException | InterruptedException | NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return profiles;

    }

    //this method posts the Taxi
    public int postProfileData(Map<String,String> taxi) throws IOException, NoSuchAlgorithmException, InterruptedException {
        apiClient = new ApiClient();
        return apiClient.postAsync(POSTURL, taxi);
    }
}
