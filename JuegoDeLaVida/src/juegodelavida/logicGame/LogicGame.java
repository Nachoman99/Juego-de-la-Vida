/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.logicGame;

import juegodelavida.models.Cell;
import juegodelavida.logicGame.Grid;
import juegodelavida.models.Generations;
import juegodelavida.graphicInterface.GraphicInterface;


/**
 *
 * @author Kevin Trejos
 */
public class LogicGame {
    public void startGame(){
        GraphicInterface windows = new GraphicInterface();
        Generations generations = new Generations();
        windows.presentation();
        int size = windows.sizeMatrix();
        Grid grid = new Grid(size);
        int desitionRandomOrInsert = windows.randomInsert();
        if (desitionRandomOrInsert == 0) {
            grid.randomCells();
            boolean continuar = true;
            boolean enterGenerationsWindow = false;
            int maximoGen =0;
            while(continuar){
                if(maximoGen != 20){
                    int result = windows.randomSelection(maximoGen, grid.stringMatrix());
                    if(result ==0 ){
                        grid.hasLife();
                        maximoGen += 1;
                        generations.insertVector(grid.getStringMatrix());
                    }else if(result == 1){
                        continuar = false;
                        enterGenerationsWindow = true;
                    }else if(result == 2){
                        continuar = false;
                    }
                }else{
                    windows.randomSelection(maximoGen, grid.stringMatrix());
                    continuar = false;
                } 
            }
            while (enterGenerationsWindow) {                
                
            }
            
            
            
            
            
            
            
            
            
            
            
        }else if (desitionRandomOrInsert == 1) {
            
        }
    }

}
