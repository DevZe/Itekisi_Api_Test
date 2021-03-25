package itekisi_ui.frames;

import itekisi_ui.datapackage.UserInfo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class FillUpFrame extends JFrame implements ActionListener, ItemListener {

    JPanel container;
    JPanel fillUpPanel;
    JPanel controlPanel;
    final CardLayout cl = new CardLayout();
    final JPanel cards = new JPanel(cl);
    JLabel nameLabel = new JLabel("Name");
    JLabel surnameLabel = new JLabel("Surname");
    JLabel idnumberLabel = new JLabel("IDNumber");
    JLabel homeaddressLabel = new JLabel("HomeAdress");
    JLabel genderLabel = new JLabel("Gender");
    final Border border = BorderFactory.createEmptyBorder(100,200,100,200);

    JTextField nameTextfield = new JTextField();
    JTextField surnameTextField = new JTextField();
    JTextField idnumberTextField = new JTextField();

    JTextField homeaddressTextField = new JTextField();

    JCheckBox genderM = new JCheckBox("Male");
    JCheckBox genderF = new JCheckBox("Female");
    JCheckBox genderO = new JCheckBox("Other");
    JButton submitButton = new JButton("Submit");
    JLabel emptyCell1 = new JLabel("");
    JLabel emptyCell2 = new JLabel("");
    JLabel emptyCell3 = new JLabel("");
    JLabel emptyCell4 = new JLabel("");
    JLabel emptyCell5 = new JLabel("");

    String gender="";

    static String setUser(String username) {
        FillUpFrame.username = FillUpFrame.username;
        return FillUpFrame.username;
    }

    public static String username;

    UserInfo userInfo;

    public FillUpFrame(){
        //Calling methods inside constructor

        container = new JPanel(null);
        fillUpPanel = new JPanel();
        controlPanel = new JPanel();


        setLayoutManager();
        addComponentsToContainer();
        setLocationAndSize();
        cl.show( cards,"fillUp");

        submitButton.addActionListener(this::actionPerformed);
        genderM.addActionListener(this::actionPerformed);
        genderF.addActionListener(this::actionPerformed);
        genderO.addActionListener(this::actionPerformed);

    }

    public void setLayoutManager(){

        setContentPane(fillUpPanel);
        container.setLayout( new GridLayout(9,2));
        fillUpPanel.setLayout(new BoxLayout(fillUpPanel,BoxLayout.PAGE_AXIS));;
        fillUpPanel.setBorder(BorderFactory.createEmptyBorder(90,200,90,200));
        controlPanel.setBackground(Color.LIGHT_GRAY);
       // container.setBorder(border);
        controlPanel.setBorder(border);
        fillUpPanel.setVisible(true);
        container.setVisible(true);
    }
    public  void setLocationAndSize(){
        //Setting location and Size of each components using setBounds() methods
        nameLabel.setBounds(50,150,100,30);
        surnameLabel.setBounds(50,180,100,30);
        idnumberLabel.setBounds(50,210,100,30);

        homeaddressLabel.setBounds(50,240,100,30);

        nameTextfield.setBounds(150,150,150,30);
        surnameTextField.setBounds(150,180,150,30);
        idnumberTextField.setBounds(150,210,150,30);

        homeaddressTextField.setBounds(150,240,150,30);

        genderLabel.setBounds(50,280,100,30);
        genderF.setBounds(50,300,150,30);
        genderM.setBounds(50,320,150,30);
        genderO.setBounds(50,340,150,30);

        submitButton.setSize(50,30);

    }

    public void addComponentsToContainer(){
        //Adding each components to the container
        controlPanel.add(new JLabel("FIll UP"));
        container.add(nameLabel);
        container.add(nameTextfield);

        container.add(surnameLabel);
        container.add(surnameTextField);

        container.add(idnumberLabel);
        container.add(idnumberTextField);

        container.add(homeaddressLabel);
        container.add(homeaddressTextField);


        container.add(genderLabel);
        container.add(emptyCell1);

        container.add(genderF);
        container.add(emptyCell2);

        container.add(genderM);
        container.add(emptyCell3);

        container.add(genderO);
        container.add(emptyCell4);

        container.add(emptyCell5);
        container.add(submitButton);

        cards.add(container,"fillUp",0);
        fillUpPanel.add(controlPanel);
        fillUpPanel.add(cards);
    }

    //get input from the ui objects
    void getInputs() throws InterruptedException, NoSuchAlgorithmException, IOException {
        userInfo = new UserInfo();
        if (userInfo !=null) {
            Map<String, String> profile = new HashMap<>();
            profile.put("Name", nameTextfield.getText());
            profile.put("Surname", surnameTextField.getText());
            profile.put("IDNumber", idnumberTextField.getText());
            profile.put("Gender", gender);
            profile.put("Address", homeaddressTextField.getText());
            profile.put("UserId", userInfo.getUserId(username));//should not use addMe here
            userInfo.addMe(profile);
            //userInfo.createNewProfile(profile);
        }


    }


    void setUserProfileId(String username){
        this.setUser(username);
    }

    //get genderInput
    void setGender(){

        if (genderO.isSelected()){
            genderF.setSelected(false);
            genderM.setSelected(false);
            gender=  "other";
        }
        if (genderM.isSelected()){
            genderO.setSelected(false);
            genderF.setSelected(false);
            gender= "male";
        }
        if (genderF.isSelected()){
            genderO.setSelected(false);
            genderM.setSelected(false);
            gender= "female";
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(submitButton)){
            try {
                getInputs();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource().equals(genderF)){
            setGender();
        }
        if (e.getSource().equals(genderM)){
            setGender();
        }
        if (e.getSource().equals(genderO)){
            setGender();
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {


    }
}
