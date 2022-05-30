package com.isep.rpg.actors;

import com.isep.rpg.enemy.Enemy;

public class Hunter extends Hero implements Actor{

    private int arrows;



    public Hunter(int lifePoints, int armor, int weaponDamage, int arrows) {
        super(lifePoints, armor, weaponDamage);
        this.arrows = arrows;
        this.name= "Hunter";
    }

    public Hunter(){
        this(100,100,15,10);
    }

    @Override
    public void attack(Enemy enemy) {
        int life = enemy.getLifePoints();
        life--;
        this.arrows--;
    }



    public int getLifePoint(){
        return lifePoints;
    }
}
