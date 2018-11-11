/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.models;

/**
 * This class is responsible for saving the generations in a vector
 * 
 *@version 09/11/2018
 * @author Kevin Trejos/Jose Ignacio Zamora/Edwin Molina
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
    
    /**
     * Declaration: public String[] insertVector(String matrixGenerations)
     * This method inserts a matrix into a vector
     * @param matrixGenerations is the matrix to insert
     * @return vector with inserted matrix
     */
    public String[] insertVector(String matrixGenerations){
        if (matrixGenerations != null) {
            generations[generationsInserts] = matrixGenerations;
            generationsInserts +=1;
            return generations;
        }
        return null;
    }  
    
    /**
     * Declaration: public String getVector(int index)
     * This method receives the position that the user wants and returns it
     * @param index desired position
     * @return the index to show
     */
    public String getVector(int index){
        String stringVector;
        stringVector = generations[index];
        return  stringVector;   
    }
}

