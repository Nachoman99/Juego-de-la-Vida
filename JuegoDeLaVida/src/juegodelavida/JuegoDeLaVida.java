/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

import javax.swing.JOptionPane;





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
        /*grid.insertPosition(0, 2, true);
        grid.insertPosition(1, 2, true);
        grid.insertPosition(1, 3, true);
        grid.insertPosition(0, 6, true);
        grid.insertPosition(1, 1, true);
        grid.insertPosition(1, 1, true);*/
        
        grid.insertPosition(0, 0, true); 
        //grid.insertPosition(0, 1, true);
        grid.insertPosition(1, 0, false);
        grid.insertPosition(1, 1, true);
        
        
        grid.insertPosition(0, 7, true);    
        grid.insertPosition(0, 6, true);
        grid.insertPosition(1, 6, true);
        grid.insertPosition(1, 7, true);
        
        
        grid.insertPosition(7, 0, true);
        grid.insertPosition(7, 1, true);
        grid.insertPosition(6, 0, true);
        grid.insertPosition(6, 1, true);
        
        
        grid.insertPosition(7, 7, true);
        grid.insertPosition(6, 7, true);
        grid.insertPosition(6, 6, true);
        grid.insertPosition(7, 6, true);
        
        grid.insertPosition(0, 2, true);
        
        grid.insertPosition(6, 3, true);
        grid.insertPosition(6, 4, true);
        grid.insertPosition(7, 3, true);
        //grid.insertPosition(1, 3, true);
       // grid.insertPosition(1, 4, true);
        
        grid.insertPosition(3, 0, true);
        grid.insertPosition(3, 1, true);
        grid.insertPosition(4, 0, true);
        //grid.randomCells();
        //prueba  del centro
        grid.insertPosition(3, 3, true);
        grid.insertPosition(2, 3, true);
        grid.insertPosition(2, 4, true);
        grid.hasLife();
        System.out.println(grid.getStringMatrix());
        //System.out.println(grid.getStringMatrix());
        
        //grid.hasLife();
        //System.out.println(grid.getStringMatrix());
    }
}
