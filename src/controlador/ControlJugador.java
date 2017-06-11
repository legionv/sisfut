/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Jugador;
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
public class ControlJugador {
    
    
    public ArrayList<Jugador> getJugadores(int idEq){
    ArrayList<Jugador> jugs = new ArrayList<Jugador>();
    Statement st = null;
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
                //jugs.add(e);
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
