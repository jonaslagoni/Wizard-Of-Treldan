/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_test;


/**
 *
 * @author Mathias
 */
public class Fight {
    
    private Player player = new Player();
    private Monster monster = new Monster();
    private int playerRoll;
    private int monsterRoll;
    private int damage;
    private boolean isDone;
    private String winner;
    
    /**
     * 
     * @param winner
     * @param player
     * @param monster
     * @param playerRoll
     * @param monsterRoll
     * @param damage
     * @param isDone 
     */
    public Fight(String winner, Player player, Monster monster, int playerRoll, int monsterRoll, int damage, boolean isDone){
        this.winner = winner;
        this.player = player;
        this.monster = monster;
        this.monsterRoll = monsterRoll;
        this.playerRoll = playerRoll;
        this.damage = damage;
        this.isDone = isDone;
    }
    
    /**
     * 
     * @return 
     */
    public Player getPlayer(){
        return player;
    }
    
    /**
     * 
     * @return 
     */
    public String winner(){
        return winner;
    }
    
    /**
     * 
     * @return 
     */
    public Monster getMonster(){
        return monster;
    }
    
    /**
     * 
     * @return 
     */
    public int getMonsterRoll(){
        return monsterRoll;
    }
    
    /**
     * 
     * @return 
     */
    public int getPlayerRoll(){
        return playerRoll;
    }
    
    
    /**
     * 
     * @return 
     */
    public int getDamage(){
        return damage;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isDone(){
        return isDone;
    }
    
    
    public String toString(){
        return winner + " dealt " + damage + " damage.";
    }
}
