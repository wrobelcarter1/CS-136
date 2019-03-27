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
public class Contestent {
    // initliazing important variables that the other classes use
    public Random generator = new Random();
    public boolean alive = true;
    public int hitPoints;
    public boolean Slashing = false;
    public boolean Smashing = false;
    public boolean Fire = false;
    public String contestentType = "";

    // important for checking the aliveness of the contestent
    public int getHP(){
    return hitPoints;
    }
    // overwritten in subclasses
    public String getDescription(){
        return "";
    }
    // overwritten in subclasses
    public void takeDamage(int damageValue, boolean smashing, boolean slashing, boolean fire){
    }
    // overwritten in subclasses
    public int attack(){
        return 0;
    }
    // the alive variable is altered in the takeDamage methods in the subclasses
    public boolean checkIfAlive(){
        return alive;
    }
}