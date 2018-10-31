/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.graphicInterface;

import javax.swing.JOptionPane;

/**
 * In this class, window management will be given
 * 
 *@version 30/10/2018
 * @author Kevin Trejos
 */
public class GraphicInterface {
    /**
     * Declaration: public void showMessage(String message)
     * this method shows a window with a message
     * @param message the message to show
     */
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    /**
     * Declaration: public void requestInt(String message)
     * this method asks the user for an integer 
     * @param message the message to show
     */
    public void requestInt(String message){
        JOptionPane.showInputDialog(message);
    }
    
    /**
     * Declaration: public void requestYesOrNo(String message, String tittle)
     * this method shows a question window to the user with the answer options yes/no/cancel
     * @param message the message to show
     * @param tittle the tittle of the window
     */
    public void requestYesOrNo(String message, String tittle){
        JOptionPane.showConfirmDialog(null, message, tittle, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
    
    public static String getStringMatrix(String[][] matrix1){ //lo pongo para poder poner la matriz bien bonita
        String imprimir = "";
        for(int i = 0; i<matrix1.length; i++){
            for(int j = 0; j<matrix1[i].length; j++){
               imprimir  =imprimir  + matrix1[i][j] + " "; 
                     
            }     
            imprimir  =imprimir + "\n"; 
        }
        return imprimir ;
    }
    /*String[] rowColumn = {"0","1","2","3","4","5","6","7"};
        String[][] matrix = {{"■","■","■","■","■","■","■","■"},
                             {"■","■","■","■","■","■","■","■"},
                             {"■","■","■","■","■","■","■","■"},
                             {"■","■","■","■","■","■","■","■"},
                             {"■","■","■","■","■","■","■","■"},
                             {"■","■","■","■","■","■","■","■"},
                             {"■","■","■","■","■","■","■","■"},
                             {"■","■","■","■","■","■","■","■"}};*/
    public String[] selection(String[] rowColumn, String[][] matrix){
        String result1 = (String)JOptionPane.showInputDialog(null, getStringMatrix(matrix) +"¿Seleccione el numero de la Fila?", "Fila", JOptionPane.INFORMATION_MESSAGE ,null , rowColumn, "0"); 
        String result2 = (String)JOptionPane.showInputDialog(null, getStringMatrix(matrix) +"\n" +"¿Seleccione el numero de la Columna?", "Columna", JOptionPane.INFORMATION_MESSAGE ,null , rowColumn, "0"); 
        String[] finalResult = {result1, result2};
        return finalResult;
    }
       
    public static void changeMatrix(String[][] matrix, String[] positions){
        int positionRow = Integer.parseInt(positions[0]);
        int positionColumn = Integer.parseInt(positions[1]);
        matrix[positionRow][positionColumn] = "O";
    }
}
