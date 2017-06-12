/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Equipo;
import clases.Torneo;
import connection.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class ControlEquipo implements OperacionesDB{

public String insert(Object obj) {
        Database db =new Database();
        Connection cn;
        Statement st;
        ResultSet res;
        String sql; 
        String msj=null;
        Equipo equ = (Equipo) obj;
         try {
            Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = cn.createStatement();
            sql="insert into  `sisfut`.`equipo`(\n" +
"`idEnt`,\n" +
"`eqNombre`,\n" +
"`eqEmail`,\n" +
"`eqDir`,\n" +
"`eqNumTar`,\n" +
"`eqFechaIns`,\n" +
"`eqTel`,\n" +
"`eqColor`,\n" +
"`eqDel`)\n" +
"VALUES\n" +
"("+equ.getIdEntrenador()+",'"+equ.getNombre()+"','"+equ.getEmail()+"','"+equ.getDireccion()+"',\n" +
"'"+equ.getNumeroTar()+"',now(),'"+equ.getTelefono()+"','"+equ.getColor()+"',1);";    
           st.executeUpdate(sql);
           st.close();
           cn.close();
           msj="Datos insertados correctamente";
       }catch(Exception e){
           msj=e.toString();
       }
       return msj;
    }

   

    @Override
    public String update(Object obj) {
        Database db =new Database();
        Connection cn;
        Statement st;
        ResultSet res;
        String sql; 
        String msj=null;
        Equipo equ = (Equipo) obj;
         try {
            Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = cn.createStatement();
            sql="update equipo set idEnt="+equ.getIdEntrenador()+",eqEmail= '"+equ.getEmail()
                   +"', eqDir= '"+equ.getDireccion()+"', eqNumTar = '"+equ.getNumeroTar()+
                    "',eqTel = '"+equ.getTelefono()+"', eqNombre= '"+equ.getNombre()+
                    "' where idEq="+equ.getIdEq();
            System.out.println(sql);
           st.executeUpdate(sql);
             
           st.close();
           cn.close();
           msj="Datos Actualizados correctamente";
       }catch(Exception e){
           msj=e.toString();
             System.out.println(e.getStackTrace()[0].getLineNumber());
       }
       return msj;
    }

    @Override
    public String delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public ArrayList<Equipo> filtrar(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public ArrayList show() {
         Database db =new Database();
        Connection cn;
        Statement st;
        ResultSet res;
        String sql;
        ArrayList lista= new ArrayList();
        try {
            Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql= "select * from equipo where eqDel != 0";
            res = st.executeQuery(sql);
            while (res.next()) {
                lista.add( new Equipo(res.getInt("idEq"), 
                res.getInt("idEnt"), 
                        null, 
                        res.getString("eqEmail"), 
                                res.getString("eqDir"), 
                                res.getInt("eqNumTar"), 
                                        String.valueOf(res.getDate("eqFechaIns")), 
                                        res.getString("eqTel"), 
                                                res.getString("eqColor")
                                                ,res.getString("eqNombre")
                                                        ));
                 
                
            }
            for (int i = 0; i < lista.size(); i++) {
                
            }
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public Equipo crearEquipo(int idEq){
    Equipo eq = new Equipo();
    
    Database db =new Database();
        Connection cn;
        Statement st;
        ResultSet res;
        String sql;
        try {
          Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "select * from equipo where idEq = " + idEq;
            res = st.executeQuery(sql);
            while (res.next()) {                
                eq.setColor(res.getString("eqColor"));
                eq.setDireccion(res.getString("eqDir"));
                eq.setEmail(res.getString("eqEmail"));
                eq.setIdEntrenador(res.getInt("idEnt"));
                eq.setIdEq(res.getInt("idEq"));
                eq.setNumeroTar(res.getInt("eqNumTar"));
                eq.setNombre(res.getString("eqNombre"));
                eq.setTelefono(res.getString("eqTel"));
                eq.setFecha(String.valueOf(res.getDate("eqFechaIns")));
                
            }
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return eq;
    
        
    }
}
