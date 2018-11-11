/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.logicGame;

import juegodelavida.models.*;
import juegodelavida.graphicInterface.GraphicInterface;

/**
 * This class represents the cells of the game
 * 
 *@version 29/10/2018
 * @author Kevin Trejos/Jose Ignacio Zamora/Edwin Molina
 */
public class Grid {
    GraphicInterface graphic = new GraphicInterface();
    private Cell[][] cells;
    private Cell[][] cells2;
    private String[][] cells3;
    private int generation = 0;

    /**
     * Declaration public Grid(int size)
     * This is a constructor method that initializes the grid
     * With the size that the player wants
     * @param size is the size of the grid
     */

    public Grid(int size) {
        if (size == 1) {
            randomCells();
        }else{
            this.cells = new Cell[size][size];
            this.cells2 = new Cell[size][size];
            this.cells3 = new String[size][size];
        }
        Cell cell01 = new Cell(1);
        for(int i = 0; i < cells.length;i++){
            for(int j = 0; j < cells.length;j++){
                cells[i][j] = cell01;
                cells2[i][j] = cell01;
            }    
        }
    }
    
    /**
     * public String stringGenerations()
     * Este metodo convierte la matriz de tipo cells a string
     * @return converted matrix
     */
    public String stringGenerations(){
        String imprimir = "";
        for(int i = 0; i<cells.length; i++){
            for(int j = 0; j<cells[i].length; j++){
                if(cells[i][j].getLife() == 1){
                    imprimir  =imprimir  +"□";
                }else if(cells[i][j].getLife() == 2){
                    imprimir  =imprimir  + "■";
                }
               
            }     
            imprimir  =imprimir + "\n";  
        }
        return imprimir ;
    }
    
    /**
     * Declarations:public String[][] stringMatrix()
     * Validate the positions of the matrix, in case the cells are alive 
     * the sign changes, even if they are dead
     * @return converted matrix
     */
    public  String[][] stringMatrix(){ 
        for(int i = 0; i<cells.length; i++){
            for(int j = 0; j<cells[i].length; j++){
                if(cells[i][j].getLife() == 1){
                    cells3[i][j] = "□";
                }else if(cells[i][j].getLife() == 2){
                    cells3[i][j] = "■";
                }
            }
        }
        return  cells3;
    }
    
