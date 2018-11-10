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
    int generationsInserts = 0;
    
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
        if (matrixGenerations != null) {
            generations[generationsInserts] = matrixGenerations;
            generationsInserts +=1;
            return generations;
        }
        return null;
    } 
}

