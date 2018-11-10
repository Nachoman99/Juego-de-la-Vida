/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.models;

import juegodelavida.*;

/**
 *
 * @author Kevin Trejos
 */
public class Generations {
    Grid grid;
    private Grid[] generations = new Grid[20];
    
    public Generations() {
    }

    public Generations(Grid[] generations) {
        this.generations = generations;
    }

    public Grid[] getGenerations() {
        return generations;
    }

    public void setGenerations(Grid[] generations) {
        this.generations = generations;
    }

    @Override
    public String toString() {
        return "Generations{" + "generations=" + generations + '}';
    }
    
    public Grid[] insertVector(Grid matrixGenerations){
        int generationsInserts = 0;
        for (int i = 0; i < generations.length; i++) {
            if (generations[i] != null) {
                generationsInserts += 1;
            }else if (generations[i] == null) {
                generations[generationsInserts -1] = matrixGenerations;
            } 
        }
        return generations;
    } 
}

