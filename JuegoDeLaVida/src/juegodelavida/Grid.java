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
    
    /**Revisar este método ya que imprime muchas cells,creo que hay que quitar un for
     * Declaration: public void randomCells()
     * This method generates cells in random positions of the grid
     */
    public void randomCells(){
        int random;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                random = (int)(Math.random()* 2) + 1;
                if (random == 2) {
                    Cell cell1 = new Cell(true);
                    cells[i][j] = cell1;
                }else{
                    Cell cell2 = new Cell(false);
                    cells[i][j] = cell2;
                }
            }
        }
    }
    
    /**Falta completar este método para hacerlo con click, por lo tanto no está comentado 
     * correctamente
     * 
     * @param position 
     */
    public void insertPosition(int position){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[i][j] != null) {
                    Cell cell01 = new Cell(true);
                    cells[i][j] = cell01;
                }else{
                    System.err.println("Digite una posición válida");
                }
            }
        }
    }
    
    public void enteredPositions(){
        
    }
}
