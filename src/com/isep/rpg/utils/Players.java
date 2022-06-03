package com.isep.rpg.utils;

public enum Players {
    Hunter(1), Healer(2), Warrior(3), Mage(4);

    private int player;

    Players(int player) {
        this.player = player;
    }

    public int getPlayer(){
        return player;
    }
}
