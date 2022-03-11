package com.isep.rpg;

public abstract class SpellCaster extends Hero {
    private int manaPoints ;

    public SpellCaster(int lifePoints, int armor, int weaponDamage) {
        super(lifePoints, armor, weaponDamage);
    }
}
