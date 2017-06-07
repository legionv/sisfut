/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Usuario {
    private int idUser;
    private String usuario;
    private String contra;
    private String nombre;
    private String apellido;
    private String nivel;
    private String dui;
    private String email;
    private String tel;
    private String fechaNac;

    public Usuario() {
    }

    public Usuario(int idUser, String usuario, String contra, String nombre, String apellido, String nivel, String dui, String email, String tel, String fechaNac) {
        this.idUser = idUser;
        this.usuario = usuario;
        this.contra = contra;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nivel = nivel;
        this.dui = dui;
        this.email = email;
        this.tel = tel;
        this.fechaNac = fechaNac;
    }

   

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
      public boolean validar(String pass2){
    
        boolean bandera= true;
        String errores = "";
        int corre = 1;
        final String regex = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        if(!this.fechaNac.matches(regex)){
        bandera = false;
        errores += corre +". El formato en el que ingreso la fecha es inválido debe ser aaaa-mm-dd \n";
        corre++;
        }
        final Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
         Matcher matcher = emailRegex.matcher(this.email);
        if(!matcher.find()){
            errores += corre + ". El Email es inválido\n";
            corre++;
        bandera = false;
        }
        if(!this.contra.equals(pass2)){
            errores += corre + ". La contraseña no coincide con el campo repetir contraseña \n";
            corre++;
            bandera=false;
        }
        if(this.contra.length() != 8){
            errores += corre + ". La contraseña debe de tener 8 caracteres \n";
            corre++;
            bandera=false;
        }
        if(this.contra.equals("") || pass2.equals("")){
            errores += corre + ". El campo de la contraseña no puede quedar en blanco \n";
            corre++;
         bandera=false;
        }
        if(this.usuario.equals("")){
            errores += corre + ". El campo de usuario está vacio \n";
            corre++;
         bandera=false;
        }
        if(this.nombre.equals("")){
            errores += corre + ". El campo nombre está vacio \n";
            corre++;
         bandera=false;
        }
        if(this.apellido.equals("")){
            errores += corre + ". El campo apellido está vacio \n";
            corre++;
         bandera=false;
        }
        if(this.email.equals("")){
            errores += corre + ". El campo email está vacio \n";
            corre++;
         bandera=false;
        }
        if(this.fechaNac.equals("")){
            errores += corre + ". La fecha de nacimiento está vacia \n";
            corre++;
         bandera=false;
        }
        if(this.tel.trim().length() == 1){
            errores += corre + ". El campo teléfono está vacio \n";
            corre++;
         bandera=false;
        }
        if(this.dui.trim().length() == 1){
            errores += corre + ". El campo DUI está vacio \n";
            corre++;
         bandera=false;
        }
        if(this.nivel.equals("Seleccionar")){
            errores += corre + ". Debe seleccionar un nivel de usuario \n";
            corre++;
         bandera=false;
        }
        if(!bandera){
            JOptionPane.showMessageDialog(null, errores,"Los datos de entrada contienen errores de validación",1);
        }
        return bandera;
    }
}
