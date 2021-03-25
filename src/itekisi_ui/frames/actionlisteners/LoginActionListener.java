package itekisi_ui.frames.actionlisteners;

import itekisi_models.User;
import itekisi_ui.Login;
import itekisi_ui.datapackage.LoginInfo;
import itekisi_ui.datapackage.UserInfo;
import itekisi_ui.frames.Master;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginActionListener implements ActionListener {


    LoginInfo loginInfo;
    public User user;
    String Username,Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals("loginButton"))
        loginInfo = new LoginInfo();
        user = new User();
        if (loginInfo==null){
            loginInfo = new LoginInfo();
            try {
                if (loginInfo.login()==1){
                    user.Username = Username;
                    user.Password = Password;
                    JOptionPane.showMessageDialog(new JLabel(),"Hello : " + user.Username);
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
