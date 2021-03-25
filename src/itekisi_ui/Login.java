package itekisi_ui;

import javax.swing.*;

public class Login {
    public JFrame frame;
  public void logginIn() {
      //frame = new LoginFrame();
      frame.setTitle("Login Form");
      frame.setVisible(true);
      frame.setBounds(10, 10, 370, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
  }
}
