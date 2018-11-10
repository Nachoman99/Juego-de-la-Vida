/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.graphicInterface;

import javax.swing.JOptionPane;
import juegodelavida.models.Grid;

/**
 * In this class, window management will be given
 * 
 *@version 30/10/2018
 * @author Kevin Trejos
 */
public class GraphicInterface {
    Grid grid;
    public GraphicInterface() {
    }
    
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
    
    public void presentation(){
        JOptionPane.showMessageDialog(null, "        JUEGO DE LA VIDA     "+"\n"+"Integrantes: "+"\n"+"Kevin Trejos B87902"+"\n"+"Edwin Molina"+
                "Carne Ed"+"\n"+"Jose Zamora B78541", "Juego de La Vida", JOptionPane.INFORMATION_MESSAGE, null);
    }
    /*
    public int sizeDecisition(){
        int desition;
        String[] message ={"Elegir tamaño de matriz"};
        desition = JOptionPane.showOptionDialog(null, "Seleccione una opción", "TAMAÑO MATRIZ", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, message, message[0]);
        return 0;
    }*/
       
    public int sizeMatrix(){
        int decisition;
        String result;
        String[] position = {"8","9","10","11","12","13","14","15","16","17","18","19","20"};
        /*JComboBox size = new JComboBox(position);
        size.setEditable(true);
        JOptionPane.showMessageDialog(null, size, "Filas", JOptionPane.QUESTION_MESSAGE);*/
        result = (String)JOptionPane.showInputDialog(null, "¿De cuanto quiere su cuadricula?", "Filas y Columnas", JOptionPane.WARNING_MESSAGE , null,  position, "8");
        //decisition = Integer.parseInt(size.getSelectedItem().toString());
        decisition = Integer.parseInt(result);
        return decisition; 
    }
    
