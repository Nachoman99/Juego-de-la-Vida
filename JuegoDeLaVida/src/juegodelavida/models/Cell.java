/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.models;

/**
 * This class represents the cells of the game
 * 
 *@version 29/10/2018
 * @author Kevin Trejos/Jose Ignacio Zamora/Edwin Molina
 */
public class Cell {
    private int life;
    
    public Cell() {
        this(1);
    }

    public Cell(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "Cell{" + "life=" + life + '}';
    }
}
