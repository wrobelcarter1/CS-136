package rpg;

import java.util.ArrayList;
import java.util.*;

class Arena {

    public Arena() {
    }
    // creates an arrayLisrt to store the contestents in
    ArrayList<Contestent> contestentList = new ArrayList<Contestent>(5);
    // creates new placeholder contestent to populate the contestent list
    Contestent placeholder = new Contestent();
    // this is important in the add method
    public int addIndex = 0;
    // We were having problems when compiling without filling the arraylist with dummy contestents first
    // like there were indexing errors, so we figured that filling it with placeholders and then replacing
    // them later would be the best solution to this problem, and lo and behold it somehow works
    // it kinda makes the add method janky looking though
    

    public void add(Contestent contestent) {
        // uses addIndex to determine if the placeholders need to be added
        // if nothing else is added then the placeholders are put in
        if(addIndex == 0){
            contestentList.add(placeholder);
            contestentList.add(placeholder);
            contestentList.add(placeholder);
            contestentList.add(placeholder);
            contestentList.add(placeholder);
            contestentList.add(placeholder);
        }
        // if addIndex isn't 0, then the contents of the index of the contestent list (a placeholder) is replaced with the contestent being added
        contestentList.set(addIndex, contestent);
        // increments the add index
        addIndex += 1;
        // seriously I know I don't have a lot of programming experience but this is the jankiest
        // solution to a problem I've ever had. This isn't even an add method anymore it's a replace method
    }

    public void playRound() {
        String attackDescription = "";
        Random generator = new Random();
        //initializes the loop that iterates through the contestents
        for (Contestent contestent : contestentList){
        // checks if the contestent is alive, if not, they don't attack
        if(contestent.checkIfAlive()){
            // initializes targeting logic for berserkers
            if(contestent instanceof Berserker){
                // randomly chooses a target for the berserker to attack
                Contestent target = contestentList.get(generator.nextInt(5));
                // if the target isn't alive, target keeps getting updated with new contestents
                // when an alive one is finally chosen, then they are the target
                while(!(target.checkIfAlive())){
                    target = contestentList.get(generator.nextInt(5));
                }
                // runs 20 smashing damage through the unique takeDamage methods for each
                // contestent class
                int damageToDeal = contestent.attack();
                attackDescription += target.getDescription() + "takes " + damageToDeal + " Smashing damage from " + contestent.getDescription() + "\n";
                target.takeDamage(damageToDeal, false, false, true);
                
            }
            // checks if the contestent is a Warrior, contains targeting logic
            if(contestent instanceof Warrior){
                // initializes the warrior's target
                Contestent warriorTarget = new Contestent();
                // all this checks who has the highest HP
                // this line specifically creates an arraylist for HP values
                ArrayList<Integer> HPList = new ArrayList<Integer>();
                // populates HPList with the HP values
                for(Contestent character : contestentList){
                    HPList.add(character.getHP());
                }
                // finds the max value of the HPList and sets a variable equal to it
                int maxHP = Collections.max(HPList);
                // this is to choose the warrior's target based on HP
                for(Contestent target : contestentList){
                    // when the HP value correlating to the highest health contestent is found
                    // they become the warrior's target
                    if(maxHP == target.getHP()){
                        warriorTarget = target;
                    }
                    // all of this is to avoid the warrior attacking himself
                    if(warriorTarget == contestent){
                        // if the warrior's HP is the highest, then his HP value is removed from HPList
                        int maxHPIndex = HPList.indexOf(maxHP);
                        HPList.remove(maxHPIndex);
                        // maxHP is updated with new highest HP value
                        maxHP = Collections.max(HPList);
                        // this runs back through the warrior targeting logic
                        for(Contestent target2 : contestentList){
                        if(target2.getHP() == maxHP){
                            warriorTarget = target2;
                        }
                    }
                    }
                }
                // similar to beserker, warrior just deals random slashing damage
                int damageToDeal = contestent.attack();
                // generates the string for the attacks and actually deals the damage
                attackDescription += warriorTarget.getDescription() + "takes " + damageToDeal + " slashing damage from " + contestent.getDescription() + "\n";
                warriorTarget.takeDamage(damageToDeal, false, true, false);
            }
            // checks if contestent is a mage
            if(contestent instanceof Mage){
                // creates an arraylist of the living contestants
                ArrayList<Contestent> aliveList = new ArrayList<Contestent>();
                for(Contestent areYouAlive : contestentList){
                    if(areYouAlive.checkIfAlive()){
                        aliveList.add(areYouAlive);
                    }
                }
                // iterates through alivelist to deal damage
                for(Contestent contestentToDamage : aliveList){
                    int damageToDeal = contestent.attack();
                    // generates description of attack and runs value through takeDamage
                    attackDescription += contestentToDamage.getDescription() + "takes " + damageToDeal + " fire damage from " + contestent.getDescription() + "\n";
                    contestentToDamage.takeDamage(damageToDeal, true, false, false);
                }
            }
    }
    }
    // prints out the string generated by everyone attacking
    System.out.println(attackDescription);
    }

    public String getDescription() {
        // the description will always start with this
        String arenaDescription = "In the Arena... \n";
        // loops through list of contestents and if they're alive then they have their HP displayed
        // if not they're declared dead
        for(Contestent contestent : contestentList){
            // calls subclass getDescription
            arenaDescription += contestent.getDescription();
            arenaDescription += "\n";
        }
        // returns the string generated by the contestents
        return arenaDescription;
    }

    public Contestent getWinner() {
        // initialized to check number alive
        int checksum = 0;
        //is set equal to the last one alive's index
        int winnerIndex = 0;
        // creates palceholder contestent to be overwritten with possible winner
        Contestent possibleWinner = new Contestent();
        // checks if the possible winner's HP is greater than 0
        for(Contestent maybeVictor : contestentList){
            possibleWinner = maybeVictor;
            // if HP > 0, then checksum increments to inidcate there's a number of living contestents
            if(possibleWinner.getHP() > 0){
                checksum += 1;
                // winnerIndex updated with index of the currently evaluated contestent
                winnerIndex = contestentList.indexOf(possibleWinner);
            }
        }
        // in order for this to return a victor, checksum has to equal 1
        if(checksum == 1){
            // simply returns the winner with the same index as the value of winnerIndex
            return contestentList.get(winnerIndex);
        }
        // if everyone dies at once, checksum will equal 0 and a random berserker wins
        if(checksum == 0){
            return contestentList.get(0);
        }
        // if more than 1 contestent is alive then null is returned
        else{
            return null;
        }
    }

    // Private
    private void checkVictor() {
        // pulls the winner from getWinner and sets a random contestent object equal to it
        Contestent winner = getWinner();
        // all these do is check which subclass the winner is a part of and spits out a specialized string
        if(winner instanceof Warrior){
            System.out.println("a Disciplined Warrior" + "(" + winner.getHP() + ")");
        }
        if(winner instanceof Mage){
            System.out.println("a Wild Mage" + "(" + winner.getHP() + ")");
        }
        if(winner instanceof Berserker){
            System.out.println("a Raging Berserker" + "(" + winner.getHP() + ")");
        }
    }

}
