/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida.models;

import juegodelavida.*;
import juegodelavida.graphicInterface.GraphicInterface;

/**
 * This class represents the cells of the game
 * 
 *@version 29/10/2018
 * @author Kevin Trejos
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
    public  String getStringMatrix(){ 
        String imprimir = "";
        for(int i = 0; i<cells.length; i++){
            for(int j = 0; j<cells[i].length; j++){
               imprimir  =imprimir  + cells[i][j] + " "; 
            }     
            imprimir  =imprimir + "\n"; 
        }
        return imprimir ;
    }
    
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
    private void randomCells(){
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
    
    /**Falta completar este método para hacerlo con click, por lo tanto no está comentado 
     * correctamente
     * 
     * @param positionRow 
     * @param positionColumn 
     * @param value 
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
   
    public void hasLife(){
        esquinaIzquierdaAbajo();
        esquinaIzquierdaArriba();
        esquinaDerechaAbajo();
        esquinaDerechaArriba();
        ladoArriba();
        ladoAbajo();
        ladoIzquierdo();
        ladoDerecho();
        isCentro();
        clear(cells);
        duplicate();
        clear(cells2);
    }
    
   
    
    private void esquinaIzquierdaArriba(){
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
        
    private void esquinaIzquierdaAbajo(){
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
    
    private void esquinaDerechaArriba(){
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
        }else if (neighbour == 2 && cells[0][cells.length].getLife() == 2) {
            insertPosition2(0, cells.length-1, true);
        }else if (neighbour < 2 || neighbour > 3) {
            insertPosition2(0, cells.length-1, false);
        }    
    }
    
    private void esquinaDerechaAbajo(){
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
    
    private void ladoArriba(){
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
        
    private void ladoAbajo(){
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
    
    public void isCentro(){
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
    
    public void clear(Cell[][] cellsClear){
        Cell cell1 = new Cell(1);
        for(int i = 0; i < cellsClear.length;i++){
            for(int j = 0; j < cellsClear.length;j++){
                cellsClear[i][j] = cell1;
            }    
        }
    }
    
    private void duplicate(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = cells2[i][j];
            }
        }
    }
    
    
    
} 





