package com.company;

import com.company.classes.MonsterClass;

import javax.swing.*;

public class MenuWindow extends JFrame {
    public MenuWindow(int weight, int height, Team team) {
        setSize(weight, height);
        /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (int) ((screenSize.getWidth() - weight) / 2);
        int locationY = (int) ((screenSize.getHeight() - height) / 2);
        setLocation(locationX, locationY);*/
        setLocationRelativeTo(null);
        add(new Menu(team, this));
        setVisible(true);
    }
}
