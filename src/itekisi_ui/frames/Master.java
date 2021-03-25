package itekisi_ui.frames;

import itekisi_ui.AuthUI;

import javax.swing.*;
import java.awt.event.*;

public class Master extends JFrame implements ActionListener, ItemListener {

    public JMenuBar menuBar;
    JMenu menu,submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JButton loginButton = new JButton("Login");

    JCheckBoxMenuItem cbMenuItem;




    //create the menubar in the constructor
    public Master(){
        menuBar = new JMenuBar();
        build();
        groupMenuItems();
        groupRadioButtonMenu();
    }

    //create the menu and add it to the menuBar
    public void build(){
     menu = new JMenu("A Menu");
     menu.setMnemonic(KeyEvent.VK_A);

     menu.getAccessibleContext().setAccessibleDescription("The only menu that has menu items");
     menuBar.add(menu);

    }

    public void groupMenuItems(){

        menuItem= new JMenuItem("A text-only menu item",KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Nothing is done here");
        menu.add(menuItem);


        menuItem = new JMenuItem("Both text and icon",new ImageIcon("images/image.png"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem=new JMenuItem(new ImageIcon("images/image.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);
    }

    public void groupRadioButtonMenu(){

        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        // a group of Menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another one");
        submenu.add(menuItem);
        menu.add(submenu);

        menu = new JMenu("Login");
        menu.setMnemonic(KeyEvent.VK_N);


        menuBar.add(Box.createHorizontalGlue());
        menu.getAccessibleContext().setAccessibleDescription("Menu, no sh!t done");
        menuBar.add(loginButton);
        this.setJMenuBar(menuBar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(menuItem.getComponent())){
            JOptionPane.showMessageDialog(this,"You clicked something");
        }
        if (e.getSource().equals(loginButton)){
             new AuthUI();
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange()==ItemEvent.SELECTED){

        }
    }
}
