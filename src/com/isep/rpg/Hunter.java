package com.isep.rpg;

public class Hunter extends Hero{
    private int arrows;


    public Hunter(int lifePoints, int armor, int weaponDamage, int arrows) {
        super(lifePoints, armor, weaponDamage);
        this.arrows = arrows;
    }
}
