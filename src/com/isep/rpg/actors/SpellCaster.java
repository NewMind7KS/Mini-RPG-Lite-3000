package com.isep.rpg.actors;

import com.isep.rpg.enemy.Enemy;

public abstract class SpellCaster extends Hero {


    protected int manaPoints = 100;


    public SpellCaster(int lifePoints, int armor, int weaponDamage) {
        super(lifePoints, armor, weaponDamage);
    }

    public int getManaPoints() {
        if(manaPoints < 0){
            this.setManaPoints(0);
        }else if(manaPoints > 100){
            this.setManaPoints(100);
        }
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }


}
