package com.isep.rpg.game;

import com.isep.rpg.actors.*;
import com.isep.rpg.enemy.BasicEnemy;
import com.isep.rpg.enemy.Boss;
import com.isep.rpg.enemy.Enemy;
import com.isep.rpg.utils.Players;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<Hero> Hereos = new ArrayList<>();

    private ArrayList<Enemy> killers = new ArrayList<>();

    private int playerTurn = 1;

    private Players players;

    private Enemy enemy;

    Scanner scanner = new Scanner(System.in);

    Random rand = new Random();

    public Game() {
    }


    public void start() {
        System.out.println("entrez le nombre de heros");
        int taille = scanner.nextInt();
        int time = 1;
        System.out.println(taille);

        do {
            System.out.println("entrez le type de heros, \n 1- H pour Hunter" +
                    "\n 2- h pour Healer" + "\n 3- M pour Mage" +
                    "\n 4- W pour Warrior");
            char type = scanner.next().charAt(0);//on prend le premier caractere
            switch (type) {
                case 'H':
                    this.Hereos.add(new Hunter());
                    do {
                        this.killers.add(new Boss());
                    }while (time <= 1);
                    time--;
                    if (this.killers.size() < taille) this.killers.add(new BasicEnemy());
                    taille--;
                    break;
                case 'h':
                    this.Hereos.add(new Healer());
                    do {
                        this.killers.add(new Boss());
                    }while (time <= 1);
                    time--;
                    if (this.killers.size() < taille) this.killers.add(new BasicEnemy());
                    taille--;
                    break;
                case 'M':
                    this.Hereos.add(new Mage());
                    do {
                        this.killers.add(new Boss());
                    }while (time <= 1);
                    time--;
                    if (this.killers.size() < taille) this.killers.add(new BasicEnemy());
                    taille--;
                    break;
                case 'W':
                    this.Hereos.add(new Warrior());
                    do {
                        this.killers.add(new Boss());
                    }while (time <= 1);
                    time--;
                    if (this.killers.size() < taille) this.killers.add(new BasicEnemy());
                    taille--;
                    break;
                default:
                    System.out.println("Ce type de personnage n'existe pas, réessayer un autre");
            }
        }
        while (taille > 0);
    }

    public void afficheHero() {
        if (Hereos.isEmpty()){
            System.out.println("liste vide");
        }
        else{
            int size= Hereos.size();
            for(int i=0; i< size; i++)
            {
                System.out.println(Hereos.get(i).getName());
            }
        }

    }

    public void playGame() {
        while(end()){
            this.start();
            this.turn(1);
        }
    }

    public void genarateCombat() {
        ArrayList<Hero> heroList = new ArrayList<>();
        heroList.add(new Mage());
        heroList.add(new Warrior());
        heroList.add(new Hunter());
        heroList.add(new Healer());

        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.add(new Boss());
        enemyList.add(new BasicEnemy());

        int nbPlayers= rand.nextInt(2, 11);

        for (int i = 0; i < nbPlayers; i++){
            this.killers.add(enemyList.get(rand.nextInt(2)));
            this.Hereos.add(heroList.get(rand.nextInt(4)));
        }

        while(!end()){
            this.turn(rand.nextInt(1, 5));
        }
    }

    public void turn(int playerTurn) {
        switch(playerTurn){
            case 1:
                Hunter hunter = new Hunter();
                if(enemy.attack(hunter)){
                    hunter.attack(enemy);
                }
                hunter.takeFood();
                this.playerTurn = 3;
                break;
            case 2:
                Healer healer = new Healer();
                System.out.println("Quel héro voulez-vous soignez ? Hunter H, Warrior W, Mage M");
                char typeHero = scanner.next().charAt(0);
                if(enemy.attack(healer)){
                    healer.heal(this.getHeroesForHealer(typeHero));
                }
                this.playerTurn = 4;
                break;
            case 3:
                Warrior warrior = new Warrior();
                warrior.takeFood();
                if(enemy.attack(warrior)){
                    warrior.attack(enemy);
                }
                this.playerTurn = 1;
                break;
            case 4:
                Mage mage =  new Mage();
                if(enemy.attack(mage)){
                    mage.attack(enemy);
                }
                mage.takeFood();
                this.playerTurn = 2;
                break;
        }
    }

    /**
     *
     * @param character
     * @return
     */
    public Hero getHeroesForHealer(char character){
        Hero hero = null;

        for(Hero h: this.Hereos){
            if(character == 'H' && h instanceof Hunter){
                hero = h;
            }
            else if(character == 'W' && h instanceof Warrior){
                hero = h;
            }
            else if(character == 'M' && h instanceof Mage){
                hero = h;
            }
        }
        return hero;
    }


    /**
     * boucle de jeu
      * @return
     */
    public boolean end(){
        for(Hero hero: this.Hereos){
            if(hero.getLifePoints() == 0){
                this.Hereos.remove(hero);
            }
        }

        while(this.Hereos.isEmpty()){
            return true;
        }
        return false;
    }


}
