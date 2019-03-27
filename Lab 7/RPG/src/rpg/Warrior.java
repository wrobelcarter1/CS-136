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
public class Warrior extends Contestent{
    
    public Warrior() {
    hitPoints = generator.nextInt(30) + 20;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription(){
        // evaluates aliveness, generates appropriate string
        if (alive){
            return ("A disciplined Warrior" + "(" + hitPoints + ")");
        }
        else{
            return ("A slain Warrior");
        }
    }
    public int attack(){
        // deals between 10 and 16 damage
        int Damage = generator.nextInt(16) + 10;
        return Damage;
    }
    public void takeDamage(int damageValue, boolean fire, boolean slashing, boolean smashing){
        // generates random number between 0 and 3, if it equals 3, then damage is negated if it's
        // smashing or slashing
        int dodgeChance = 3;
        int dodgeRoll = generator.nextInt(3);
        if (smashing || slashing){
            if(dodgeChance == dodgeRoll){
                damageValue = 0;
            }
        }
        // subtracts damage from HP
        hitPoints -= damageValue;
        // evaluates aliveness
        if (hitPoints <= 0)
            alive = false;
        
    }
    // important for descriptors
    public int getHP(){
        return hitPoints;
}
}
