package com.isep.rpg.actors;
import com.isep.rpg.power.Consumable;
import com.isep.rpg.power.Food;
import com.isep.rpg.power.Potion;
import com.isep.rpg.enemy.Enemy;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero {


    /**
     * @int lifePoints
     */
    protected int lifePoints ;

    /**
     * @int armor
     */
    protected int armor ;

    /**
     * @int weaponDamage
     */
    protected int weaponDamage ;

    /**
     * @ArrayList<> potions
     */
    private ArrayList <Potion> potions = new ArrayList<>();
    private ArrayList <Food> lembas = new ArrayList<>();
    protected String name;
    Scanner scanner = new Scanner(System.in);

    /**
     * constructeur
     * @param lifePoints
     * @param armor
     * @param weaponDamage
     */
    public Hero(int lifePoints, int armor, int weaponDamage )
    {
        this.lifePoints= lifePoints;
        this.armor=armor;
        this.weaponDamage=weaponDamage;
        this.lembas.add(new Food());
        this.potions.add(new Potion());
    }

    public Hero(){
        this(100, 100, 0);
    }


    /**
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return
     */
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


    /**
     *
     * @param consumable
     */
    public void useConsumable(Consumable consumable)
    {
        //manger des lembas
        if(consumable instanceof Food)//un élément de type Food
        {
            this.lembas.remove(consumable); // on retire l'aliment de notre liste
            consumable.regenerate(this);
        }else if(consumable instanceof Potion){ // un élement de type Potion
            this.potions.remove(consumable); // on retire la potion de la liste
            consumable.regenerate(this); // on rallonge la vie du Hero
        }

        //boire une potion
    }


    public void takeFood(){
        if(this.lifePoints < 25){
            System.out.println("Que souhaitez vous prendre \n 1- Potion P " + "(" + this.potions.size() + ")" +
                    "  \n 2- Food F " + "(" + this.lembas.size() + ")");
            char typeCons = scanner.next().charAt(0);
            switch (typeCons){
                case 'P':
                    this.useConsumable(new Potion());
                case 'F':
                    this.useConsumable(new Food());
            }
        }
    }



    public void defend(){
        this.armor--;
    }

    public void defend(int damage){
        this.armor -= damage;
    }

    public int getArmor() {
        if(armor < 0){
            this.setArmor(0);
        }else if (armor > 100){
            this.setArmor(100);
        }
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
