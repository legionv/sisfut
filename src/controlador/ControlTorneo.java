/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Torneo;
import clases.Usuario;
import connection.Database;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class ControlTorneo implements OperacionesDB {

    @Override
    public String insert(Object obj) {
        Database db = new Database();
        Connection cn = null;
        //PreparedStatement stmt = null;
        Statement st = null;
        Torneo tr = (Torneo) obj;
        String sql = "INSERT INTO `sisfut`.`torneo`(`torNom`,`torFechIni`,`torFechFin`,`torChamp`,`tor2nd`,`tor3rd`,`torEstado`,`torDel`)VALUES('"+tr.getNombreTorneo()+"','"+tr.getFechaInicio()+"','"+tr.getFechaFin()+"','Por Det','Por Det','Por Det','Pendiente',1);"
               , msj ="";
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            st.executeUpdate(sql);
           /* stmt = (PreparedStatement) cn.prepareStatement(sql);
            stmt.setString(1, tr.getNombreTorneo());
            stmt.setDate(2, Date.valueOf(tr.getFechaInicio()));
            stmt.setDate(3, Date.valueOf(tr.getFechaFin()));
            stmt.setString(4, "TBD");
            stmt.setString(5, "TBD");
            stmt.setString(6, "TBD");
            stmt.setString(7, "Pendiente");
            stmt.setInt(8, 1);
            stmt.executeUpdate();*/
            msj = "Torneo Insertado exitosamente, pendiente de autorización";
        } catch (Exception e) {
        }finally{
            try {
                if (st != null) {st.close();}
            } catch (Exception e) {
                msj += e.toString();
            }
            try {
                if(cn != null){cn.close();}
            } catch (Exception e) {
                msj += e.toString();
            }
        }
        
        
        return msj;
    }

    @Override
    public String update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            sql= "select * from torneo where torDel != 0";
            res = st.executeQuery(sql);
            while (res.next()) {
                lista.add(new Torneo(
                        res.getInt("idTor")
                        ,res.getString("torNom"),
                        String.valueOf(res.getDate("torFechIni")), 
                        String.valueOf(res.getDate("torFechFin")),
                        res.getString("torChamp"), 
                        res.getString("tor2nd"), 
                        res.getString("tor3rd"),
                        res.getString("tor4th"), 
                        res.getString("torEstado")));
                
                
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
