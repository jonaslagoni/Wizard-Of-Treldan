/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

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
     * @param winner String winner of the round
     * @param player the player object
     * @param monster Monster object
     * @param playerRoll what the player rolled
     * @param monsterRoll what the monster rolled
     * @param damage what the damage was
     * @param isDone is the match over
     */
    public Fight(String winner, Player player, Monster monster, int playerRoll, int monsterRoll, int damage, boolean isDone) {
        this.winner = winner;
        this.player = player;
        this.monster = monster;
        this.monsterRoll = monsterRoll;
        this.playerRoll = playerRoll;
        this.damage = damage;
        this.isDone = isDone;
    }

    /**
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return String winner
     */
    public String winner() {
        return winner;
    }

    /**
     * @return Monster
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * @return Monster roll
     */
    public int getMonsterRoll() {
        return monsterRoll;
    }

    /**
     * @return Player roll
     */
    public int getPlayerRoll() {
        return playerRoll;
    }

    /**
     * @return damage done
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @return is the match over
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "** " + winner + " dealt " + damage + " damage.";
    }
}
