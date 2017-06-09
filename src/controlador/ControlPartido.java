/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Partido;
import clases.Torneo;
import connection.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class ControlPartido implements OperacionesDB{

    @Override
    public String insert(Object obj) {
        Database db = new Database();
        Connection cn = null;
        //PreparedStatement stmt = null;
        Statement st = null;
        Partido pr = (Partido) obj;
        String sql = "INSERT INTO `sisfut`.`partido`\n" +
"(`idTor`,\n" +
"`idEqVis`,\n" +
"`idEqLoc`,\n" +
"`partEstado`,\n" +
"`partJornada`)\n" +
"VALUES\n" +
"("+pr.getIdTor()+","+pr.getIdEqVis()+","+pr.getIdEqLoc()+",'"+pr.getEstado()+"','"+pr.getJornada()+"');"
               , msj ="";
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            st.executeUpdate(sql);
        
            msj = "Partido Generado exitosamente";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
