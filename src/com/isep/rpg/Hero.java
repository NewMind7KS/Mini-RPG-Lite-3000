package com.isep.rpg;
import java.util.ArrayList;

public abstract class Hero {
    private int lifePoints ;
    private int armor ;
    private int weaponDamage ;
    private ArrayList <Potion> potions ;
    private ArrayList <Food> lembas ;

    public  void attack(){}
    public void defend(){}
    public void useConsumable(){}
    public Hero(int lifePoints, int armor, int weaponDamage ){
        this.lifePoints= lifePoints;
        this.armor=armor;
        this.weaponDamage=weaponDamage;

    }


}