    public int generations(String[][] generation1){
        String[] buttons ={"Siguiente", "Ver generaciones anteriores", "Terminar juego"};
        int desition = JOptionPane.showOptionDialog(null, getStringMatrix(generation1) + "Seleccione alguna opción", "GENERACIONES", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
        if (desition == 2) {
            JOptionPane.showMessageDialog(null, "Muchas gracias por jugar");
            //int gen = generations1();
            //return gen;
        //}else if (desition == 2) {
          //  JOptionPane.showMessageDialog(null, "Muchas gracias por jugar");
        }
        return desition;
    }
    /*
    public int generations(String[][] generation1){
        int generationsCreated = 0;
        String[] buttons ={"Siguiente", "Ver generaciones anteriores", "Terminar juego"};
        int desition = JOptionPane.showOptionDialog(null, getStringMatrix(generation1) + "Seleccione alguna opción", "GENERACIONES", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
        if (desition == 0) {
            generationsCreated +=1;
        }
        if (desition == 1) {
            int gen = generations1(generationsCreated);
            return gen;
        }else if (desition == 2) {
            JOptionPane.showMessageDialog(null, "Muchas gracias por jugar");
        }
        return desition;
    }
    */
    
    /*
    private int generations1(int generations){
        int decisition;
        String[] buttons ={"Aceptar"};
        int btDecision = JOptionPane.showOptionDialog(null,"","Juego", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
        String result;
        String[] position = new String[generations];
        int index = 0;
        for (int i = 0; i < generations; i++) {
            position[index] = String.valueOf(index);
            index += 1;
        }
        result = (String)JOptionPane.showInputDialog(null,"¿Elija una generación a ver", "Ver generaciones", JOptionPane.INFORMATION_MESSAGE , null,  position, "1");
        decisition = Integer.parseInt(result);
        JOptionPane.showMessageDialog(null, );
        return decisition;
    }
    */
    
    private int generations1(int generations){
        int decisition;
        String[] buttons ={"Aceptar"};
        int btDecision = JOptionPane.showOptionDialog(null,"","Juego", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
        String result;
        String[] position = new String[generations];
        int index = 0;
        for (int i = 0; i < generations; i++) {
            position[index] = String.valueOf(index);
            index += 1;
        }
        result = (String)JOptionPane.showInputDialog(null,"¿Elija una generación a ver", "Ver generaciones", JOptionPane.INFORMATION_MESSAGE , null,  position, "1");
        decisition = Integer.parseInt(result);
        return decisition;
    }
    
    public int randomInsert(){//pregunta si quere que se ingresen datos aleatorios o insetar uno por uno
    String[] buttons ={"Posiciones Aleatorias", "Ingresar posiciones a gusto"};
    int desition = JOptionPane.showOptionDialog(null, "Seleccione alguna opción", "Seleccion de Relleno", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
    return desition;
    }
    
   /* public String showGrid(int size){//transforma el grid en un string para mostralo pero talvez sea innecesario xq podemos mostrar de un solo tiro el grid
       //muestra las posiciones como 1 2  3  4  5  7
       //                            8 9 10 11 11 12
        String[][] gridString = new String[size][size];
        int number = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(number<=9){
                    gridString[i][j] = "    " + "00"+String.valueOf(number);
                    number += 1;
                }else if(number>=10 && number<=99){
                    gridString[i][j] = "    " + "0"+String.valueOf(number);
                    number += 1;
                }else if(number>=100){
                    gridString[i][j] = "    " +String.valueOf(number);
                    number += 1;
                }
                
            }
        }
        
       return getStringMatrix(gridString);
    }*/
    
    public int[] insertPosition(int size, String[][] initialMatrix){ //ventana para insertar las posiciones
        //el problema es que va tirar un numero de la posicion como ejemplo 17
        //entonces con ese numero tendria que insetar la posicion en el grid original por eso mas adelante 
        //esta translate
        /*int decisition;
        String result;
        String[] position = new String[size*size];
        int index = 0;
        for (int i = 0; i < (size*size); i++) {
                position[index] = String.valueOf(1+index);
                index += 1;
            
        }
        result = (String)JOptionPane.showInputDialog(null, gridString +"¿Cual posicion desea ingresar un valor?", "Ingreso de posiciones", JOptionPane.INFORMATION_MESSAGE , null,  position, "1");
        decisition = Integer.parseInt(result);
        return decisition;*/
        int desition;
        int row;
        int column;
        String[] buttons = {"Insertar una nueva posición", "Continuar"};
        desition =JOptionPane.showOptionDialog(null, getStringMatrix(initialMatrix) + "Seleccione una opción", "INSERTAR POSICIONES", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
        if (desition == 0) {
            row = rowsInsert(size);
            column = columnInsert(size);
            //Aqui va la matriz a insertar
            //JOptionPane.showMessageDialog(null,  "POSICION INGRESADA", JOptionPane.INFORMATION_MESSAGE);
            int[] positions = {row,column};
            return positions;
        }
        return null;
    }
    
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
        decisition = Integer.parseInt(result);
        return decisition;
    }
    
    private int columnInsert(int size){
        int decisition;
        String result;
        String[] position = new String[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
                position[index] = String.valueOf(index);
                index += 1;
        }
        result = (String)JOptionPane.showInputDialog(null,"¿En cuál columna desea ingresar un valor?", "Ingreso de posiciones", JOptionPane.INFORMATION_MESSAGE , null,  position, "0");
        decisition = Integer.parseInt(result);
        return decisition;
    }
    public void translate(int size, int position){//metodos para traducir digamos
        // 17 es la posicion X=0 y Y=1 (es un ejemplo)
        //talves esto complique las varas pero si hay otra idea por favor diganla
        // otra idea que se me dio fue que la persona ingrese la posicion dela cuadricula
        //ejemplo una ventana pide X y otra el Y y una true/false y asi seria mas facil el manejo de datos
        //pero no se debe de haber otra idea que no se me ocurre
        int[] matrixPosition = new int[1];
        switch(position){
            case 1:
                 
                break;
             
            default:
                 
                break;
        }
    }

    public void showGrid(int size){
        int decisition;
        String result;
        String[][] matrix = new String[size][size];
        int index = 0;
        for (int i = 0; i < size; i++) {
                matrix[index][index] = String.valueOf(index);
                index += 1;
        }
        JOptionPane.showMessageDialog(null, matrix);
    }
}

