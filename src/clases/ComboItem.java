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
public class ComboItem {
     private String key;
     private String value;

    public ComboItem(String key, String value) {
        this.key = key;
        this.value = value;
    }
     
     @Override
     public String toString(){
     return this.key;
     }
     
     public String getKey(){
       return this.key;
     }
     public String getValue(){
     
       return this.value;
     }
}
