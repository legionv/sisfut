/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Luis
 */
public class Utilidades {
    
    
    public void noSpecial(java.awt.event.KeyEvent evt){
    Character c = evt.getKeyChar();
    String a = c.toString();
    String pattern = "^[a-zA-Z\\s]*$";
        if (!a.matches(pattern)) {
            
            evt.consume();
        }
    
    }
      public void noSpecialNums(java.awt.event.KeyEvent evt){
    Character c = evt.getKeyChar();
    String a = c.toString();
    String pattern = "^[a-zA-Z0-9\\s]*$";
        if (!a.matches(pattern)) {
            
            evt.consume();
        }
        
    
    }
    public String fixNombre(String nom){
    String nombre= "";
         if (nom.length() > 0) {
        String[] part = nom.split(" ");
        
        for (int i = 0; i < part.length; i++) {
            part[i] = part[i].toLowerCase();
            if (i != 0) {
                nombre += " ";
                        
                       
            }
           nombre += part[i].substring(0,1).toUpperCase() + part[i].substring(1);
        } 
        
           
        }
        
        
        return nombre;
    }
    
    
}
