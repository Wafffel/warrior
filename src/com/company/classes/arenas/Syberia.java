package com.company.classes.arenas;

import com.company.Team;

import javax.swing.*;
import java.awt.*;

public class Syberia implements BaseArena{
    private boolean isOpened = false;
    public int[][] wallLocation = {{2*40,1*80},{6*40,1*80},{2*40,3*80},{6*40,3*80}};
    public Image baseImage = new ImageIcon("14.png").getImage();

    public Image getBaseImage() {
        return baseImage;
    }

    public int[][] getWallLocation() {
        return wallLocation;
    }

    public boolean open(Team team) {
        if (team.getTeamMembers().length < 1) {
            System.out.println("Not enough party members!");
            isOpened = false;
        } else {
            System.out.println("Welcome, heroes");
            isOpened = true;
        }
        return isOpened;
    }
}
