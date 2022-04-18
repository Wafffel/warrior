package com.company;

import com.company.classes.arenas.Syberia;
import com.company.classes.characters.Archer;
import com.company.classes.characters.Healer;
import com.company.classes.characters.Mage;
import com.company.classes.characters.Warrior;

import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {
        //Warrior war1 = new Warrior("NAme");
        //war1.info();

        Team team = new Team (
            new Warrior("Aragorn", 0, 0, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_Q, KeyEvent.VK_E, 0),
                new Mage("Gendolf", 0, 320, KeyEvent.VK_H, KeyEvent.VK_K, KeyEvent.VK_U, KeyEvent.VK_J, KeyEvent.VK_Y, KeyEvent.VK_I, 0),
            new Archer("Legolas", 320, 0, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_DELETE, KeyEvent.VK_PAGE_DOWN, 0),
                new Healer("Radagast", 320, 320, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD9)
        );
        team.info();
        Syberia arena1 = new Syberia();
        if (team.enterArena(arena1)) {
            team.setArena(arena1);
            team.runArena();
        } else {
            System.out.println("Game over");
        }
    }
}
