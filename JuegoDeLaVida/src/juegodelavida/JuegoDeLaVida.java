/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

import javax.swing.JOptionPane;
import juegodelavida.models.Generations;
import juegodelavida.models.Grid;
import juegodelavida.graphicInterface.GraphicInterface;
import java.util.Arrays;


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
        grid.insertPosition(1, 1, true);*/
        //grid.hasLife();
        GraphicInterface inte = new GraphicInterface();
        //inte.generations(grid.stringMatrix());
        //grid.hasLife();
        //inte.generations(grid.stringMatrix());
        /*boolean terminar = true;
        while(terminar){
            int[] position = new int[1];
            position = inte.insertPosition(8, grid.stringMatrix());
            if(position == null){
                terminar = false;
            }else{
              int x = position[0];
              int y = position[1];
              grid.insertPosition(x, y, true);  
            }
            
        }*/
        System.out.println(inte.insertPosition(8, grid.stringMatrix()));
        
        //System.out.println(inte.columnInsert(8));
        
        //inte.showGrid(8);
        //inte.insertPosition(8);
        //inte.presentation();
        //int size = inte.sizeDecisition();
        //int generations = inte.generations();
        //int desition = inte.randomInsert();
        //System.out.println("size=" +size);
        //System.out.println("Random o Insertar= " + desition);
        //System.out.println(grid.getStringMatrix());
        
        //String gridString = inte.showGrid(size);
        //System.out.println(gridString);
        //int insert = inte.insertPosition(size, gridString);
        //System.out.println("isnert= " + insert);
        /*
        tira 0 si esa random y 1 si quiere inserta a la hora de hacer la logica se basa en esos numeros
        */
        
        
        /*grid.insertPosition(0, 2, true);
        grid.insertPosition(1, 2, true);
        grid.insertPosition(1, 3, true);
        grid.insertPosition(0, 6, true);
        grid.insertPosition(1, 1, true);
        grid.insertPosition(1, 1, true);*/
        
       /* grid.insertPosition(0, 0, true); 
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
        
       
         grid.hasLife();
        System.out.println(grid.getStringMatrix());       
        //System.out.println(grid.getStringMatrix());
        
        //grid.hasLife();
        //System.out.println(grid.getStringMatrix());
    */}
}
//