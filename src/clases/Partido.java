/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Luis
 */
public class Partido {
    private String equipoVisita;
    private String equipoLocal;
    private String jornada;
    private String hora_inicio;
    private String hora_fin;
    private String fecha;
    private int scoreLocal;
    private int scoreVisita;
    private String ganador;
    private ArrayList<Incidencia> incidencias = new ArrayList<Incidencia>();

    public Partido() {
    }

    public Partido(String equipoVisita, String equipoLocal, String jornada, String hora_inicio, String hora_fin, String fecha, int scoreLocal, int scoreVisita, String ganador) {
        this.equipoVisita = equipoVisita;
        this.equipoLocal = equipoLocal;
        this.jornada = jornada;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha = fecha;
        this.scoreLocal = scoreLocal;
        this.scoreVisita = scoreVisita;
        this.ganador = ganador;
    }

    public Partido(String equipoVisita, String equipoLocal, String jornada, String hora_inicio, String hora_fin,String fecha) {
        this.equipoVisita = equipoVisita;
        this.equipoLocal = equipoLocal;
        this.jornada = jornada;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha = fecha;
    }

    public int getScoreLocal() {
        return scoreLocal;
    }

    public void setScoreLocal(int scoreLocal) {
        this.scoreLocal = scoreLocal;
    }

    public int getScoreVisita() {
        return scoreVisita;
    }

    public void setScoreVisita(int scoreVisita) {
        this.scoreVisita = scoreVisita;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEquipoVisita() {
        return equipoVisita;
    }

    public void setEquipoVisita(String equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public ArrayList<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(ArrayList<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }
    
    public void addIncidencia(Incidencia incidencia){
    this.incidencias.add(incidencia);
    }
    
       public void setScore(String local,String visita){
       int scoreLocal = 0;
       int scoreVisita = 0;
       String ganador = "";  
       
       for(int i=0; i<this.incidencias.size();i++){
       
       if(this.incidencias.get(i).getEquipo().equals("l") && this.incidencias.get(i).getTipo().toLowerCase().contains("gol")&& (!this.incidencias.get(i).getTipo().toLowerCase().equals("autogol"))){
       scoreLocal++;
       }
       if(this.incidencias.get(i).getEquipo().equals("v") && this.incidencias.get(i).getTipo().toLowerCase().contains("gol")&& (!this.incidencias.get(i).getTipo().toLowerCase().equals("autogol"))){
       scoreVisita++;
       }
       if(this.incidencias.get(i).getEquipo().equals("v") && this.incidencias.get(i).getTipo().toLowerCase().equals("autogol")){
       scoreLocal++;
       }
       if(this.incidencias.get(i).getEquipo().equals("l") && this.incidencias.get(i).getTipo().toLowerCase().equals("autogol")){
       scoreVisita++;
       }
       
       if(scoreLocal>scoreVisita){
       ganador = local;
       }else{
       ganador = visita;
       }
       
           this.setGanador(ganador);
           this.setScoreLocal(scoreLocal);
           this.setScoreVisita(scoreVisita);
       }
       
       
       
   }
}
