package itekisi_signup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import itekisi_api.ApiClient;
import itekisi_models.Taxi;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class ItekisiRegisterData {

    ItekisiRegister registerApiClient;
    List<Taxi> taxis;
    ObjectMapper mapper ;

    static final String POSTURL = "https://localhost:44369/api/Account/Register";
    //the methods here should be tasks


    //this method gets a list of Taxis into taxiList


    //this method posts the Taxi
    public int registerUser(Map<String,String> taxi) throws IOException, NoSuchAlgorithmException, InterruptedException {
        registerApiClient = new ItekisiRegister();
        return registerApiClient.Register(POSTURL, taxi);
    }


}
