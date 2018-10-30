/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

/**
 * This class represents the cells of the game
 * 
 *@version 29/10/2018
 * @author Kevin Trejos
 */
public class Grid {
    private Cell[][] cells;
    private int generation = 0;

    /**
     * Declaration public Grid(int size)
     * This is a constructor method that initializes the grid
     * With the size that the player wants
     * @param size is the size of the grid
     */
    public Grid(int size) {
        if (size >= 8 && size <= 20) {
            this.cells = new Cell[size][size];
        }
    }
    
    public void randomCells(){
        int random;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < 10; j++) {
                
            }
            random = (int)(Math.random()* 2) + 1;
            if (random == 2) {
               Cell cell1 = new Cell(true);
               cells[i][i] = cell1;
            }else{
               Cell cell2 = new Cell(false);
               cells[i][i] = cell2;
            }
        }
    }
}
