package com.isep.rpg.enemy;

import com.isep.rpg.actors.Hero;

public class BasicEnemy extends Enemy {

    public BasicEnemy(int life, int damage_weapon){
        super(life, damage_weapon);
    }

    public BasicEnemy(){
        this(100, 34);
    }

}
