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
public class Entrenador extends Usuario{
    private int idEnt;

    public Entrenador() {
    }

    public Entrenador(int idEnt, int idUser, String usuario, String contra, String nombre, String apellido, String nivel, String dui, String email, String tel, String fechaNac) {
        super(idUser, usuario, contra, nombre, apellido, nivel, dui, email, tel, fechaNac);
        this.idEnt = idEnt;
    }

    public int getIdEnt() {
        return idEnt;
    }

    public void setIdEnt(int idEnt) {
        this.idEnt = idEnt;
    }
    
    
}
