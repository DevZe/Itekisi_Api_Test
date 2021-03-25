package itekisi_ui;

import itekisi_ui.frames.FillUpFrame;
import itekisi_ui.frames.Master;

import javax.swing.*;

public class FillUp {

    public FillUpFrame frame;
    //Master master;
    public FillUp(){
    frame = new FillUpFrame();
    //master = new Master();
      //frame.setJMenuBar(master.menuBar);
      frame.setTitle("FillUp Form");
      frame.setVisible(true);
      frame.setBounds(300, 50, 800, 700);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
    }
}
