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
