package itekisi_ui.frames;

import itekisi_models.User;
import itekisi_ui.FillUp;
import itekisi_ui.datapackage.LoginInfo;
import itekisi_ui.datapackage.RegisterInfo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationFrame extends JFrame implements ActionListener, ItemListener {

    //local variables
    JPanel LoginContainer;
    JPanel RegisterContainer;

    //login variables
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");

    JTextField userTextfield = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton loginButton = new JButton("Login");
    JButton SignUpBtn = new JButton("Register");

    JCheckBox showRPassword = new JCheckBox("Show Password");
    JCheckBox showLPassword = new JCheckBox("Show Password");

    final CardLayout cl = new CardLayout();
    final JPanel cards = new JPanel(cl);
    final Border border = BorderFactory.createEmptyBorder(100,200,100,200);
    JPanel contentPane,loginPanel,signUpPanel;

    //signup variables
    JLabel emailLabel = new JLabel("Email");
    JLabel passwordlbl = new JLabel("Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    JLabel emptyLCell = new JLabel("");
    JLabel emptyRCell = new JLabel("");

    JTextField emailTextfield = new JTextField();
    JPasswordField passwordFld = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();

    JButton SignUpButton = new JButton("SignUp");
    JButton loginBtn = new JButton("SignIn");

    JButton loginPanelButton = new JButton("Login Page");
    JButton registerPanelButton = new JButton("SignUp Page");

    RegisterInfo registerInfo;
    LoginInfo loginInfo;

    User user;


    public AuthenticationFrame(){
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(90,200,90,200));

        setContentPane(contentPane);

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();

        cl.show( cards,"Login Panel");

    }

    //Setting Container's LayoutManager and adding button actionListener
    public void setLayoutManager(){

        LoginContainer = new JPanel();

        LoginContainer.setLayout(new GridLayout(5,2));//rows and
        RegisterContainer = new JPanel(new GridLayout(5,2));

        LoginContainer.setVisible(true);

        LoginContainer.setSize(getMaximumSize().width,getMaximumSize().height);

        LoginContainer.setBorder(border);
        RegisterContainer.setBorder(border);
        loginPanel = new JPanel();
        signUpPanel = new JPanel();

        loginPanel.setVisible(true);
        signUpPanel.setVisible(true);

        //login container
        loginPanel.setSize(getMaximumSize().width,getMaximumSize().height);
        loginPanel.setBorder(border);
        loginPanel.setBackground(Color.LIGHT_GRAY);

        loginPanel.add(new JLabel("Login Here"));
        loginPanel.add(LoginContainer);
        cards.add(loginPanel,"Login Panel",0);

        //signup container
        signUpPanel.setBorder(border);
        signUpPanel.setBackground(Color.LIGHT_GRAY);

        signUpPanel.add(new JLabel("Sign Up"));
        signUpPanel.add(RegisterContainer);
        cards.add(signUpPanel,"SignUp Panel",1);

        //main or control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.LIGHT_GRAY);
        /*
        controlPanel.add(loginPanelButton);
        controlPanel.add(registerPanelButton);
*/

        contentPane.add(cards);
        contentPane.add(controlPanel);


        loginPanelButton.addActionListener(this::actionPerformed);

        //registerPanelButton.addActionListener(this::actionPerformed);
        loginButton.addActionListener(this::actionPerformed);
        SignUpBtn.addActionListener(this::actionPerformed);
        loginBtn.addActionListener(this::actionPerformed);
        SignUpButton.addActionListener(this::actionPerformed);
        showLPassword.addItemListener(this::itemStateChanged);
        showRPassword.addItemListener(this::itemStateChanged);
        //SignUpButton.addActionListener(new LoginActionListener());

    }

    //Setting location and Size of each components using setBounds() methods
    public  void setLocationAndSize(){



        //Login
        userLabel.setBounds(50,150,100,30);
        passwordlbl.setBounds(50,220,100,30);
        userTextfield.setBounds(150,150,150,30);
        passwordFld.setBounds(150,220,150,30);
        showRPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        SignUpBtn.setBounds(200,300,100,30);


        //SignUp

        emailLabel.setBounds(50,150,100,30);
        passwordlbl.setBounds(50,220,100,30);
        confirmPasswordLabel.setBounds(50,290,100,30);

        emailTextfield.setBounds(180,150,150,30);
        passwordFld.setBounds(180,220,150,30);
        confirmPasswordField.setBounds(180,290,150,30);
        showRPassword.setBounds(180,340,350,30);

        loginBtn.setBounds(180,390,100,30);
        SignUpButton.setBounds(180,430,100,30);

        /*cards.setSize(getMaximumSize().width,getMaximumSize().height);*/
    }

    //Adding components to each JPanel
    //login panel
    public void addComponentsToContainer(){

        LoginContainer.add(userLabel);
        LoginContainer.add(userTextfield);

        LoginContainer.add(passwordlbl);
        LoginContainer.add(passwordField);

        LoginContainer.add(showLPassword);
        LoginContainer.add(emptyLCell);


        LoginContainer.add(loginButton);
        LoginContainer.add(SignUpBtn);

        //signup panel
        RegisterContainer.add(emailLabel);
        RegisterContainer.add(emailTextfield);

        RegisterContainer.add(passwordLabel);
        RegisterContainer.add(passwordFld);

        RegisterContainer.add(confirmPasswordLabel);
        RegisterContainer.add(confirmPasswordField);

        RegisterContainer.add(showRPassword);
        RegisterContainer.add(emptyRCell);

        RegisterContainer.add(SignUpButton);
        RegisterContainer.add(loginBtn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // THIS IS FOR TESTING PURPOSES


//login action lister
        if (e.getSource().equals(loginButton)){
            loginInfo = new LoginInfo();
            char[] passChars = passwordField.getPassword();
            String pass = new String(passChars);

           // passwordField.getPassword().equals("");
            if (loginInfo!=null) {
               // loginInfo = new LoginInfo();

                //String pass = String.copyValueOf(passchars,1,2);
               boolean canLogin = loginInfo.canLoggin(userTextfield.getText(),pass);
               if (canLogin==true){
                   try {

                       if (loginInfo.login()==1){
                           System.out.println(loginInfo.getUsername() + " is Logged In");

                       }else{
                           passwordField.updateUI();
                           System.out.println("Wrong credentials,please try again ");
                           Arrays.fill(passwordField.getPassword(),'0');
                           passwordField.setText("");
                       }
                   } catch (InterruptedException interruptedException) {
                       interruptedException.printStackTrace();
                   } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                       noSuchAlgorithmException.printStackTrace();
                   } catch (IOException ioException) {
                       ioException.printStackTrace();
                   }
               }
            }

        }

//register action listener
        if (e.getSource().equals(SignUpButton)) {
            //check if the inputFields are not empty
            if(passwordFld.getPassword()!=null || emailTextfield.getText()!=null || confirmPasswordField.getPassword()!=null)
            registerInfo = new RegisterInfo();
            String username = emailTextfield.getText();
            char[] passCharacters = passwordFld.getPassword();
            String passText = new String(passCharacters);
            registerInfo.setConfirmPassword(passText);
            if(registerInfo!=null){
                try {
                    int statcode = registerInfo.signUpNewUser(username,passText);
                    int statcode2 = registerInfo.createUserId(username);
                    if((statcode==1)&&(statcode2==1)){
                        System.out.println(registerInfo.getUsername() + " You are registered");
                        FillUp frame = new FillUp();

                        /*Map<String,String> user = new HashMap<>();
                        user.put("email", username);*/

                        frame.frame.setUserProfileId(username);
                        //frame.FillUp;
                        this.dispose();
                    }else if((statcode==0)&&(statcode2==0)){
                        System.out.println(" Something went wrong! Try again");
                    }else {
                        System.out.println(" SHit happend");
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    noSuchAlgorithmException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }


        if (e.getSource().equals(loginBtn)){
            cl.show(cards,"Login Panel");
        }
        if (e.getSource().equals(SignUpBtn)){
            cl.show(cards, "SignUp Panel");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
            //char Original = passwordField.getEchoChar();
            if(e.getStateChange()== ItemEvent.SELECTED){
                confirmPasswordField.setEchoChar((char)0);
                passwordFld.setEchoChar((char)0);
                passwordField.setEchoChar((char)0);

            }else {
                passwordFld.setEchoChar('*');
                passwordField.setEchoChar('*');
                confirmPasswordField.setEchoChar('*');
            }
        }
    }

