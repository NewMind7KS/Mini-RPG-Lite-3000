package com.isep.rpg.enemy;

import com.isep.rpg.actors.Hero;

public abstract class Enemy {

    public int lifePoints;

    protected int damage_weapon;


    public Enemy(int life, int damage_weapon){
        this.lifePoints = life;
        this.damage_weapon = damage_weapon;
    }


    public int getLifePoints() {
        if(this.lifePoints < 0){
            this.setLifePoints(0);
        }else if(this.lifePoints > 100){
            this.setLifePoints(100);
        }
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getDamage_weapon() {
        return damage_weapon;
    }

    public void setDamage_weapon(int damage_weapon) {
        this.damage_weapon = damage_weapon;
    }

    public boolean attack(Hero hero){
        int lifepoint_hero = hero.getLifePoints();
        hero.defend(damage_weapon);
        if(hero.getArmor() == 0){
            lifepoint_hero -= damage_weapon;
        }
        return true;
    }


}
