/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import esquemasypantallas.frmInternal.frmInTor;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Luis
 */
public class Utilidades {
    
    
    public void noSpecial(java.awt.event.KeyEvent evt){//valida que no se ingresen caracteres especiales pero si  letras y espacios
    Character c = evt.getKeyChar();
    String a = c.toString();
    String pattern = "^[a-zA-Z\\s]*$";
        if (!a.matches(pattern)) {
            
            evt.consume();
        }
    
    }
      public void noSpecialNums(java.awt.event.KeyEvent evt){ //valida que no se ingresen caracteres especiales pero si numeros y letras y espacios
    Character c = evt.getKeyChar();
    String a = c.toString();
    String pattern = "^[a-zA-Z0-9\\s]*$";
        if (!a.matches(pattern)) {
            
            evt.consume();
        }
        
    
    }
    public String fixNombre(String nom){  //formatea los nombres en  primera letra mayuscula y demas minusculas
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
    
    public void openForm(JInternalFrame obj,JDesktopPane pane){ //abre formularios sin parametros en el centro de la pantalla
   
        pane.add(obj);
        Dimension desktopSize = pane.getSize();
Dimension jInternalFrameSize = obj.getSize();
obj.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
    (desktopSize.height- jInternalFrameSize.height)/2);
        obj.setVisible(true);
    
    }
    
    
    public  double getRandom(double min, double max){ // genera un double aleatorio 
     return(Math.random()*(max+1-min)) + min;
    }
    
    
    public String[] Emparejar(Torneo tr){
        
         //String[] eqs = {"aguila","metapan","alianza","firpo","santa tecla","arsenal","juventus","real madrid","barcelona","atletic"}; 
       ArrayList<Equipo> eqs = tr.getEquipo();
         double[] rifa = new double[eqs.size()];
      double[] ord = new double[eqs.size()];
      
      ArrayList<Double> des = new ArrayList<Double>();
      double aux = 0.0;
        for (int i = 0; i < eqs.size(); i++) {
            
            rifa[i] = getRandom(1, 200);
        }
      
        String [] matchups = new String[eqs.size()/2];
        String [] sql =  new String[matchups.length];
        for (int i = 0; i < matchups.length; i++) {
            matchups[i] = "";
            sql[i] = "";
        }
   
        ord = rifa;
        
           for (int i = 0; i < rifa.length; i++) {
               
               des.add(rifa[i]);
              
        }
        Arrays.sort(ord);
       
      
        int l = 0;
        for (int i = 0; i < matchups.length; i++) {
            outerloop:
              for (int j = l; j < ord.length; j++) {
               
                  for (int k = 0; k < des.size(); k++) {
                      if (ord[j] == des.get(k)) {
                          
                          
                          if (matchups[i].equals("")) {
                              matchups[i] = eqs.get(k).toString();
                              sql[i] =  "INSERT INTO `sisfut`.`partido`(`idTor`,`idEqVis`,`idEqLoc`,`partEstado`,`partJornada`,`partGanador`,`partScoreLoc`,`partScoreVis`)VALUES("+tr.getIdTor()+","+eqs.get(k).getIdEq()+",";
                              
                          }else{
                          matchups[i] += " VS " + eqs.get(k).toString();
                          sql[i] += eqs.get(k).getIdEq()+",'Pendiente','Primera','Por Det',0,0);";
                          l = j+1;
                          break outerloop;
                          }
                      }
                  }
        }
         
        }
        
         
       
        /* for (int i = 0; i < matchups.length; i++) {
             System.out.println(sql[i]);
        }*/
        
        return sql;
    
    }
    
    
        public void loadCombo(ArrayList lista, JComboBox cmb){
    
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        
        for (int i = 0; i < lista.size(); i++) {
            
            cb.addElement(lista.get(i));
        }
        cmb.setModel(cb);
    }
}
