/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_A1;

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
    /**
     * 
     * @param player
     * @param monster 
     */
    public Combat(Player player, Monster monster){
        this.monster = monster;
        this.player = player;
    }
    
    /**
     * 
     * @return 
     */
    public List<Fight> AFight() {
        int damageDealt;
        List<Fight> fightSystem = new ArrayList();
        
        // Someone has to die for combat to end
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            int rollPlayer = (int) (Math.random()* playerDice) +1;
            int rollMonster = (int) (Math.random()* monsterDice) +1;
            // start of monster damage formulae
                if (rollMonster > rollPlayer) {
                    damageDealt = rollMonster - rollPlayer;
                    damageDealt = (int) Math.round((monster.getAttValue()/player.getDefValue()) * damageDealt);
                    if (damageDealt <= 0) {
                        damageDealt = 0;
                    }
                    else {
                        player.setDamage(damageDealt);
                        
                        if(player.getHealth() > 0) {
                            fightSystem.add(new Fight(monster.getMonsterName(), player, monster, rollPlayer, rollMonster, damageDealt, false));
                        }else{
                            fightSystem.add(new Fight(monster.getMonsterName(), player, monster, rollPlayer, rollMonster, damageDealt, true));
                        }
                    }
                }
                // start of player damage formulae
                else if (rollPlayer > rollMonster) {
                    damageDealt = rollPlayer - rollMonster;                  
                    damageDealt = (int) Math.round((player.getAttValue()/monster.getDefValue())* damageDealt);
                    if (damageDealt < 0) {
                        damageDealt = 0;
                    }
                    else {
                        monster.setDamage(damageDealt);
                        
                        if(monster.getHealth() > 0) {
                            fightSystem.add(new Fight(player.getPlayerName(), player, monster, rollPlayer, rollMonster, damageDealt, false));
                        }else{
                            fightSystem.add(new Fight(player.getPlayerName(), player, monster, rollPlayer, rollMonster, damageDealt, true));
                        }
                    }
                }
                // if player and monster roll the same it is a tie
                else {
                    damageDealt = 0;
                }
        }
        return fightSystem;
        
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
    
    /**
     * 
     * @return monster drop gold
     */
    public int getGoldDrop(){
        return monster.getGoldDrop();
    }
    
    /**
     * 
     * @return monster drop items
     */
    public List<Item> getItemDrop() {
        return monster.getItemDrop();
    }
}
