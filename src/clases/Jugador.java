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
public class Jugador {
    
    private String nombre;
    private int camiseta;
    private String tel;
    private String email;
    private String tarjeta;
    private String fechaNac;
    private String Pos;
    private String dui;

    public Jugador() {
    }

    public Jugador(String nombre, int camiseta, String tel, String email, String tarjeta, String fechaNac, String Pos, String dui) {
        this.nombre = nombre;
        this.camiseta = camiseta;
        this.tel = tel;
        this.email = email;
        this.tarjeta = tarjeta;
        this.fechaNac = fechaNac;
        this.Pos = Pos;
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(int camiseta) {
        this.camiseta = camiseta;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPos() {
        return Pos;
    }

    public void setPos(String Pos) {
        this.Pos = Pos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
    
    public boolean validar(){
       boolean bandera= true;
        String errores = "";
        int corre = 1;
        final String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        if(!this.fechaNac.matches(regex)){
        bandera = false;
        errores += corre +". El formato en el que ingreso la fecha es inválido\n";
        corre++;
        }
        final Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
         Matcher matcher = emailRegex.matcher(this.email);
        if(!matcher.find()){
            errores += corre + ". El Email es inválido\n";
            corre++;
        bandera = false;
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
          if(this.Pos.equals("Seleccionar")){
            errores += corre + ". Debe seleccionar una posición \n";
            corre++;
         bandera=false;
        }
             if(this.nombre.equals("")){
            errores += corre + ". El campo nombre está vacio \n";
            corre++;
         bandera=false;
        }
                if(this.tarjeta.equals("")){
            errores += corre + ". El campo Tarjeta deportiva está vacio \n";
            corre++;
         bandera=false;
        }
                  if(!bandera){
            JOptionPane.showMessageDialog(null, errores,"Los datos de entrada contienen errores de validación",1);
        }
        return bandera;
    }
}
