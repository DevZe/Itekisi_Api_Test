import itekisi_ui.AuthUI;
import itekisi_ui.FillUp;
import itekisi_ui.frames.AuthenticationFrame;
import itekisi_ui.frames.FillUpFrame;
import itekisi_ui.frames.Master;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {



    public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException {

/******************************/
//ApiClient EndPoints
/******************************/


        //A get API call
        /*List<Taxi> taxis ;
        TaxiData taxiData = new TaxiData();
        if(taxiData==null) {
          taxis  = taxiData.getTaxiData();
            for (int i = 0; i < taxis.size(); i++) {
                System.out.println("Taxi  " + i + " : " + taxis.get(i).toString());
            }
        }

        taxis = taxiData.getTaxiData();
        for (int i = 0; i < taxis.size(); i++) {
            System.out.println("Taxi" + i + " :" + taxis.get(i).Location.toString());
        }*/


      /*  //A post API call
        Map<Object,Object> taxi = new HashMap<>();
        TaxiData taxiData = new TaxiData();

        taxi.put("From","The Glen");
        taxi.put("To","Jozi");
        taxi.put("Location","Turfontein");
        taxi.put("Price","12.50");


        System.out.println("Status code:  " + taxiData.postTaxiData(taxi));
*/

        //Login
       /* String username = "dawgen@mail.com";
        String password = "Dawgen@123";


        Map<String,String> user = new HashMap<>();
        TaxiData taxiData = new TaxiData();

        user.put("username",username);
        user.put("password",password);
        user.put("grant_type","password");

        ItekisiAuthenticationData itekisiAuthenticationData = new ItekisiAuthenticationData();

        System.out.println("Status Code: " + itekisiAuthenticationData.getAuth(user));*/

/*

        //Api Register
        String email = "dawgen@mail.com";
        String password = "Dawgen@123";
        String confirmPassword = "Dawgen@123";


        Map<String,String> user = new HashMap<>();
        ItekisiRegisterData itekisiRegisterData = new ItekisiRegisterData();

        user.put("email",email);
        user.put("password",password);
        user.put("ConfirmPassword",confirmPassword);


        System.out.println("Status Code: " + itekisiRegisterData.registerUser(user));

*/

        //this method post a new profile OR is the fillup call
        /*String UserId = "w820934ujkljk239&*&*(86vghj";
        String Name="Sikhokho";
        String Surname="TheMan";
        String IdNumber="45641605345";
        String Address="45 Toll Road Silverton Belvister";
        String Gender="Male";
        String AccessId="0";


        Map<String,String> profile = new HashMap<>();
        ProfileData itekisiRegisterData = new ProfileData();

        profile.put("userid",UserId);
        profile.put("name",Name);
        profile.put("surname",Surname);
        profile.put("idnumber",IdNumber);
        profile.put("address",Address);
        profile.put("gender",Gender);
        profile.put("accessid",AccessId);

        System.out.println("Status Code: " + itekisiRegisterData.postProfileData(profile));*/


        //Get a list of profiles
       /* List<Profile> profiles ;
        ProfileData profileData = new ProfileData();

        profiles = profileData.getProfileData();
        for (int i = 0; i < profiles.size(); i++) {
            System.out.println("Profile :  " + i + " : " + profiles.get(i).getSurname().toString());
        }*/
/**************************************************************************************************************/
//THE UI TEST
/***********************************************/
        //Login Frame

       /* Login login = new Login();
        login.logginIn();*/


        //Sign Up Frame
        /*SignUp signUp = new SignUp();
        signUp.SigningUp();*/

        //FillUp Frame
        /*FillUp fillUp = new FillUp();
        fillUp.FillingUp();*/


        //Using JPanels to navigate

       /* EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AuthenticationFrame frame = new AuthenticationFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });*/

        /*Master master = new Master();
        JFrame frame = new JFrame();
        frame.setJMenuBar(master.menuBar);
        frame.setTitle("Master");
        frame.setVisible(true);
        frame.setBounds(500, 50, 500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);*/

       /*FillUp fillUp =new FillUp();
       fillUp.FillingUp();*/

      new AuthUI();

    }
}
