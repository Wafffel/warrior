package com.company.classes.monsters;

import com.company.classes.CharacterClass;
import com.company.classes.MonsterClass;

import javax.swing.*;
import java.awt.*;

public class Zombie extends MonsterClass {

    public Zombie(CharacterClass[] players, int x, int y) {
        super(players, x, y);
        this.speed = 2000;
        this.attackAmount = 100;
        this.health = 200;
        this.maxHealth = 200;
        this.image = new ImageIcon("15.png").getImage();
    }
}
