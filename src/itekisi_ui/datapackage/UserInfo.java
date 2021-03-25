package itekisi_ui.datapackage;

import Itekisi_DataLibrary.UserData.UserProfileData;
import itekisi_api.itekisi_data.ItekisiHttpClientAuthenticator;
import itekisi_api.itekisi_data.ProfileData;
import itekisi_models.Profile;
import itekisi_models.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class UserInfo {
    Profile profile;
    UserProfileData userProfileData;


    public String getUserId(String username) throws InterruptedException, NoSuchAlgorithmException, IOException {
        userProfileData = new UserProfileData();
        String id = "";
        if (userProfileData!=null){
            id=userProfileData.getUser(username).Id;
        }
      return id;
    }

    public Profile addMe(Map<String,String> me) throws InterruptedException, NoSuchAlgorithmException, IOException {
        userProfileData = new UserProfileData();
        profile = new Profile();
        if (userProfileData!=null) {
            profile = userProfileData.createProfile(me);
        }
        return profile;
    }

   /* public String getMyId(String id){
       return userProfileData.getUserId();
    }*/

}
