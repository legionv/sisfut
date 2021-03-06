/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Equipo;
import clases.Incidencia;
import clases.Partido;
import clases.Torneo;
import clases.Usuario;
import clases.Utilidades;
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
        Connection cn = null;
        Statement st = null;
        String sql, msj = "";
        Torneo tr = (Torneo) obj;
        Incidencia in;
        try {
            Class.forName(db.getDriver());
            cn = (Connection)DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "UPDATE torneo set torDel = 0 WHERE idTor = " + tr.getIdTor();
            st.executeUpdate("BEGIN WORK");
            st.executeUpdate(sql);
            sql= "DELETE from compite where idTor = " + tr.getIdTor();
            st.executeUpdate(sql);
            for (int i = 0; i < tr.getPartido().size(); i++) {
                for (int j = 0; j < tr.getPartido().get(i).getIncidencias().size(); j++) {
                    in = tr.getPartido().get(i).getIncidencias().get(j);
                     System.out.println(in.getIdInc());
                     if (in.getTipo().toLowerCase().contains("gol")) {
                  
                sql = "delete from gol where idInc = " + in.getIdInc();
                 
            }else if (in.getTipo().toLowerCase().contains("tarjeta")) {
                sql = "delete from tarjeta where idInc = " + in.getIdInc();
                
            }else{
            sql = "delete from tiros where idInc = " + in.getIdInc();
            
            }
                    
                     st.executeUpdate(sql);
                     sql = "delete from incidencia where idInc = " + in.getIdInc();
                     st.executeUpdate(sql);
                }
                sql = "delete from partido where idTor = "+tr.getIdTor();
                st.executeUpdate(sql);
            }
        st.executeUpdate("COMMIT");
            msj= "Torneo eliminado exitosamente!";
            st.close();
            cn.close();
        } catch (Exception e) {
            try {
                if (st != null) {
                    st.executeUpdate("ROLLBACK");
                    st.close();
                    cn.close();
                }
            } catch (SQLException s) {
            }
            msj = e.toString();
            System.out.println(e.getStackTrace()[0].getLineNumber());
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
            ControlPartido cp = new ControlPartido();
            ControlIncidencia ci = new ControlIncidencia();
            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).setPartido(cp.show(lista.get(i)));
                for (int j = 0; j < lista.get(i).getPartido().size(); j++) {
                    lista.get(i).getPartido().get(j).setIncidencias(ci.getIncidencias(lista.get(i).getPartido().get(j)));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
        
    }
        
     public ArrayList filtrar(String filtro,String radio,String fecha1,String fecha2){
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
            sql= "select * from torneo where (torNom like '%"+filtro+"%' or torChamp like '%"+filtro+"%' or torEstado like '%"+filtro+"%') and torDel = 1";
            final String regex = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
            if (fecha1.matches(regex)  && fecha2.matches(regex)) {
                sql += "  and ("+radio+" between '"+fecha1+"' and '"+fecha2+"')";
                
            }
            
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
              ControlPartido cp = new ControlPartido();
            ControlIncidencia ci = new ControlIncidencia();
            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).setPartido(cp.show(lista.get(i)));
                for (int j = 0; j < lista.get(i).getPartido().size(); j++) {
                    lista.get(i).getPartido().get(j).setIncidencias(ci.getIncidencias(lista.get(i).getPartido().get(j)));
                }
            }
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
        
        
    
    }
    
    public String autorizarTorneo(Torneo tr){
    String msj = "";
    Database db = new Database();
    Connection cn = null;
    Statement st = null;
    String sql = "";
    Utilidades util = new Utilidades();
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st= (Statement) cn.createStatement();
            st.executeUpdate("BEGIN WORK");
            sql= "UPDATE torneo set torEstado = 'Primera' WHERE idTor = " + tr.getIdTor();
            st.executeUpdate(sql);
            
            String[] sqlPartidos =util.Emparejar(tr);
            for (int i = 0; i < sqlPartidos.length; i++) {
                st.executeUpdate(sqlPartidos[i]);
            }
             
            
            msj="Torneo Autorizado Exitosamente!\nPartidos de primera jornada generados exitosamente!";
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
    
    public String SegundaJornada(Torneo tr){
    String msj = "";
    Database db = new Database();
    Connection cn = null;
    Statement st = null;
    String sql = "";
    ArrayList<String> sqlCompite = setPuntos(tr.getPartido(), "Primera");
        try {
             Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st= (Statement) cn.createStatement();
            st.executeUpdate("BEGIN WORK");
            sql = "UPDATE `sisfut`.`torneo` SET `torEstado` = 'Segunda' WHERE `idTor` = "+tr.getIdTor()+";";
            st.executeUpdate(sql);
            for (int i = 0; i < sqlCompite.size(); i++) {
                st.execute(sqlCompite.get(i));
            }
            for (int i = 0; i < tr.getPartido().size(); i++) {
            sql =   "INSERT INTO `sisfut`.`partido`(`idTor`,`idEqVis`,`idEqLoc`,`partEstado`,`partJornada`,`partGanador`,`partScoreLoc`,`partScoreVis`)VALUES("+tr.getIdTor()+","+tr.getPartido().get(i).getIdEqLoc()+","+tr.getPartido().get(i).getIdEqVis()+",'Pendiente','Segunda','Por Det',0,0);";    
               st.executeUpdate(sql);
            }
            st.execute("COMMIT");
            msj = "Jornada completada exitosamente, partidos de la segunda jornada generados y puntos actualizados!";
            st.close();
            cn.close();
        } catch (Exception e) {
            try {
                 if (st != null) {
                st.close();
                
            }
            if (cn != null) {
                cn.close();
            }
            } catch (SQLException s) {
                System.out.println(s.toString());
            }
            msj = e.toString();
            System.out.println(e.getStackTrace()[0].getLineNumber());
        }
     return msj;
    }
    
    
    public ArrayList<String> setPuntos(ArrayList<Partido> p, String jor){
        int pv = 0;
        int pl = 0;
        ArrayList<String> sql =new ArrayList<String>();
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getJornada().equalsIgnoreCase(jor)) {
                if (p.get(i).getScoreLocal()>p.get(i).getScoreVisita()) {
                    
                    pl=3;
                }else if (p.get(i).getScoreLocal()<p.get(i).getScoreVisita()) {
                 pv = 3;
                   
            } else if (p.get(i).getScoreLocal()==p.get(i).getScoreVisita()) {
                    pv=1;
                    pl=1;
                }
               sql.add( "UPDATE `sisfut`.`compite` SET `puntos` = (`puntos` + "+pl+") WHERE idTor = "+p.get(i).getIdTor()+" and idEq = "+p.get(i).getIdEqLoc()+";"); 
               sql.add( "UPDATE `sisfut`.`compite` SET `puntos` = (`puntos` + "+pv+") WHERE idTor = "+p.get(i).getIdTor()+" and idEq = "+p.get(i).getIdEqVis()+";"); 
            }
            
            
            
        }
    
       return sql;
    }
}
