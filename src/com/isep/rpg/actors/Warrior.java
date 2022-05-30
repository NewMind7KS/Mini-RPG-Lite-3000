    package com.isep.rpg.actors;

    import com.isep.rpg.enemy.Enemy;

    public class Warrior extends Hero implements Actor{

        public Warrior(){
            this.name= "Warrior";
        }

        public Warrior(int lifePoints, int armor, int weaponDamage)
        {
            super(lifePoints, armor, weaponDamage);
        }

        @Override
        public void attack(Enemy enemy){
            enemy.lifePoints--;
        }


    }
