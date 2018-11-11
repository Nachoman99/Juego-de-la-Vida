/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.logicGame;

import juegodelavida.models.Generations;
import juegodelavida.graphicInterface.GraphicInterface;

/**
 * In this class all the logical procedure of the game is done
 * 
 *@version 10/11/2018
 * @author Kevin Trejos/Jose Ignacio Zamora/Edwin Molina
 */
public class LogicGame {

    public LogicGame() {
    }
    
    /**
     * Declaration: public void startGame()
     * This method starts the game and gives the order of the 
     * windows and their respective processions
     */
    public void startGame(){
        GraphicInterface windows = new GraphicInterface();
        Generations generations = new Generations();
        windows.presentation();
        int size = windows.sizeMatrix();
        Grid grid = new Grid(size);
        int generationAmount = 0;
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
                        generationAmount += 1;
                        generations.insertVector(grid.stringGenerations());
                    }else if(result == 1){
                        continuar = false;
                        enterGenerationsWindow = true;
                    }
                }else{
                    windows.randomSelection(maximoGen, grid.stringMatrix());
                    continuar = false;
                } 
            }
            while (enterGenerationsWindow) {                
                int generationsOrClose = windows.generations1(generationAmount);
                if(generationsOrClose == 0){
                    enterGenerationsWindow = false;
                }else if(generationsOrClose == -1){
                    
                }else{
                   windows.showGenerations(generationsOrClose, generations);
                } 
            }     
        }else if (desitionRandomOrInsert == 1) {
            boolean insertValues = true;
            boolean insertGenerations = false;
            boolean enterGenerationsWindow = false;
            while(insertValues){
                int[] position = new int[1];
                position = windows.insertPosition(size, grid.stringMatrix());
                if(position == null){
                    insertValues = false;
                    insertGenerations = true;
                }else{
                  int x = position[0];
                  int y = position[1];
                  grid.insertPosition(x, y, true);
                }
            }
            while (insertGenerations){
                int maximoGen =0;
                if(maximoGen != 20){
                    int nextGeneration = windows.generations(generationAmount, grid.stringMatrix());
                    if(nextGeneration == 0){
                        grid.hasLife();
                        generationAmount += 1;
                        maximoGen += 1;
                        generations.insertVector(grid.stringGenerations());
                    }else if(nextGeneration == 1){
                        insertGenerations = false;
                        enterGenerationsWindow = true;
                    }
                }
            }
            while (enterGenerationsWindow) {                
                int generationsOrClose = windows.generations1(generationAmount);
                if(generationsOrClose == 0){
                    enterGenerationsWindow = false;
                }else if(generationsOrClose == -1){
                    
                }else{
                   windows.showGenerations(generationsOrClose, generations);
                } 
            }  
        }
    }
}
