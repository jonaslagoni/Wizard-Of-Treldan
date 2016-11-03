/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_test;

/**
 *
 * @author Mads
 */
public class Score {
    
    private int score;
    private int time;
    private String name;
    
    public Score (String name, int score, int time) {
        this.name = name;
        this.score = score;
        this.time = time;
    }
    
    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
}