    /**
     * Declaration: public void randomCells()
     * This method generates cells in random positions of the grid
     */
    public void randomCells(){
        int random;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                random = (int)(Math.random()*2) + 1;
                if (random == 2) {
                    Cell cell01 = new Cell(2);
                    cells[i][j] = cell01;
                }else{
                    Cell cell2 = new Cell(1);
                    cells[i][j] = cell2;
                }
            }
        }
    }
    
    /** 
     * Declaration: public void insertPosition(int positionRow, int positionColumn, boolean value)
     * This method inserts cells in the matrix
     * @param positionRow position of the row in which to insert
     * @param positionColumn position of the column in which to insert
     * @param value value of the cell, (whether it is alive or dead)
     */
    public void insertPosition(int positionRow,int positionColumn, boolean value){
        if (cells[positionRow][positionColumn] != null && positionColumn >= 0 && positionColumn <= cells.length-1 &&
                positionRow >= 0 && positionRow <= cells.length-1) {
            if(value == true){
                Cell cell01 = new Cell(2);
                cells[positionRow][positionColumn] = cell01; 
            }else if(value == false){
                Cell cell01 = new Cell(1);
                cells[positionRow][positionColumn] = cell01;   
            } 
        }else{
            System.out.println("Digite una posición válida");
        }  
    }
    
    /**
     * Declaration:public void insertPosition2(int positionRow, int positionColumn, boolean value)
     * This method inserts cells in the matrix2
     * @param positionRow position of the row in which to insert
     * @param positionColumn position of the column in which to insert
     * @param value value of the cell, (whether it is alive or dead)
     */
    public void insertPosition2 (int positionRow,int positionColumn, boolean value){
         if (cells2[positionRow][positionColumn] != null && positionColumn >= 0 && positionColumn <= cells2.length-1 &&
                positionRow >= 0 && positionRow <= cells2.length-1) {
            if(value == true){
                Cell cell01 = new Cell(2);
                cells2[positionRow][positionColumn] = cell01;
            }else if(value == false){
                Cell cell01 = new Cell(1);
                cells2[positionRow][positionColumn] = cell01;  
            }
        }
    }
   
    /**
     * Declaration: public void hasLife()
     * This method calls other methods to validate which 
     * cells are alive or dead
     */
    public void hasLife(){
        downLeftCorner();
        leftCornerUp();
        downRightCorner();
        rightCornerUp();
        sideUp();
        downSide();
        ladoIzquierdo();
        ladoDerecho();
        isCentro();
        clear(cells);
        duplicate();
        clear(cells2);
    }
    
   /**
    * Declaration: private void leftCornerUp()
    * This method validates the cells that are in the left corner above
    */
    private void leftCornerUp(){
        int neighbour = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <=1; j++) {
                if(i != 0 || j != 0){
                    if (cells[i][j].getLife() == 2) {
                        neighbour += 1;    
                    }
                }
            }
        }
        if (neighbour == 3) {
            insertPosition2(0, 0, true);
        }else if (neighbour == 2 && cells[0][0].getLife() == 2) {
            insertPosition2(0, 0, true);
        }else if (neighbour == 2 && cells[0][0].getLife() == 1) {
            insertPosition2(0, 0, false);
        }else if (neighbour < 2 || neighbour > 3) {
        insertPosition2(0, 0, false);
        }
    }
     
    /**
     * Declaration: private void downLeftCorner()
     * this method validates the cells in the left corner below
     */
    private void downLeftCorner(){
        int neighbour = 0;
        for (int i = cells.length-2 ; i < cells.length; i++) {
            for (int j = 0; j <= 1; j++) {
                if (i != cells.length-1 || j != 0) {     
                    if (cells[i][j].getLife() == 2) {
                        neighbour += 1;
                    }
                }   
            }
        }
        if (neighbour == 3) {
            insertPosition2(cells.length-1, 0, true);
        }else if (neighbour == 2 && cells[cells.length -1][0].getLife() == 2) {
            insertPosition2(cells.length-1, 0, true);
        }else if (neighbour == 2 && cells[cells.length -1][0].getLife() == 1) {
            insertPosition2(cells.length-1, 0, false);
        }else if (neighbour < 2 || neighbour > 3) {
            insertPosition2(cells.length-1, 0, false);
        }
    }
    
    /**
     * Declaration: private void rightCornerUp()
     * this method validates the positions of the right corner above
     */
    private void rightCornerUp(){
        int neighbour = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = cells.length-2; j < cells.length; j++) {
                if (i != 0 || j != cells.length-1) {
                    if (cells[i][j].getLife() == 2) {
                        neighbour += 1;
                    }
                }
            }
        }
        if (neighbour == 3) {
            insertPosition2(0, cells.length-1, true);
        }else if(neighbour == 2 && cells[0][cells.length-1].getLife() == 1){
            insertPosition2(0, cells.length-1, false);
        }else if (neighbour == 2 && cells[0][cells.length-1].getLife() == 2) {
            insertPosition2(0, cells.length-1, true);
        }else if (neighbour < 2 || neighbour > 3) {
            insertPosition2(0, cells.length-1, false);
        }    
    }
    
    /**
     * Declaration: private void downRightCorner()
     * this method validates the cells in the right corner below
     */
    private void downRightCorner(){
        int neighbour = 0;
        for (int i = cells.length-2; i < cells.length; i++) {
            for (int j = cells.length-2; j < cells.length; j++) {
                if (i != cells.length-1 || j != cells.length-1) {
                    if (cells[i][j].getLife() == 2) {
                        neighbour += 1;   
                    }
                }
            }
        }
        if (neighbour == 3) {
            insertPosition2(cells.length-1, cells.length-1, true);
        }else if (neighbour == 2 && cells[cells.length-1][cells.length-1].getLife() == 2) {
            insertPosition2(cells.length-1, cells.length-1, true);
        }else if (neighbour == 2 && cells[cells.length-1][cells.length-1].getLife() == 1) {
            insertPosition2(cells.length-1, cells.length-1, false);
        }else if (neighbour < 2 || neighbour > 3) {
            insertPosition2(cells.length-1, cells.length-1, false);
        }
    }
    
    /**
     * Declaration: private void sideUp()
     * this method validates the cells on the top side
     */
    private void sideUp(){
        int neighbour = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < cells.length-1; j++) {
                int initialColumnPosition = -1+j;
                int finalColumnPosition = 1+j;
                neighbour = 0;
                for(int k = 0; k <= 1; k++){
                    for(int p = initialColumnPosition; p <= finalColumnPosition; p++){
                        if(k!=0 || p!=j){
                            if(cells[k][p].getLife() == 2){
                                neighbour += 1;
                            }
                        }   
                    }
                }
                if (neighbour == 3) {
                    insertPosition2(i, j, true);
                }else if (neighbour == 2 && cells[0][j].getLife() == 2) {
                    insertPosition2(i, j, true);
                }else if (neighbour == 2 && cells[0][j].getLife() == 1) {
                    insertPosition2(i, j, false);
                }else if (neighbour < 2 || neighbour > 3) {
                    insertPosition2(i, j, false);
                }    
            }
        } 
    }
        
    /**
     * Declaration: private void downSide()
     * This method validates the cells on the down side
     */
    private void downSide(){
        int neighbour = 0;
        for (int i = cells.length -1; i <= cells.length-1; i++) {
           for (int j = 1; j < cells.length -1; j++) {
                int initialColumnPosition = -1+j;
                int finalColumnPosition = 1+j;
                neighbour = 0;
                for (int k = cells.length-2; k <= cells.length-1; k++) {
                    for (int l = initialColumnPosition; l <= finalColumnPosition; l++) {
                        if (k!=cells.length -1 || l!=j) {
                            if (cells[k][l].getLife() == 2) {
                                neighbour += 1;
                            }
                        }
                    }
                }
                if (neighbour == 3) {
                    insertPosition2(i, j, true);
                }else if (neighbour == 2 && cells[cells.length-1][j].getLife() == 2) {
                    insertPosition2(i, j, true);
                }else if (neighbour == 2 && cells[cells.length-1][j].getLife() == 1) {
                    insertPosition2(i, j, false);
                }else if (neighbour < 2 || neighbour > 3) {
                    insertPosition2(i, j, false);
                }
            }
        }
    }
    
    /**
     * Declaration: private void leftSide()
     * This method validates the cells on the left side
     */
    private void ladoIzquierdo(){
        int neighbour = 0;
        for (int j = 1; j < cells.length-1; j++) {
            for (int i = 0; i < 1; i++ ) {
                int initialRowPosition = -1+j;
                int finalRowPosition = 1+j;
                neighbour = 0;
                for(int p = initialRowPosition; p <= finalRowPosition; p++){
                    for(int k = 0; k <= 1; k++){
                        if((p!=j || k!=0)){
                            if(cells[p][k].getLife() == 2){
                                neighbour += 1;
                            }
                        }   
                    }
                }                
                if (neighbour == 3) {
                    insertPosition2(j, i, true);
                }else if (neighbour == 2 && cells[j][0].getLife() == 2) {
                    insertPosition2(j, i, true);
                }else if (neighbour == 2 && cells[j][0].getLife() == 1) {
                    insertPosition2(j, i, false);
                }else if (neighbour < 2 || neighbour > 3) {
                    insertPosition2(j, i, false);
                }
            }
        }  
    }
    
    /**
     * Declaration: private void rightSide()
     * This method validates the cells of the right side
     */
    private void ladoDerecho(){
        int neighbour = 0;
        for (int j = 1; j < cells.length - 1; j++) { //filas
            for (int i = cells.length-1; i <= cells.length -1; i++) {
                int initialRowPosition = -1+j;
                int finalRowPosition = 1+j;
                neighbour = 0;
                for(int l = initialRowPosition; l <= finalRowPosition; l++) {
                    for(int k = cells.length-2; k <= cells.length-1;k++) {
                        if (l!=j|| k!=cells.length -1 ) {
                            if(cells[l][k].getLife()==2) {
                                neighbour += 1;
                            }
                        }
                    }
                }
                 if (neighbour == 3) {
                    insertPosition2(j, i, true);
                }else if (neighbour == 2 && cells[j][cells.length-1].getLife() == 2) {
                    insertPosition2(j, i, true);
                }else if (neighbour == 2 && cells[j][cells.length-1].getLife() == 1) {
                    insertPosition2(j, i, false);
                }else if (neighbour < 2 || neighbour > 3) {
                    insertPosition2(j, i, false);
                }
            }
        }
    }
    
    /**
     * Declaration: private void isCentro()
     * This method validates the center's cells
     */
    private void isCentro(){
        int neighbour = 0;
        for (int i = 1; i <= cells.length -2; i++) {
            for (int j = 1; j <= cells.length -2; j++) {
                int initialColumnPosition = -1 + j;
                int finalColumnPosition = 1 + j;
                int initialRowPosition = -1 + i;
                int finalRowPosition = 1 + i;
                neighbour = 0;
                for (int k = initialRowPosition; k <= finalRowPosition; k++) {
                    for (int l = initialColumnPosition; l <= finalColumnPosition; l++) {
                        if (k!= i || l!= j ) {
                            if (cells[k][l].getLife() == 2) {
                                neighbour += 1;
                            }
                        }
                    }
                }
                if (neighbour == 3) {
                    insertPosition2(i, j, true);
                }else if (neighbour == 2 && cells[i][j].getLife() == 2) {
                    insertPosition2(i, j, true);
                }else if (neighbour == 2 && cells[i][j].getLife() == 1) {
                    insertPosition2(i, j, false);
                }else if (neighbour < 2 || neighbour > 3) {
                    insertPosition2(i, j, false);
                }
            }
        }
    }
    
    /**
     * Declaration: private void clear(Cell[][] cellsClear)
     * This method makes all the cells in the matrix dead
     * @param cellsClear 
     */
    private void clear(Cell[][] cellsClear){
        Cell cell1 = new Cell(1);
        for(int i = 0; i < cellsClear.length;i++){
            for(int j = 0; j < cellsClear.length;j++){
                cellsClear[i][j] = cell1;
            }    
        }
    }
    
    /**
     * Declaration: private void duplicate()
     * This method duplicates the matrix
     */
    private void duplicate(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = cells2[i][j];
            }
        }
    }  
} 





