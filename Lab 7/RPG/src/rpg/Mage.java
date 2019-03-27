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
public class Mage extends Contestent{
    public Mage(){
        // generates HP between 10 and 60
        hitPoints = generator.nextInt(60) + 10;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription(){
        // checks aliveness, returns appropriate string
        if (alive){
            return ("A wild Mage" + "(" + hitPoints + ")");
        }
        else{
            return ("A dead Mage");
}
}
    public int attack(){
        // does between 0 and 5 damage, generates randomly
        int damage = generator.nextInt(6);
        return damage;
    }
    @Override
    public void takeDamage(int damageValue, boolean fire, boolean slashing, boolean smashing){
        // subtracts damage from HP
        hitPoints -= damageValue;
        // evaluates aliveness
        if (hitPoints <= 0){
            alive = false;
        }
    }
    // important for descriptors
    public int getHP(){
        return hitPoints;
    }
}