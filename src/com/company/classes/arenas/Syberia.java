package com.company.classes.arenas;

import com.company.Team;
import com.company.classes.ArenaBase;

import javax.swing.*;
import java.awt.*;

public class Syberia extends ArenaBase {
    public Syberia() {
        int[][] sth = {{2*40,0*80},{6*40,0*80},{2*40,4*80},{6*40,4*80},{0*40,2*80},{8*40,2*80},{4*40,2*80}};
        this.wallLocation = sth;
        this.baseImage = new ImageIcon("14.png").getImage();
    }
}
