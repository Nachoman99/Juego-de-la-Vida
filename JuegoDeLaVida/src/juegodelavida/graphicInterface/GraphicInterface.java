/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.graphicInterface;

import javax.swing.JOptionPane;
import juegodelavida.models.Generations;

/**
 * In this class, window management will be given
 * 
 *@version 30/10/2018
 * @author Kevin Trejos/Jose Ignacio Zamora/Edwin Molina
 */
public class GraphicInterface {
    
    public GraphicInterface() {
    }
    
    /**
     * Declaration: public static String getStringMatrix(String[][] matrix1)
     * Convert the matrix to a string array
     * @param matrix1 matrix to convert
     * @return the converted matrix
     */
    public static String getStringMatrix(String[][] matrix1){ 
        String imprimir = "";
        for(int i = 0; i<matrix1.length; i++){
            for(int j = 0; j<matrix1[i].length; j++){
               imprimir  =imprimir  + matrix1[i][j] + " "; 
                     
            }     
            imprimir  =imprimir + "\n"; 
        }
        return imprimir ;
    }

    /**
     * Declaration: public void presentation()
     * In this method, the creators of the game are presented
     */
    public void presentation(){
        JOptionPane.showMessageDialog(null, "        JUEGO DE LA VIDA     "+"\n"+"Integrantes: "+"\n"+"Kevin Trejos B87902"+"\n"+"Edwin Molina"+
                "Carne Ed"+"\n"+"Jose Zamora B78541", "Juego de La Vida", JOptionPane.INFORMATION_MESSAGE, null);
    }
    
    /**
     * Declaration: public int sizeMatrix()
     * This method creates a window where the user is 
     * asked about the size of the matrix
     * @return the size that the user decided
     */
    public int sizeMatrix(){
        int decisition;
        String result;
        String[] position = {"8","9","10","11","12","13","14","15","16","17","18","19","20"};
        result = (String)JOptionPane.showInputDialog(null, "¿De cuanto quiere su cuadricula?", "Filas y Columnas", JOptionPane.QUESTION_MESSAGE, null,  position, "8");
        decisition = Integer.parseInt(result);
        return decisition; 
    }
    
