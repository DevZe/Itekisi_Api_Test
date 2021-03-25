package itekisi_ui.frames;

import itekisi_ui.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpLoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel emailLabel = new JLabel("Email");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");

    JTextField emailTextfield = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();

    JButton signUpButton = new JButton("SignUp");
    JButton loginButton = new JButton("Login");
    JCheckBox showPassword = new JCheckBox("Show Password");
    Login login;


    public SignUpLoginFrame(){
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
        emailLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        confirmPasswordLabel.setBounds(50,290,100,30);

        emailTextfield.setBounds(180,150,150,30);
        passwordField.setBounds(180,220,150,30);
        confirmPasswordField.setBounds(180,290,150,30);
        showPassword.setBounds(180,340,350,30);

        loginButton.setBounds(180,390,100,30);
        signUpButton.setBounds(180,430,100,30);
    }

    public void addComponentsToContainer(){
        //Adding each components to the container
        container.add(emailLabel);
        container.add(passwordLabel);
        container.add(confirmPasswordLabel);

        container.add(emailTextfield);
        container.add(passwordField);
        container.add(confirmPasswordField);

        container.add(showPassword);
        container.add(loginButton);
        container.add(signUpButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(signUpButton)){
            //do the login methods
        }
        if (e.getSource().equals(loginButton)){
            login = new Login();
            login.logginIn();
            JOptionPane.setRootFrame(login.frame);
        }
    }
}
