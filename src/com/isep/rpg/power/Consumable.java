package com.isep.rpg.power;

import com.isep.rpg.actors.Healer;
import com.isep.rpg.actors.Hero;
import com.isep.rpg.actors.SpellCaster;

public interface Consumable {

    /**
     * rallonge les points de vie d'un hero
     * @param hero
     */
    public void regenerate(Hero hero);

    /*public void boostMagna(SpellCaster sp);*/
}
