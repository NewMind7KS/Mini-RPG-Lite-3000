package com.isep.rpg.power;

import com.isep.rpg.actors.Healer;
import com.isep.rpg.actors.Hero;
import com.isep.rpg.actors.SpellCaster;

public class Food implements Consumable{


    /**
     * rallonge les points de vie d'un hero
     *
     * @param hero
     */
    @Override
    public void regenerate(Hero hero) {
        hero.setLifePoints(hero.getLifePoints() + 13);
    }

    /*
    @Override
    public void boostMagna(SpellCaster sp) {
        if(sp.getManaPoints() < 100){
            sp.setManaPoints(sp.getManaPoints() + 20);
            if(sp.getManaPoints() > 100){
                sp.setLifePoints(100);
            }
        }
    }*/
}
