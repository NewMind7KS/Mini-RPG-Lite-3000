package com.isep.rpg.actors;

import com.isep.rpg.enemy.Enemy;

public class Mage extends SpellCaster implements Actor{

    public String name = "Mage";


    public Mage(int lifePoints, int armor, int weaponDamage) {
        super(lifePoints, armor, weaponDamage);
    }

    public Mage(){
        this(100,100,25);
    }

    public String getName(){
        return name;
    }

    @Override
    public void attack(Enemy enemy) {
        int enemy_life = enemy.getLifePoints();
        if(manaPoints == 0){
            System.out.println("You did not have enough mana to attack");
        }
        enemy_life--;
        manaPoints -= 10;
    }


}
