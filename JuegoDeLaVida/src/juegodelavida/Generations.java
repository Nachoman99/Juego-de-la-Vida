/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

/**
 *
 * @author Kevin Trejos
 */
public class Generations {
    private Grid[] generations;

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
    
    
}
