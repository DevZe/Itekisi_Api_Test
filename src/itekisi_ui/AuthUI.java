package itekisi_ui;

import itekisi_ui.frames.AuthenticationFrame;
import itekisi_ui.frames.Master;

import javax.swing.*;
import java.awt.*;

public class AuthUI {

    public AuthUI() {

        JFrame master = new Master();
        JFrame authframe = new AuthenticationFrame();
        master.setContentPane(authframe.getContentPane());
       // authframe.setJMenuBar(master.getJMenuBar());
        /*authframe.setVisible(true);
        authframe.setBounds(300, 50, 800, 600);//Sets the main frame at top center
        authframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        authframe.setResizable(true);*/

        master.setVisible(true);
        master.setBounds(300, 50, 800, 600);//Sets the main frame at top center
        master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        master.setResizable(true);

    }
}