    /**
     * Declaration: public int generations(int generationNumber, String[][] generation1)
     * In this method, a window is created where you can choose between
     * seeing the generations that have passed or seeing the next generation
     * @param generationNumber A counter of the total number of generations entered
     * @param generation1 The matrix to show
     * @return The user's choice
     */
    public int generations(int generationNumber, String[][] generation1){
        int desition;
        if(generationNumber == 20){
            String[] buttons ={"Ver generaciones anteriores"};
            desition = JOptionPane.showOptionDialog(null, getStringMatrix(generation1) + "Se llego al maximo de generaciones, selecciones ver generaciones o terminar el juego", "GENERACIONES", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
            return desition;
        }else{
           String[] buttons ={"Siguiente", "Ver generaciones anteriores"};
            desition = JOptionPane.showOptionDialog(null, getStringMatrix(generation1) + "Seleccione alguna opción", "GENERACIONES", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);  
            return desition; 
        }
    }
     
    /**
     * Declaration: public int generations1(int generations)
     * In this method a window is created where the generation 
     * that the user wants to see is decided
     * @param generations The number of created generations
     * @return Returns the user's decision
     */
    public int generations1(int generations){
        int decisition;
        String[] buttons ={"Salir","Aceptar" };
        int btDecision = JOptionPane.showOptionDialog(null,"Presione aceptar para ver generación o presione salir para terminar juego","Juego", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
        if (btDecision == 0) {
            JOptionPane.showMessageDialog(null, "Gracias por jugar");
            return btDecision;
        }else{
            String result;
            String[] position = new String[generations];
            int index = 1;
            int index2 = 0;
            for (int i = 1; i <= generations; i++) {
                position[index2] = String.valueOf(index);
                index2 += 1;
                index += 1;
            }
            result = (String)JOptionPane.showInputDialog(null,"Elija una generación a ver y por favor no tocar el boton cancelar (si lo toca no realizara nada)", "Ver generaciones", JOptionPane.INFORMATION_MESSAGE , null,  position, "1");
            if (result == null) {
              decisition = -1;
              JOptionPane.showMessageDialog(null, "Por Favor no tocar el cancelar");
            }else{
              decisition = Integer.parseInt(result); 
            }
            return decisition;
        }
    }
    
    /**
     * Declaration: public void showGenerations(int generationsToShow, Generations generations)
     * This method shows a window with the chosen generation
     * @param generationsToShow generations to show
     * @param generations a vector with generations
     */
    public void showGenerations(int generationsToShow, Generations  generations){
        JOptionPane.showMessageDialog(null, "GENERACION NUMERO "+generationsToShow + "\n"+generations.getVector(generationsToShow-1));
    }
    
    /**
     * Declaration: public int randomInsert()
     * This method displays a window with the option of random positions or positions manually
     * @return the decision of the user
     */
    public int randomInsert(){
    String[] buttons ={"Posiciones Aleatorias", "Ingresar posiciones a gusto"};
    int desition = JOptionPane.showOptionDialog(null, "Seleccione alguna opción", "Seleccion de Relleno", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
    return desition;
    }
    
    /**
     * Declaration: public int[] insertPosition(int size, String[][] initialMatrix)
     * this method displays a window where the user can insert a position or the option to continue with the game
     * @param size size of columns and rows
     * @param initialMatrix matrix to show with entered positions
     * @return positions to enter the matrix
     */
    public int[] insertPosition(int size, String[][] initialMatrix){ 
        int desition;
        int row;
        int column;
        String[] buttons = {"Insertar una nueva posición", "Continuar"};
        desition = JOptionPane.showOptionDialog(null, getStringMatrix(initialMatrix) + "Seleccione una opción", "INSERTAR POSICIONES", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
        if (desition == 0) {
            row = rowsInsert(size);
            column = columnInsert(size);
            if(row != -1 && column != -1){
               int[] positions = {row,column}; 
               return positions; 
            }
        }
        return null;
    }
    
    /**
     * Declaration: private int rowsInsert(int size)
     * It shows a window with the rows to insert in the matrix
     * @param size number of options to show
     * @return the positions chosen by the user
     */
    private int rowsInsert(int size){
        int decisition;
        String result;
        String[] position = new String[size];
        int index = 0;
        for (int i = 0; i < (size); i++) {
            position[index] = String.valueOf(index);
            index += 1;
        }
        result = (String)JOptionPane.showInputDialog(null,"¿En cuál fila desea ingresar un valor?", "Ingreso de posiciones", JOptionPane.INFORMATION_MESSAGE , null,  position, "0");
        if (result == null) {
              decisition = -1;  
        }else{
           decisition = Integer.parseInt(result); 
        }
        return decisition;
    }
    
    /**
     * Declaration: private int columnInsert(int size)
     * It shows a window with the columns to insert in the matrix
     * @param size number of options to show
     * @return the positions chosen by the user
     */
    private int columnInsert(int size){
        int decisition =0;
        String[] buttons ={"Aceptar", "Cancelar"};
        String result;
        String[] position = new String[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            position[index] = String.valueOf(index);
            index += 1;
        }
        result = (String)JOptionPane.showInputDialog(null,"¿En cuál columna desea ingresar un valor?", "Ingreso de posiciones", JOptionPane.YES_OPTION , null,  position, "0");
        if (result == null) {
            decisition = -1;  
        }else{
           decisition = Integer.parseInt(result); 
        }
        return decisition;
    }
    
    /**
     * Declaration: public int randomSelections(int generationNumber, String[][] initialMatrix)
     * Show a window with options to see previous generations or see the next generation
     * @param generationNumber generations created
     * @param initialMatrix
     * @return matrix with the logic process
     */
     public int randomSelection(int generationNumber, String[][] initialMatrix){
        if(generationNumber == 20){
            int desition;
            String[] buttons = {"Ver generaciones"};
            desition = JOptionPane.showOptionDialog(null, getStringMatrix(initialMatrix) + "Se llego al maximo de generaciones, selecciones ver generaciones", "RANDOM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
            return desition;
        }else{
            int desition;
            String[] buttons = {"Siguiente en procesar(siguiente generacion)", "Ver generaciones"};
            desition = JOptionPane.showOptionDialog(null, getStringMatrix(initialMatrix) + "Seleccione una opción", "RAMNDOM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
            return desition;
        } 
    }
}

