/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.models;

import juegodelavida.*;

/**
 * This class represents the cells of the game
 * 
 *@version 29/10/2018
 * @author Kevin Trejos
 */
public class Grid {
    private Cell[][] cells;
 

    /**
     * Declaration public Grid(int size)
     * This is a constructor method that initializes the grid
     * With the size that the player wants
     * @param size is the size of the grid
     */
    public Grid(int size) { 
        Cell cell1 = new Cell(1);
        if (size >= 8 && size <= 20) {
            this.cells = new Cell[size][size];
   
        }
        for(int i = 0; i < cells.length;i++){
            for(int j = 0; j < cells.length;j++){
                cells[i][j] = cell1;

            }    
        }
    }
    
    public  String getStringMatrix(){ 
        String imprimir = "";
        for(int i = 0; i<cells.length; i++){
            for(int j = 0; j<cells[i].length; j++){
               imprimir  =imprimir  + cells[i][j] + " "; 
            }     
            imprimir  =imprimir + "\n"; 
        }
        return imprimir ;
    }
} 




