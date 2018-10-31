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
    
    
}
