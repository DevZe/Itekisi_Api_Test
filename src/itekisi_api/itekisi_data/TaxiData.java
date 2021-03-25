package itekisi_api.itekisi_data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import itekisi_api.ApiClient;

import itekisi_models.Taxi;


import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;


public class  TaxiData {


     ApiClient apiClient;
     List<Taxi> taxis;
     ObjectMapper mapper ;
     static final String POSTURL = "https://localhost:44369/api/Taxis";
     static final String GETURL = "https://localhost:44369/api/Taxis";
    //the methods here should be tasks


    //this method gets a list of Taxis into taxiList
    public List<Taxi> getTaxiData(){
        apiClient = new ApiClient();
        mapper = new ObjectMapper();
        try {
            if (apiClient!=null | mapper!=null) {

                apiClient.getAsync(GETURL);
                taxis = mapper.readValue(apiClient.response.body(), new TypeReference<List<Taxi>>() {
                });
            }
        }catch (IOException | InterruptedException | NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return taxis;

    }

    //this method posts the Taxi
    public int postTaxiData(Map<String,String> taxi) throws IOException, NoSuchAlgorithmException, InterruptedException {
        apiClient = new ApiClient();
        return apiClient.postAsync(POSTURL, taxi);
    }


}
