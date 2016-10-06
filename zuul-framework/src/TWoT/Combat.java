/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lagoni
 */
public class Combat {
    private Player player;
    private Monster monster;
    private int playerDice = 40;
    private int monsterDice = 40;
    public Combat(Player player, Monster monster){
        this.monster = monster;
        this.player = player;
    }
    
    public List<String> fight(){
        List<String> combatText = new ArrayList();
        while(player.getHealth() > 0 && monster.getHealth() > 0){
            int playerRoll = (int)((Math.random()*playerDice)+1);
            int monsterRoll = (int)((Math.random()*monsterDice)+1);
            combatText.add("Player rolled: " + playerRoll);
            combatText.add("Monster rolled: " + monsterRoll);
            if(playerRoll > monsterRoll){
                int baseDamage = playerRoll-monsterRoll;
                combatText.add("You won.");
                int damage = (int)Math.round((player.getAttValue()/monster.getDefValue())*baseDamage);
                monster.setDamage(damage);
                combatText.add("Monster took " + damage + " damage");
            }else if(monsterRoll > playerRoll){
                int baseDamage = monsterRoll-playerRoll;
                combatText.add("Monster won.");
                int damage = (int)Math.round((monster.getAttValue()/player.getDefValue())*baseDamage);
                player.setDamage(damage);
                combatText.add("You took " + damage + " damage");
            }
        }
        if(player.getHealth() < 0){
            combatText.add("You died!");
        }else if(monster.getHealth() < 0){
            combatText.add("The monster died.");
        }
        return combatText;
    }
    
    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the monster
     */
    public Monster getMonster() {
        return monster;
    }
}
