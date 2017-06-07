/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Usuario;
import connection.Database;
import esquemasypantallas.frmMenu;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ControlUsuario implements OperacionesDB{

    @Override
    public String insert(Object obj) {
       Usuario user = (Usuario) obj;
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
            sql = "INSERT INTO `sisfut`.`usuarios`\n" +
"(`userNombre`,`userApellido`,`userName`,`userPass`,`userDui`,`userTel`,`userEmail`,`userLevel`,`userFnac`,`userFechaIns`,`userDel`)\n" +
"VALUES\n" +
"('"+user.getNombre()+"','"+user.getApellido()+"','"+user.getUsuario()+"','"+user.getContra()+"','"+user.getDui()+"','"+user.getTel()+"','"+user.getEmail()+"','"+user.getNivel()+"','"+user.getFechaNac()+"',NOW(),1);";
            
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            res = st.getGeneratedKeys();
            while (res.next()) {
                id = res.getInt(1);
                
            }
            
            if (user.getNivel().equalsIgnoreCase("entrenador")) {
                sql = "INSERT INTO `sisfut`.`entrenador` (`idUser`) VALUES ("+id+");";
                st.executeUpdate(sql);
            }
             if (user.getNivel().equalsIgnoreCase("arbitro")) {
                sql = "INSERT INTO arbitro (`idUser`) VALUES ("+id+");";
                st.executeUpdate(sql);
            }
            
            msj = "Usuario agregado exitosamente!";
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
           Usuario user = (Usuario) obj;
       Database db =new Database();
       Connection cn;
       ResultSet res;
       Statement st = null;
       String sql, msj;
        try {
             Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "UPDATE `sisfut`.`usuarios`\n" +
"SET\n" +
"`userNombre` = '"+user.getNombre()+"',\n" +
"`userApellido` = '"+user.getApellido()+"',\n" +
"`userName` = '"+user.getUsuario()+"',\n" +
"`userPass` = '"+user.getContra()+"',\n" +
"`userDui` = '"+user.getDui()+"',\n" +
"`userTel` = '"+user.getTel()+"',\n" +
"`userEmail` = '"+user.getEmail()+"',\n" +
"`userLevel` = '"+user.getNivel()+"',\n" +
"`userFnac` = '"+user.getFechaNac()+"'\n" +
" WHERE `idUser` = "+user.getIdUser();
            st.executeUpdate(sql);
            msj = "Usuario modificado exitosamente!";
            st.close();
            cn.close();
        } catch (Exception e) {
            msj = e.toString();
        }
       return msj;
    }

    @Override
    public String delete(Object obj) {
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
            sql= "select * from usuarios";
            res = st.executeQuery(sql);
            while (res.next()) {
                lista.add(new Usuario(res.getInt("idUser"), 
                        res.getString("userName"), 
                        res.getString("userPass"),
                        res.getString("userNombre"),
                        res.getString("userApellido"), 
                        res.getString("userLevel"), 
                        res.getString("userDui"),
                        res.getString("userEmail"), 
                        res.getString("userTel"), 
                        res.getString("userFnac")
                ));
                
                
            }
          
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    
    public Object crearUser(int id){
    Database db = new Database();
    Connection cn;
    Statement st;
    ResultSet res;
    String sql;
    Usuario u = new Usuario();
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "select * from usuarios where idUser = "+ id;
            res = st.executeQuery(sql);
            while (res.next()) {
                u.setIdUser(res.getInt("idUser"));
                u.setNombre(res.getString("userNombre"));
                u.setApellido(res.getString("userApellido"));
                u.setUsuario(res.getString("userName"));
                u.setContra(res.getString("userPass"));
                u.setDui(res.getString("userDui"));
                u.setTel(res.getString("userTel"));
                u.setEmail(res.getString("userEmail"));
                u.setNivel(res.getString("userLevel"));
                u.setFechaNac(res.getString("userFnac"));
                
            }
            
            res.close();
            st.close();
            cn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
      return u;
    }
    
    public ArrayList filtrar(String filtro){
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
            sql= "select * from usuarios where userNombre like '%"+filtro+"%' or userApellido like '%"+filtro+"%' or userDui like '%"+filtro+"%' or userLevel like '%"+filtro+"%'";
            res = st.executeQuery(sql);
            while (res.next()) {
                lista.add(new Usuario(res.getInt("idUser"), 
                        res.getString("userName"), 
                        res.getString("userPass"),
                        res.getString("userNombre"),
                        res.getString("userApellido"), 
                        res.getString("userLevel"), 
                        res.getString("userDui"),
                        res.getString("userEmail"), 
                        res.getString("userTel"), 
                        res.getString("userFnac")
                ));
                
                
            }
          
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
        
        
    
    }
    
}
