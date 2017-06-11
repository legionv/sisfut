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
public class Arbitro extends Usuario{
      private int idArb;

    public int getIdArb() {
        return idArb;
    }

    public void setIdArb(int idArb) {
        this.idArb = idArb;
    }

    public Arbitro() {
    }

    public Arbitro(int idArb, int idUser, String usuario, String contra, String nombre, String apellido, String nivel, String dui, String email, String tel, String fechaNac) {
        super(idUser, usuario, contra, nombre, apellido, nivel, dui, email, tel, fechaNac);
        this.idArb = idArb;
    }
      
      
}
