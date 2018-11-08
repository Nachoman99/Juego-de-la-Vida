/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.models;

import juegodelavida.*;
import juegodelavida.graphicInterface.GraphicInterface;

/**
 *
 * @author Kevin Trejos
 */
public class Generations1 {
    private Grid[] generations = new Grid[20];
    
    public Generations1() {
    }

    public Generations1(Grid[] generations) {
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
    
    
}
