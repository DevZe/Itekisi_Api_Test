package Itekisi_DataLibrary.UserData;

import itekisi_api.itekisi_data.ProfileData;
import itekisi_api.itekisi_data.UserApi;
import itekisi_models.Profile;
import itekisi_models.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class UserProfileData {

    static final String GETURL = "https://localhost:44369/api/Users";
    int statusCode;
    Map<String,String> profile;
    Profile profileModel;
    ProfileData profileData;
    UserApi userApi;
    String userId;



    void setUserId(String userId) {
        this.userId = userId;
    }

    public int getStatusCode() {
        return statusCode;
    }

   /* public String getUserId(){
        userApi = new UserApi();
        userId  = userApi.getUserData().Id;
        return userId;
    }*/

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getProfile() {
        return profile;
    }

    public void setProfile(Map<String, String> Profile) {
        profile = Profile;
    }

   /* public Profile getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(Profile profileModel) {
        this.profileModel = profileModel;
    }
*/

    public User getUser(String user) throws InterruptedException, NoSuchAlgorithmException, IOException {
        userApi = new UserApi();
        User usr = new User();
        if (userApi!=null) {
            usr = userApi.getUserData(user);
        }
        return usr;
    }

    public Profile createProfile(Map<String,String> prl){
        profileData = new ProfileData();
        if (profileData!=null){

            profileModel = profileData.registerProfile(prl);
        }
        return profileModel;
    }

    /*public int createNewProfile(Map<String,String> profl) throws InterruptedException, NoSuchAlgorithmException, IOException {
        profileData = new ProfileData();
        if (profileData!=null) {
            if(profileData.postProfileData(profl)!=200){
                System.out.println("User's profile not found!");
                return 0;
            }
               *//* if(profileData.postProfileData(profile)==200){
                    System.out.println("New User in");
                }*//*
        }
        return 200;
    }*/

}
