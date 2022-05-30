package com.isep.rpg.actors;

public class Healer extends SpellCaster{


    /**
     * constructor
     * @param lifePoints
     * @param armor
     * @param weaponDamage
     */
    public Healer(int lifePoints, int armor, int weaponDamage) {
        super(lifePoints, armor, weaponDamage);
        this.name= "Healer";
    }

    /**
     * default constructor
     */
    public Healer(){
        this(100,100, 20);
    }

    public void heal(Hero hero){
        int life = hero.getLifePoints();

        if(manaPoints == 0){
            System.out.println("You did not have enough mana to attack");
        }
        life++;
    }
}
