/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Equipo;
import clases.Jugador;
import connection.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class ControlJugador implements OperacionesDB{
     @Override
    public String insert(Object obj) {
       Jugador ju = (Jugador) obj;
       Database db =new Database();
       Connection cn;
       ResultSet res;
       Statement st = null;
       String sql, msj;
       int id = 0;
       
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            st.executeUpdate("BEGIN WORK");
            sql = "INSERT INTO `sisfut`.`jugador`\n" +
"(`jugNom`,`jugDui`,`jugPos`,`jugFnac`,`jugEmail`,`jugNumTar`,`jugNum`,`jugTel`)\n" +
"VALUES\n" +
"('"+ju.getNombre()+"','"+ju.getDui()+"','"+ju.getPos()+"','"+ju.getFechaNac()+"','"+ju.getEmail()+"','"+ju.getTarjeta()+"','"+ju.getCamiseta()+"','"+ju.getTel()+"','"+"',NOW(),1);";
            
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            res = st.getGeneratedKeys();
            while (res.next()) {
                id = res.getInt(1);
                
            }
                      
            msj = "Jugador agregado exitosamente!";
            st.executeUpdate("COMMIT");
            st.close();
            cn.close();
        } catch (Exception e) {
            msj = e.toString();
           try {
               st.executeUpdate("ROLLBACK");
           } catch (SQLException ex) {
               
           }
        }
        
        
        return msj;
    }    
    
    
    @Override
    public String update(Object obj) {
           Jugador ju = (Jugador) obj;
       Database db =new Database();
       Connection cn;
       ResultSet res;
       Statement st = null;
       String sql, msj;
        try {
             Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "UPDATE `sisfut`.`jugador`\n" +
"SET\n" +
"`jugNom` = '"+ju.getNombre()+"',\n" +
"`jugDui` = '"+ju.getDui()+"',\n" +
"`jugPos` = '"+ju.getPos()+"',\n" +
"`jugFnac` = '"+ju.getFechaNac()+"',\n" +
"`jugEmail` = '"+ju.getEmail()+"',\n" +
"`jugNumTar` = '"+ju.getTarjeta()+"',\n" +
"`jugNum` = '"+ju.getCamiseta()+"',\n" +
"`jugTel` = '"+ju.getTel()+"',\n" +
" WHERE `idJug` = "+ju.getIdJug();
            st.executeUpdate(sql);
            msj = "Jugador modificado exitosamente!";
            st.close();
            cn.close();
        } catch (Exception e) {
            msj = e.toString();
        }
       return msj;
    }

    @Override
    public String delete(Object obj) {
        Jugador ju = (Jugador) obj;
       Database db =new Database();
       Connection cn;
       ResultSet res;
       Statement st = null;
       String sql, msj;
        try {
           Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "Update jugador set jugDel = 0 where idJug = " + ju.getIdJug();
            st.executeUpdate(sql);
            
            msj = "Jugador eliminado exitosamente!";
            st.close();
            cn.close();
            
        } catch (Exception e) {
            msj = e.toString();
        }
        
        return msj;
    }

    @Override
    public ArrayList show() {
        Database db =new Database();
        Connection cn;
        Statement st;
        ResultSet res;
        String sql;
          Equipo eq;
    ControlEquipo ce = new ControlEquipo();
        ArrayList lista= new ArrayList();
        try {
            Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql= "select * from jugador where jugDel != 0";
            res = st.executeQuery(sql);
            while (res.next()) {
                 eq = ce.crearEquipo(res.getInt("idEq"));
                lista.add(new Jugador(res.getInt("idJug"), res.getInt("idEq"), res.getString("jugNom"), res.getInt("jugNum"), res.getString("jugTel") ,res.getString("jugEmail"), res.getString("jugNumTar"), String.valueOf(res.getDate("jufFnac")), res.getString("jugPos"), res.getString("jugDui"), eq)
                        
                );
                
                
            }
          
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public Object crearJugador(int id){
    Database db = new Database();
    Connection cn;
    Statement st;
    ResultSet res;
    String sql;
    Jugador ju = new Jugador();
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "select * from jugador where idJug = "+ id;
            res = st.executeQuery(sql);
            while (res.next()) {
                ju.setIdJug(res.getInt("idJug"));
                ju.setNombre(res.getString("jugNom"));
                ju.setDui(res.getString("jugDui"));
                ju.setPos(res.getString("jugPos"));
                ju.setFechaNac(res.getString("jugFnac"));
                ju.setEmail(res.getString("jugEmail"));
                ju.setTarjeta(res.getString("jugNumTar"));
                ju.setCamiseta(res.getInt("jugNum"));
                ju.setTel(res.getString("jugTel"));
                
                
            }
            
            res.close();
            st.close();
            cn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      return ju;
    }
    
    public ArrayList filtrar(String filtro){
    Database db =new Database();
        Connection cn;
        Statement st;
        ResultSet res;
        String sql;
        Equipo eq;
        ControlEquipo ce = new ControlEquipo();
        ArrayList lista= new ArrayList();
        try {
            Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql= "select * from jugador where (JugNom like '%"+filtro+"%' or jugNum like '%"+filtro+"%' or userDui like '%"+filtro+"%' or jugTel like '%"+filtro+"%') and jugDel = 1";
            res = st.executeQuery(sql);
            while (res.next()) {
                eq = ce.crearEquipo(res.getInt("idEq"));
                lista.add(new Jugador(res.getInt("idJug"), res.getInt("idEq"), res.getString("jugNom"), res.getInt("jugNum"), res.getString("jugTel") ,res.getString("jugEmail"), res.getString("jugNumTar"), String.valueOf(res.getDate("jufFnac")), res.getString("jugPos"), res.getString("jugDui"), eq) 
                        
                );
                
                
            }
          
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
        
        
    
    }
    
    public ArrayList<Jugador> getJugadores(int idEq){
    ArrayList<Jugador> jugs = new ArrayList<Jugador>();
    Statement st = null;
    Equipo eq;
    ControlEquipo ce = new ControlEquipo();
    Connection cn = null;
    ResultSet res = null;
    Database db = new Database();
    String sql = "";
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "select * from jugador where idEq= " + idEq;
            res = st.executeQuery(sql);
            while (res.next()) {
                     eq = ce.crearEquipo(res.getInt("idEq"));
                jugs.add(
                new Jugador(res.getInt("idJug"), res.getInt("idEq"), res.getString("jugNom"), res.getInt("jugNum"), res.getString("jugTel") ,res.getString("jugEmail"), res.getString("jugNumTar"), String.valueOf(res.getDate("jugFnac")), res.getString("jugPos"), res.getString("jugDui"), eq)
                );
            }
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    return jugs;
    }
}
