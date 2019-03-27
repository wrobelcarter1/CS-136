/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;
import java.util.*;

/**
 *
 * @author mag765
 */
public class Berserker extends Contestent{
    public Berserker(){
        // hitpoints remain static at 35
        hitPoints = 35;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription(){
        // checks aliveness, then returns appropriate strings
        if (alive){
            return ("A raging Berserker" + "(" + hitPoints + ")");
        }
        else{
            return ("A slain Berserker");
}
}
    public int attack(){
        // simply returns the static 20 damage a berserker always does
        int Damage = 20;
        return Damage;
}
    public void takeDamage(int damageValue, boolean fire, boolean slashing, boolean smashing){
        // alters the value of the damage taken based on boolean values passed in
        if (fire){
            damageValue = damageValue / 2;
        }
        if (slashing){
            damageValue = damageValue * 2;
        }
        // subtracts damage from HP
        hitPoints -= damageValue;
        // evaluates aliveness based on HP
        if (hitPoints <= 0){
            alive = false;
        }
        }
    // important for descriptions
    public int getHP(){
        return hitPoints;
    }
     }
