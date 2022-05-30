package com.isep.rpg.enemy;

import com.isep.rpg.actors.Hero;

public class Boss extends Enemy {

    /**
     *
     * @param life
     * @param damage_weapon
     */
    public Boss(int life, int damage_weapon) {
        super(life, damage_weapon);
    }

    public Boss(){
        this(100, 45);
    }

}
