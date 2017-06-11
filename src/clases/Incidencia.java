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
public class Incidencia {
    private int idPart;
    private Partido part;
    private int idJug;
    private Jugador jugador;
    private String minuto;
    private String tiempo;
    private String tipo;
    private String equipo;
    public Incidencia() {
    }

    public Incidencia(int idPart, Partido part, int idJug, Jugador jugador, String minuto, String tiempo, String tipo, String equipo) {
        this.idPart = idPart;
        this.part = part;
        this.idJug = idJug;
        this.jugador = jugador;
        this.minuto = minuto;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.equipo = equipo;
    }

  

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getIdPart() {
        return idPart;
    }

    public void setIdPart(int idPart) {
        this.idPart = idPart;
    }

    public Partido getPart() {
        return part;
    }

    public void setPart(Partido part) {
        this.part = part;
    }

    public int getIdJug() {
        return idJug;
    }

    public void setIdJug(int idJug) {
        this.idJug = idJug;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

  

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
