package itekisi_ui;

import itekisi_ui.frames.SignUpLoginFrame;

import javax.swing.*;

public class SignUp {
    public JFrame frame;
    public void SigningUp() {
        frame = new JFrame();
        frame = new SignUpLoginFrame();
        frame.setTitle("Sign Up");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
}
