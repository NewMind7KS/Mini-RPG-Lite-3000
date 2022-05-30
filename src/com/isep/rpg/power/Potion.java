package com.isep.rpg.power;

import com.isep.rpg.actors.Healer;
import com.isep.rpg.actors.Hero;
import com.isep.rpg.actors.SpellCaster;

public class Potion implements Consumable{

    /**
     * rallonge les points de vie d'un hero
     *
     * @param hero
     */
    @Override
    public void regenerate(Hero hero) {
        hero.setLifePoints(hero.getLifePoints() + 15);
        if(hero.getLifePoints() > 100){
            hero.setLifePoints(100);
        }
    }

/*    @Override
    public void boostMagna(SpellCaster sp) {
        if(sp.getManaPoints() < 100){
            sp.setManaPoints(sp.getManaPoints() + 25);
            if(sp.getManaPoints() > 100){
                sp.setLifePoints(100);
            }
        }
    }*/
}
