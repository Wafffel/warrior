package com.company;

import com.company.classes.CharacterClass;
import com.company.classes.MonsterClass;
import com.company.classes.arenas.Syberia;
import com.company.classes.monsters.Bat;
import com.company.classes.monsters.Zombie;

public class Team {
    private CharacterClass[] teamMembers;

    public void setArena(Syberia arena) {
        this.arena = arena;
    }

    private Syberia arena;
    public Team(CharacterClass... members) {
        teamMembers = new CharacterClass[members.length];

        for (int i = 0; i < teamMembers.length; i++) {
            teamMembers[i] = members[i];
        }
    }

    public CharacterClass[] getTeamMembers() {
        return teamMembers;
    }

    public void info(){
        //for(int i = 0; i < teamMembers.length; i++){
        for(CharacterClass teamMembers : teamMembers){
            teamMembers.info();
        }
    }

    public boolean enterArena(Syberia arena1) {
        return arena1.open(this);
    }

    public void runArena() {
        MonsterClass[] monsters = {new Zombie(this.teamMembers, 120, 160), new Bat(this.teamMembers, 160, 160), new Zombie(this.teamMembers, 200, 160)};
        MainWindow mw = new MainWindow(375, 438, this, monsters);
    }
}
