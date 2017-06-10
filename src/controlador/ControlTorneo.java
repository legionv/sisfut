/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Equipo;
import clases.Torneo;
import clases.Usuario;
import connection.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

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
        ResultSet res;
        Torneo tr = (Torneo) obj;
        String sql = "INSERT INTO `sisfut`.`torneo`(`torNom`,`torFechIni`,`torFechFin`,`torChamp`,`tor2nd`,`tor3rd`,`torEstado`,`torDel`)VALUES('"+tr.getNombreTorneo()+"','"+tr.getFechaInicio()+"','"+tr.getFechaFin()+"','Por Det','Por Det','Por Det','Pendiente',1);"
               , msj ="";
        int idTor = 0;
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            st.executeUpdate("BEGIN WORK");
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            res = st.getGeneratedKeys();
            while(res.next()){
            idTor = res.getInt(1);
            }
            for (int i = 0; i < tr.getEquipo().size(); i++) {
                sql = "INSERT INTO `sisfut`.`compite`(`idTor`,`idEq`)VALUES("+idTor+","+tr.getEquipo().get(i).getIdEq()+");";
                st.executeUpdate(sql);
            }
            st.executeUpdate("COMMIT");
            msj = "Torneo Insertado exitosamente, pendiente de autorización";
        } catch (Exception e) {
            if (st!=null){
                try {
                    st.executeUpdate("ROLLBACK");
                } catch (Exception l) {
                }
            }
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
        Database db =new Database();
        Connection cn;
        Statement st = null;
        String sql, msj = "";
        Torneo tr = (Torneo) obj;
         try {
            Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            st.executeUpdate("BEGIN WORK");
            sql = "UPDATE `sisfut`.`torneo`\n" +
"SET\n" +
"`torNom` = '"+tr.getNombreTorneo()+"',\n" +
"`torFechIni` = '"+tr.getFechaInicio()+"',\n" +
"`torFechFin` = '"+tr.getFechaFin()+"',\n" +
"`torChamp` = 'Por Det',\n" +
"`tor2nd` = 'Por Det',\n" +
"`tor3rd` = 'Por Det',\n" +
"`torEstado` = 'Pendiente',\n" +
"`tor4th` = 'Por Det'\n" +
"WHERE `idTor` = "+tr.getIdTor()+";";
            st.executeUpdate(sql);
            sql= "DELETE from compite where idTor = " + tr.getIdTor();
            st.executeUpdate(sql);
            for (int i = 0; i < tr.getEquipo().size(); i++) {
                sql = "INSERT INTO `sisfut`.`compite`(`idTor`,`idEq`)VALUES("+tr.getIdTor()+","+tr.getEquipo().get(i).getIdEq()+");";
                st.executeUpdate(sql);
            }
            msj= "Torneo actualizado exitosamente!";
            st.executeUpdate("COMMIT");
            st.close();
            cn.close();
        } catch (Exception e) {
            msj = e.toString();
            if (st!=null){
                try {
                    st.executeUpdate("ROLLBACK");
                } catch (Exception l) {
                }
            }
        }
        
        return msj;
    }

    @Override
    public String delete(Object obj) {
        Database db =new Database();
        Connection cn;
        Statement st;
        String sql, msj = "";
        Torneo tr = (Torneo) obj;
        try {
            Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "UPDATE torneo set torDel = 0 WHERE idTor = " + tr.getIdTor();
            st.executeUpdate(sql);
            msj= "Torneo eliminado exitosamente!";
            
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
        ArrayList<Torneo> lista= new ArrayList<Torneo>();
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
             for (int i = 0; i < lista.size(); i++) {
                sql = "select * from compite c inner join equipo e on e.idEq = c.idEq where c.idTor = " + lista.get(i).getIdTor();
                res = st.executeQuery(sql);
                while(res.next()){
                lista.get(i).agregarEquipo(new Equipo(res.getInt("idEq"), 
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
