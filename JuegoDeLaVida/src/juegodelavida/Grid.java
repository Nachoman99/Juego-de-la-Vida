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
    private Cell[][] cells2;
    private int generation = 0;

    /**
     * Declaration public Grid(int size)
     * This is a constructor method that initializes the grid
     * With the size that the player wants
     * @param size is the size of the grid
     */
    public Grid(int size) { 
        Cell cell1 = new Cell(1);
        if (size >= 8 && size <= 20) {
            this.cells = new Cell[size][size];
            this.cells2 = new Cell[size][size];
        }
        for(int i = 0; i < cells.length;i++){
            for(int j = 0; j < cells.length;j++){
                cells[i][j] = cell1;
                cells2[i][j] = cell1;
            }    
        }
    }
    public  String getStringMatrix(){ 
        String imprimir = "";
        for(int i = 0; i<cells2.length; i++){
            for(int j = 0; j<cells2[i].length; j++){
               imprimir  =imprimir  + cells2[i][j] + " "; 
            }     
            imprimir  =imprimir + "\n"; 
        }
        return imprimir ;
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
     * @param positionRow 
     * @param positionColumn 
     * @param value 
     */
    public void insertPosition(int positionRow,int positionColumn, boolean value){
        if (cells[positionRow][positionColumn] != null && positionColumn >= 0 && positionColumn <= cells.length-1 &&
                positionRow >= 0 && positionRow <= cells.length-1) {//Primero verifica la posicion si no es nula, y despes
            //ve si la posicion columna y fila estan en ese intervalo si esta afuera no se puede, es decir de 0 a
            // cells.length -1 xq ese es la cantidad de valores maximo ejemplo = 8 filas y columnas entonces va de 
            //0,1,2,3,4,5,6,7 tanto en fila como columna.
            if(value == true){
                Cell cell01 = new Cell(2);
                cells[positionRow][positionColumn] = cell01; //true
                
            }else if(value == false){
                Cell cell01 = new Cell(1);
                cells[positionRow][positionColumn] = cell01; //false  
              
            } 
            
        }else{
            System.out.println("Digite una posición válida");
            
        }  
    }
    
    public void insertPosition2 (int positionRow,int positionColumn, boolean value){
         if (cells2[positionRow][positionColumn] != null && positionColumn >= 0 && positionColumn <= cells2.length-1 &&
                positionRow >= 0 && positionRow <= cells2.length-1) {//Primero verifica la posicion si no es nula, y despes
            //ve si la posicion columna y fila estan en ese intervalo si esta afuera no se puede, es decir de 0 a
            // cells.length -1 xq ese es la cantidad de valores maximo ejemplo = 8 filas y columnas entonces va de 
            //0,1,2,3,4,5,6,7 tanto en fila como columna.
            if(value == true){
                Cell cell01 = new Cell(2);
                cells2[positionRow][positionColumn] = cell01; //true
                
            }else if(value == false){
                Cell cell01 = new Cell(1);
                cells2[positionRow][positionColumn] = cell01; //false  
              
            }
         }
    }
    
    
    /*private void duplicateCells(){
        cells2 = cells.clone();
        String [] array = (String []) arrayOrigen.clone();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells2[i][j] = cells[i][j];
            }
        }
    }*/
    
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
                if(i == 0 || i == cells.length-1 || j == 0 || j == cells.length-1){
                  isSide();
                }else{
                    // Aquí va otro método para calcular los del centro
                    isCentro();
                }
            }
        }
    }
    
    /*
    metodo viejo de isSide
    for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[0][j].getLife() == 2) {   //arriba
                    if (cells[0][0].getLife() == 2 || cells[0][1].getLife() == 2 || cells[1][0].getLife()==2 || cells[1][1].getLife() ==2) {
                        esquinaIzquierdaArriba();
                    }else if(cells[0][cells.length-1].getLife() == 2 || cells[0][cells.length-2].getLife() == 2 || cells[1][cells.length-2].getLife() == 2 || cells[1][cells.length-1].getLife() == 2){
                        esquinaDerechaArriba();
                    }else if (cells[0][j+1].getLife() == 2 || cells[0][j+1].getLife() == 1) {//procedimiento del lado arriba  
                        ladoArriba();
                    }
                }else if(cells[cells.length-1][j].getLife() == 2){ //abajo
                    if (cells[cells.length-1][0].getLife() == 2 || cells[cells.length-1][0].getLife() == 1) {
                        esquinaIzquierdaAbajo();
                    }else if(cells[cells.length-1][cells.length-1].getLife() == 2 || cells[cells.length-1][cells.length-1].getLife() == 1){
                        esquinaDerechaAbajo();
                    }else{//Procedimiento de abajo
                        ladoAbajo();
                    }
                }else if(cells[j][0].getLife() == 2){ //Izquierda
                    if (cells[0][0].getLife() == 2 || cells[0][0].getLife() == 1) {
                        esquinaIzquierdaArriba();
                    }else if(cells[cells.length -1][0].getLife() == 2 || cells[cells.length-1][0].getLife() == 1){
                        esquinaIzquierdaAbajo();
                    }else{// procedimiento izquierda
                        ladoIzquierdo();
                    }
                }else if(cells[j][cells.length-1].getLife() == 2){ //derecha
                    if (cells[0][cells.length-1].getLife() == 2 || cells[0][cells.length-1].getLife() == 1) {
                        esquinaDerechaArriba();
                    }else if(cells[cells.length-1][cells.length-1].getLife() == 2 || cells[cells.length-1][cells.length-1].getLife() == 1){
                        esquinaDerechaAbajo();
                    }else{//procedimiento derecha
                        ladoDerecho();
                    }
                }
            }
        }
    }
    */
    
    private void isSide(){//este metodo va a ser 
        esquinaIzquierdaAbajo();
        esquinaIzquierdaArriba();
        esquinaDerechaAbajo();
        esquinaDerechaArriba();
        ladoArriba();
        ladoAbajo();
        ladoIzquierdo();
        /*for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (i == 0) {   //arriba
                    if (j != 0 || j != cells.length-1) {
                        //procedimiento del lado arriba  
                        //ladoArriba();
                    }
                
                }else if(i == cells.length-1 ){ //abajo
                    if (j != 0 || j!= cells.length-1) {
                        //Procedimiento de abajo
                        //ladoAbajo();
                    }
                
                }else if(j == 0){ //Izquierda
                    if (i != 0 || i != cells.length-1) {
                        // procedimiento izquierda
                        //ladoIzquierdo();
                    }
                
                }else if(j == cells.length-1){ //derecha
                    if (i != 0 || i != cells.length-1){
                        //ladoDerecho();
                    }
                
                }
            }
        }*/
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
                    //ells2[0][0].setLife(2);
                    insertPosition2(0, 0, true);
                }else if (neighbour == 2 && cells[0][0].getLife() == 2) {
                    //cells2[0][0].setLife(2);
                    insertPosition2(0, 0, true);
                }else if (neighbour == 2 && cells[0][0].getLife() == 1) {
                    //cells2[0][0].setLife(1);
                    insertPosition2(0, 0, false);
                }else if (neighbour < 2 || neighbour > 3) {
                   // cells2[0][0].setLife(1);
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
                    //cells2[cells.length-1][0].setLife(2);
                    insertPosition2(cells.length-1, 0, true);
                }else if (neighbour == 2 && cells[cells.length -1][0].getLife() == 2) {
                   // cells2[cells.length-1][0].setLife(2);
                    insertPosition2(cells.length-1, 0, true);
                }else if (neighbour == 2 && cells[cells.length -1][0].getLife() == 1) {
                    //cells2[cells.length-1][0].setLife(1);
                    insertPosition2(cells.length-1, 0, false);
                }else if (neighbour < 2 || neighbour > 3) {
                    //cells2[cells.length-1][0].setLife(1);
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
                    //cells2[0][cells.length-1].setLife(2);
                    insertPosition2(0, cells.length-1, true);
                }else if(neighbour == 2 && cells[0][cells.length-1].getLife() == 1){
                    //cells2[0][cells.length-1].setLife(1);
                    insertPosition2(0, cells.length-1, false);
                }else if (neighbour == 2 && cells[0][cells.length].getLife() == 2) {
                    //cells2[0][cells.length-1].setLife(2);
                    insertPosition2(0, cells.length-1, true);
                }else if (neighbour < 2 || neighbour > 3) {
                    //cells2[0][cells.length-1].setLife(1);
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
            //cells2[cells.length-1][cells.length-1].setLife(2);
            insertPosition2(cells.length-1, cells.length-1, true);
        }else if (neighbour == 2 && cells[cells.length-1][cells.length-1].getLife() == 2) {
            //cells2[cells.length-1][cells.length-1].setLife(2);
            insertPosition2(cells.length-1, cells.length-1, true);
        }else if (neighbour == 2 && cells[cells.length-1][cells.length-1].getLife() == 1) {
           // cells2[cells.length-1][cells.length-1].setLife(1);
            insertPosition2(cells.length-1, cells.length-1, false);
        }else if (neighbour < 2 || neighbour > 3) {
           // cells2[cells.length-1][cells.length-1].setLife(1);
            insertPosition2(cells.length-1, cells.length-1, false);
        }
        
    }
    
    // Entra al primer for, pero de ahí no pasa
    
    
    
    private void ladoArriba(){
        /*int neighbour = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[0][j+1].getLife() == 2 || cells[0][j+1].getLife() == 1) {
                    System.out.println("Hola");
                    if (cells[0][j].getLife() == 2) {
                        neighbour += 1;
                        if (cells[0][j+2].getLife() == 2) {
                            neighbour += 1;
                            if (cells[1][j].getLife() == 2) {
                                neighbour += 1;
                                if (cells[1][j+1].getLife() == 2) {
                                    neighbour += 1;
                                    if (cells[1][j+2].getLife() == 2) {
                                        neighbour += 1;
                                    }
                                }
                            }
                        }
                    }
                }
                if (neighbour == 3) {
                    insertPosition(0, j+1, true);
                }else if (neighbour == 2 && cells[0][j+1].getLife() == 2) {
                    insertPosition(0, j+1, true);
                }else if (neighbour == 2 && cells[0][j+1].getLife() == 1) {
                    insertPosition(0, j+1, false);
                }else if (neighbour < 2 || neighbour > 3) {
                    insertPosition(0, j+1, false);
                }
            }         
        }  */
        int neighbour = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < cells.length-1; j++) {
                        //procedimiento del lado arriba
                        int initialColumnPosition = -1+j;
                        int finalColumnPosition = 1+j;
                        neighbour = 0;
                        for(int k = 0; k <= 1; k++){
                            for(int p = initialColumnPosition; p <= finalColumnPosition; p++){
                                if(k!=0 || p!=j){
                                    //System.out.println(cells[k][p].getLife());
                                    if(cells[k][p].getLife() == 2){
                                        neighbour += 1;
                                        //System.out.println(" i= "+i +" j =" + j+" k= " + k + " p= " + p );
                                       // System.out.println("conta= " +neighbour);
                                    }
                                }   
                            }
                        }
                        
                        if (neighbour == 3) {
                            insertPosition2(i, j, true);
                            //cells2[i][j].setLife(2);
                            //System.out.println("conta= "+neighbour);
                        }else if (neighbour == 2 && cells[0][j].getLife() == 2) {
                            insertPosition2(i, j, true);
                            //cells2[i][j].setLife(2);
                            //System.out.println("conta= "+neighbour);
                        }else if (neighbour == 2 && cells[0][j].getLife() == 1) {
                            insertPosition2(i, j, false);
                           //cells2[i][j].setLife(1);
                             //System.out.println("conta= "+neighbour);
                        }else if (neighbour < 2 || neighbour > 3) {
                            insertPosition2(i, j, false);
                           // cells2[i][j].setLife(1);
                            // System.out.println("conta= "+neighbour);
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
                //System.out.println(neighbour);
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
        for (int j = 1; j < cells.length-1; j++) {//columna
            for (int i = 0; i < 1; i++ ) {//fila
                        //procedimiento del lado arriba
                        int initialColumnPosition = -1+j;
                        int finalColumnPosition = 1+j;
                        neighbour = 0;
                        for(int p = initialColumnPosition; p <= finalColumnPosition; p++){
                            for(int k = 0; k <= 1; k++){
                                if((p!=j || k!=0)){
                                    //System.out.println(cells[k][p].getLife());
                                    if(cells[p][k].getLife() == 2){
                                        neighbour += 1;
                                        //System.out.println(" i= "+i +" j =" + j+" k= " + k + " p= " + p );
                                       // System.out.println("conta= " +neighbour);
                                    }
                                }   
                            }
                        }
                        
                        if (neighbour == 3) {
                            insertPosition2(j, i, true);
                            //cells2[i][j].setLife(2);
                            //System.out.println("conta= "+neighbour);
                        }else if (neighbour == 2 && cells[j][0].getLife() == 2) {
                            insertPosition2(j, i, true);
                            //cells2[i][j].setLife(2);
                            //System.out.println("conta= "+neighbour);
                        }else if (neighbour == 2 && cells[j][0].getLife() == 1) {
                            insertPosition2(j, i, false);
                           //cells2[i][j].setLife(1);
                             //System.out.println("conta= "+neighbour);
                        }else if (neighbour < 2 || neighbour > 3) {
                            insertPosition2(j, i, false);
                           // cells2[i][j].setLife(1);
                            // System.out.println("conta= "+neighbour);
                        }
                    
                }
            }
        
    }
    private void ladoDerecho(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                
            }
        }
    }
    
    public void isCentro(){
        int neighbour = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                }
            }
               /* if(i != 0 && j != 0 && i != cells.length-1 && j != cells.length-1) {
                    if(cells[i-1][j-1].getLife()== 2) {
                        neighbour +=1;
                    }else if(cells[i-1][j].getLife()==2) {
                        neighbour +=1;
                    }else if(cells[i-1][j+1].getLife()==2) {
                        neighbour +=1;
                    }else if(cells[i][j-1].getLife()== 2) {
                        neighbour +=1;
                    }else if(cells[i][j+1].getLife()== 2) {
                        neighbour +=1;
                    }else if(cells[i+1][j-1].getLife()== 2) {
                        neighbour +=1;
                    }else if(cells[i+1][j].getLife()== 2) {
                        neighbour +=1;
                    }else if(cells[i+1][j+1].getLife()== 2) {
                        neighbour +=1;
                    }                
                if (neighbour == 3) {
                    insertPosition(i, j, true);
                    }else if (neighbour == 2 && cells[i][j].getLife() == 2) {
                    insertPosition(i, j, true);
                    }else if (neighbour == 2 && cells[i][j].getLife() == 1) {
                    insertPosition(i, j, false);
                    }else if (neighbour < 2 || neighbour > 3) {
                    insertPosition(i, j, false);
                }
                }
            }
            
        } */
        
    }
    
} 




