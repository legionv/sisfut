/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Madeline
 */
public class Equipo {
    private int idEq;
    private int IdEntrenador;
    private String Entrenador;
    private String email ;
    private String Direccion;
    private int numeroTar;
    private String fecha;
    private String telefono;
    private String color;
    private String nombre;

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public Equipo(int idEq, int IdEntrenador, String Entrenador, String email, String Direccion, int numeroTar, String fecha, String telefono, String color, String nombre) {
        this.idEq = idEq;
        this.IdEntrenador = IdEntrenador;
        this.Entrenador = Entrenador;
        this.email = email;
        this.Direccion = Direccion;
        this.numeroTar = numeroTar;
        this.fecha = fecha;
        this.telefono = telefono;
        this.color = color;
        this.nombre = nombre;
    }

    public int getIdEq() {
        return idEq;
    }

    public void setIdEq(int idEq) {
        this.idEq = idEq;
    }

 

 

    public int getIdEntrenador() {
        return IdEntrenador;
    }

    public String getEntrenador() {
        return Entrenador;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getNumeroTar() {
        return numeroTar;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getColor() {
        return color;
    }

    public void setIdEntrenador(int IdEntrenador) {
        this.IdEntrenador = IdEntrenador;
    }

    public void setEntrenador(String Entrenador) {
        this.Entrenador = Entrenador;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setNumeroTar(int numeroTar) {
        this.numeroTar = numeroTar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return this.nombre;
 }
 
    
}
