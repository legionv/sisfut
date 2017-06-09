/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Torneo {
    private int idTor;
    private String nombreTorneo;
    private String fechaInicio;
    private String fechaFin;
    private String Campeon;
    private String Sugundo;
    private String Tercero;
    private String Cuarto;
    private String torEstado;

    private ArrayList<Equipo> equipo = new ArrayList<Equipo>();

    public Torneo() {
    }

    public ArrayList<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<Equipo> equipo) {
        this.equipo = equipo;
    }

    public String getCampeon() {
        return Campeon;
    }

    public void setCampeon(String Campeon) {
        this.Campeon = Campeon;
    }

    public String getSugundo() {
        return Sugundo;
    }

    public void setSugundo(String Sugundo) {
        this.Sugundo = Sugundo;
    }

    public String getTercero() {
        return Tercero;
    }

    public void setTercero(String Tercero) {
        this.Tercero = Tercero;
    }

    public String getCuarto() {
        return Cuarto;
    }

    public void setCuarto(String Cuarto) {
        this.Cuarto = Cuarto;
    }

    public String getTorEstado() {
        return torEstado;
    }

    public void setTorEstado(String torEstado) {
        this.torEstado = torEstado;
    }

    public Torneo(int idTor, String nombreTorneo, String fechaInicio, String fechaFin, String Campeon, String Sugundo, String Tercero, String Cuarto, String torEstado) {
        this.idTor = idTor;
        this.nombreTorneo = nombreTorneo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.Campeon = Campeon;
        this.Sugundo = Sugundo;
        this.Tercero = Tercero;
        this.Cuarto = Cuarto;
        this.torEstado = torEstado;
    }

    public int getIdTor() {
        return idTor;
    }

    public void setIdTor(int idTor) {
        this.idTor = idTor;
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
        final String regex = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
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
       
           // SimpleDateFormat sdf = new SimpleDateFormat("aaaa/mm/dd");
        /*if(sdf.parse(this.fechaInicio).before(sdf.parse(this.fechaFin))){
        errores += corre + ". La fecha fin no puede ser antes que la fecha inicio \n";
            corre++;
         bandera=false;
        }*/
     
        
         if(!bandera){
            JOptionPane.showMessageDialog(null, errores,"Los datos de entrada contienen errores de validación",1);
        }
        return bandera;
    }
}
