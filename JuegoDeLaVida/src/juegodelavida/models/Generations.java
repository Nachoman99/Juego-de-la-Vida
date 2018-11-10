/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.models;

import java.util.Arrays;
import juegodelavida.*;

/**
 *
 * @author Kevin Trejos
 */
public class Generations {
    private String[] generations = new String[20];
    int generationsInserts = 0;
    
    public Generations() {
    }

    public Generations(String[] generations) {
        this.generations = generations;
    }

    public String[] getGenerations() {
        return generations;
    }

    public void setGenerations(String[] generations) {
        this.generations = generations;
    }

    @Override
    public String toString() {
        return "Generations{" + "generations=" + generations + '}';
    }
    
    public String[] insertVector(String matrixGenerations){
        if (matrixGenerations != null) {
            generations[generationsInserts] = matrixGenerations;
            generationsInserts +=1;
            return generations;
        }
        return null;
    }     
}

