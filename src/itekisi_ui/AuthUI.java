package itekisi_ui;

import itekisi_ui.frames.AuthenticationFrame;
import itekisi_ui.frames.Master;

import javax.swing.*;
import java.awt.*;

public class AuthUI {

    public AuthUI() {

        JFrame master = new Master();
        JFrame authframe = new AuthenticationFrame();
        authframe.setJMenuBar(master.getJMenuBar());
        authframe.setVisible(true);
        authframe.setBounds(300, 50, 800, 600);//Also sets the width and height
        authframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        authframe.setResizable(true);

    }
}
