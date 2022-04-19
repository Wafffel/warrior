package com.company.classes;

import com.company.GameField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MonsterClass {
    public static int monsterCount = 5;
    protected int speed;
    protected int attackAmount;
    protected int maxHealth, health;
    private int number;
    protected Image image;
    private int x, y;
    private CharacterClass[] players;

    public MonsterClass(CharacterClass[] players, int x, int y) {
        this.number = ++this.monsterCount;
        this.players = players;
        CharacterClass.occupiedCells[x][y] = number;
        this.spawn(x, y);
    }

    public void spawn(int x, int y) {
        this.x = x;
        this.y = y;
        MonsterClass thisMonster = this;
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("start");
                        try {
                            thisMonster.move();
                        } catch (AWTException e) {
                            e.printStackTrace();
                        }
                    }
                }, 2000
        );
    }

    public void move() throws AWTException {
        Robot robot = new Robot();
        System.out.println("move");
        int direction = ((int)(Math.random()*(4)));
        switch (direction) {
            case 0:
                System.out.println("0");
                if (this.y<320 && CharacterClass.occupiedCells[this.x][this.y+80]==0) {
                    CharacterClass.occupiedCells[this.x][this.y] = 0;
                    this.y += 80;
                    CharacterClass.occupiedCells[this.x][this.y] = number;
                } else if (this.y<320 && CharacterClass.occupiedCells[this.x][this.y+80]>0 && CharacterClass.occupiedCells[this.x][this.y+80]<5) {
                    this.attack(players[(CharacterClass.occupiedCells[this.getX()][this.getY()+80])-1]);
                }
                robot.keyPress(KeyEvent.VK_HOME);
                break;
            case 1:
                System.out.println("1");
                if (this.x<320 && CharacterClass.occupiedCells[this.x+40][this.y]==0) {
                    CharacterClass.occupiedCells[this.x][this.y] = 0;
                    this.x += 40;
                    CharacterClass.occupiedCells[this.x][this.y] = number;
                } else if (this.x<320 && CharacterClass.occupiedCells[this.x+40][this.y]>0 && CharacterClass.occupiedCells[this.x+40][this.y]<5) {
                    this.attack(players[(CharacterClass.occupiedCells[this.getX()+40][this.getY()])-1]);
                }
                robot.keyPress(KeyEvent.VK_HOME);
                break;
            case 2:
                System.out.println("2");
                if (this.y>0 && CharacterClass.occupiedCells[this.x][this.y-80]==0) {
                    CharacterClass.occupiedCells[this.x][this.y] = 0;
                    this.y -= 80;
                    CharacterClass.occupiedCells[this.x][this.y] = number;
                } else if (this.y>0 && CharacterClass.occupiedCells[this.x][this.y-80]>0 && CharacterClass.occupiedCells[this.x][this.y-80]<5) {
                    this.attack(players[(CharacterClass.occupiedCells[this.getX()][this.getY()-80])-1]);
                }
                robot.keyPress(KeyEvent.VK_HOME);
                break;
            case 3:
                System.out.println("3");
                if (this.x>0 && CharacterClass.occupiedCells[this.x-40][this.y]==0) {
                    CharacterClass.occupiedCells[this.x][this.y] = 0;
                    this.x -= 40;
                    CharacterClass.occupiedCells[this.x][this.y] = number;
                } else if (this.x>0 && CharacterClass.occupiedCells[this.x-40][this.y]>0 && CharacterClass.occupiedCells[this.x-40][this.y]<5) {
                    this.attack(players[(CharacterClass.occupiedCells[this.getX()-40][this.getY()])-1]);
                }
                robot.keyPress(KeyEvent.VK_HOME);
                break;
        }
        MonsterClass thisMonster = this;
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            thisMonster.move();
                        } catch (AWTException e) {
                            e.printStackTrace();
                        }
                    }
                }, speed
        );
    }

    public void attack(CharacterClass attackedPlayer) {
        attackedPlayer.reduceHealth(this.attackAmount);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Image getImage() {
        return image;
    }

    public void reduceHealth(int amount) {
        this.health -= amount;
        System.out.println("monster: "+ this.health);
        if (this.health <= 0) {
            this.health = this.maxHealth;
            CharacterClass.occupiedCells[this.x][this.y] = 0;
            do {
                int x = ((int)(Math.random()*(10)))*40;
                int y = ((int)(Math.random()*(6)))*80;
            } while(CharacterClass.occupiedCells[x][y] == 0);
            this.spawn(x,y);
        }
    }

    public int getHealth() {
        return health;
    }
}
