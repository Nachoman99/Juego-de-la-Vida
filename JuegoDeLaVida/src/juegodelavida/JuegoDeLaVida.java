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
        Grid grid = new Grid(8);
        grid.insertPosition(1, 1, 2);
        grid.insertPosition(0, 1, 2);
        grid.insertPosition(1, 0, 2);
      
        System.out.println(grid.getStringMatrix());
        
        grid.hasLife();
        System.out.println(grid.getStringMatrix());
    }
}
