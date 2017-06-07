/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Torneo {
    private String nombreTorneo;
    private String fechaInicio;
    private String fechaFin;
    private ArrayList<Equipo> equipo = new ArrayList<Equipo>();

    public Torneo() {
    }

    public ArrayList<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<Equipo> equipo) {
        this.equipo = equipo;
    }

    public Torneo(String nombreTorneo, String fechaInicio, String fechaFin, String equipo) {
        this.nombreTorneo = nombreTorneo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
   public void agregarEquipo(Equipo equipo){
   this.equipo.add(equipo);
   }

    
    public boolean validar(){
         boolean bandera= true;
        String errores = "";
        int corre = 1;
        final String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        if(!this.fechaFin.matches(regex) || !this.fechaInicio.matches(regex)){
        bandera = false;
        errores += corre +". El formato en el que ingreso la fecha es inválido\n";
        corre++;
        }
        if(this.nombreTorneo.equals("")){
            errores += corre + ". El campo de nombre está vacio \n";
            corre++;
         bandera=false;
        }
        if(this.fechaInicio.trim().length() == 2 || this.fechaFin.trim().length() == 2){
        errores += corre + ". El campo de fecha está vacio \n";
            corre++;
         bandera=false;
        }
         if(!bandera){
            JOptionPane.showMessageDialog(null, errores,"Los datos de entrada contienen errores de validación",1);
        }
        return bandera;
    }
}
