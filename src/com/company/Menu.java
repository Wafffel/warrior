package com.company;

import com.company.classes.CharacterClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu extends JPanel {
    private Team team;
    private int whatSelected = 0;
    private String[] mapNames = {"syberia", "castle"};
    private int selectedMap = 0;
    private int playerNumber = 4;
    private MenuWindow frame;

    public Menu(Team team, MenuWindow frame) {
        this.frame = frame;
        this.team = team;
        setFocusable(true);
        addKeyListener(new Menu.FieldKeyListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (whatSelected) {
            case 0:
                g.drawString("> Map: " + mapNames[selectedMap], 50, 50);
                g.drawString("Player Number: " + playerNumber, 50, 75);
                g.drawString("Start", 50, 100);
                break;
            case 1:
                g.drawString("Map: " + mapNames[selectedMap], 50, 50);
                g.drawString("> Player Number: " + playerNumber, 50, 75);
                g.drawString("Start", 50, 100);
                break;
            case 2:
                g.drawString("Map: " + mapNames[selectedMap], 50, 50);
                g.drawString("Player Number: " + playerNumber, 50, 75);
                g.drawString("> Start", 50, 100);
                break;
        }
    }

    public class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_UP && whatSelected > 0) {
                whatSelected--;
            }
            if (key == KeyEvent.VK_DOWN && whatSelected < 2) {
                whatSelected++;
            }
            if (key == KeyEvent.VK_LEFT && whatSelected == 0 && selectedMap > 0) {
                selectedMap--;
            }
            if (key == KeyEvent.VK_RIGHT && whatSelected == 0 && selectedMap < mapNames.length-1) {
                selectedMap++;
            }
            if (key == KeyEvent.VK_LEFT && whatSelected == 1 && playerNumber > 1) {
                playerNumber--;
            }
            if (key == KeyEvent.VK_RIGHT && whatSelected == 1 && playerNumber < 4) {
                playerNumber++;
            }
            if (key == KeyEvent.VK_ENTER && whatSelected == 2) {
                team.start();
                frame.dispose();
            }
            repaint();
        }
    }
}


