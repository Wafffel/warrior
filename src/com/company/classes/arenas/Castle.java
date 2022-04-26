package com.company.classes.arenas;

import com.company.classes.ArenaBase;

import javax.swing.*;

public class Castle extends ArenaBase {
    public Castle() {
        int[][] sth = {{2*40,1*80},{6*40,1*80},{2*40,3*80},{6*40,3*80}};
        this.wallLocation = sth;
        this.baseImage = new ImageIcon("17.png").getImage();
    }
}
