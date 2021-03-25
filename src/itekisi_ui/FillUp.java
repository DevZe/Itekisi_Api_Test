package itekisi_ui;

import itekisi_ui.frames.FillUpFrame;

import javax.swing.*;

public class FillUp {

    public void FillingUp(){
    FillUpFrame frame = new FillUpFrame();
      frame.setTitle("FillUp Form");
      frame.setVisible(true);
      frame.setBounds(10,10,370,600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
    }
}
