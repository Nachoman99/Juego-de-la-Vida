/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

/**
 * This class represents the grid of the game
 * 
 *@version 29/10/2018
 * @author Kevin Trejos
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
