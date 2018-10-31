/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelavida;

/**
 * This class represents the cells of the game
 * 
 *@version 29/10/2018
 * @author Kevin Trejos
 */
public class Grid {
    private Cell[][] cells;
    private int generation = 0;

    /**
     * Declaration public Grid(int size)
     * This is a constructor method that initializes the grid
     * With the size that the player wants
     * @param size is the size of the grid
     */
    public Grid(int size) { 
        if (size >= 8 && size <= 20) {
            this.cells = new Cell[size][size];
        }
    }
    
    /**Revisar este método ya que imprime muchas cells,creo que hay que quitar un for
     * Declaration: public void randomCells()
     * This method generates cells in random positions of the grid
     */
    public void randomCells(){
        int random;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                random = (int)(Math.random()*2) + 1;
                if (random == 2) {
                    Cell cell1 = new Cell(2);
                    cells[i][j] = cell1;
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
     * @param position 
     */
    public void insertPosition(int positionRow,int positionColumn, int value){
        if (cells[positionRow][positionColumn] != null && positionColumn >= 0 && positionColumn <= cells.length-1 &&
                positionRow >= 0 && positionRow <= cells.length-1) {//Primero verifica la posicion si no es nula, y despes
            //ve si la posicion columna y fila estan en ese intervalo si esta afuera no se puede, es decir de 0 a
            // cells.length -1 xq ese es la cantidad de valores maximo ejemplo = 8 filas y columnas entonces va de 
            //0,1,2,3,4,5,6,7 tanto en fila como columna.
            if(value == 2){
                Cell cell01 = new Cell(2);
                cells[positionRow][positionColumn] = cell01; //true 
            }else{
                Cell cell01 = new Cell(1);
                cells[positionRow][positionColumn] = cell01; //false  
            } 
        }else{
            System.out.println("Digite una posición válida");
        }

        
    }
    
    /**
     * Este método lo que hace es seguir las reglas para ver cuales nacen y cuales mueren
     * No esta completado, los 2 significa que tiene vida, los 1, que está muerta
     * sólo está en el caso de que por ejemplo:
     * If:(2)(2)
     *    (2)(1)
     * Entonces
     * (2)(2)
     * (2)(2)
     * else: (1)(2)
     *       (2)(1)
     * Por lo tanto en la p´roxima generación morirían todas, eso fue lo que hice
     */
    /*
    -Si una casilla está ocupada y el número de casillas adyacentes también ocupadas es menor que 2, 
    la célula muere por aislamiento y se retira del tablero en la siguiente generación.
    -Si una casilla está ocupada y el número de células que la rodean es mayor que 3, la célula muere por 
    superpoblación (se quita del tablero en el siguiente turno).
    -Una casilla libre que tenga 3 (y sólo 3) células adyacentes da lugar a una célula viva en el siguiente turno.
    */
    public void hasLife(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if(i==0 || i==cells.length-1 || j==0 || j==cells.length-1){
                        if(i==0 && j==0){
                            //esquina de izquierda arriba
                        }else if(i==cells.length-1 && j==0){
                            //esquina izquierda abajo
                        }else if(i==0 && j==cells.length-1){
                            //esquina derecha arriba
                        }else if(i==cells.length-1 && j==cells.length-1){
                            //esquina derecha abajo
                        }else if(i==0){
                            //fila sea 0
                        }else if(i==cells.length-1){
                             //fila sea 2
                        }else if(j==0){
                            //columna sea 0
                        }else if(j==cells.length-1){
                            //columna sea 2
                        }
                    
                }else{
                    //caso que sea del centro y se pueda sacar las 8 posiciones vecinas
                    
                }
                
                
                
                
                /*if (cells[i][j].getLife() == 2 && cells[i + 1][j].getLife() == 2 && cells[i][j + 1].getLife() == 2) {
                    cells[i + 1][j + 1].setLife(2);
                }else{
                    cells[i][j].setLife(1);
                }*/
            }
        }
    }
}
