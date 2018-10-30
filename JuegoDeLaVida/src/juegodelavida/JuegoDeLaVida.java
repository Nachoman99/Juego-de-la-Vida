/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

/**
 * This class is the main, where the grid, the graphic interface and other elements are implemented
 * @author Jose Ignacio Zamora
 * @version 29/10/2018
 */
public class JuegoDeLaVida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grid grid = new Grid(10);
        grid.randomCells();
    }
    
}
