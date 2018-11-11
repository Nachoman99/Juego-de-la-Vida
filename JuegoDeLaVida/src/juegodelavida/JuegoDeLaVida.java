/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

import juegodelavida.logicGame.LogicGame;

/**
 * This class is the main, where the grid, the graphic interface and other elements are implemented
 * 
 * @author Jose Ignacio Zamora/Kevin Trejos/Edwin Molina
 * @version 29/10/2018
 */
public class JuegoDeLaVida {
    public static void main(String[] args) {
        LogicGame logic = new LogicGame();
        logic.startGame();
    }
}
