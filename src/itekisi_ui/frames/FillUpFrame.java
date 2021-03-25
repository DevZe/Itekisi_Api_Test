package itekisi_ui.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FillUpFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel nameLabel = new JLabel("Name");
    JLabel surnameLabel = new JLabel("Surname");
    JLabel idnumberLabel = new JLabel("IDNumber");
    JLabel homeaddressLabel = new JLabel("HomeAdress");
    JLabel genderLabel = new JLabel("Gender");

    JTextField nameTextfield = new JTextField();
    JTextField surnameTextField = new JTextField();
    JTextField idnumberTextField = new JTextField();

    JTextField homeaddressTextField = new JTextField();

    JCheckBox genderM = new JCheckBox("Male");
    JCheckBox genderF = new JCheckBox("Female");
    JCheckBox genderO = new JCheckBox("Other");
    JButton submitButton = new JButton("Submit");



    public FillUpFrame(){
        //Calling methods inside constructor

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLayoutManager(){
        container.setLayout(null);
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

        submitButton.setBounds(150,380,100,30);

    }

    public void addComponentsToContainer(){
        //Adding each components to the container
        container.add(nameLabel);
        container.add(surnameLabel);
        container.add(idnumberLabel);
        container.add(genderLabel);
        container.add(homeaddressLabel);

        container.add(nameTextfield);
        container.add(surnameTextField);
        container.add(idnumberTextField);
        container.add(homeaddressTextField);

        container.add(genderF);
        container.add(genderM);
        container.add(genderO);
        container.add(submitButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(submitButton)){

        }
    }
}
