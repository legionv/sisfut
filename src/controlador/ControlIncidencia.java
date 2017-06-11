/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Incidencia;
import clases.Jugador;
import clases.Partido;
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
public class ControlIncidencia implements OperacionesDB{

    @Override
    public String insert(Object obj) {
         Database db = new Database();
        Connection cn = null;
        //PreparedStatement stmt = null;
        Statement st = null;
        ResultSet res = null;
        Incidencia in = (Incidencia) obj;
        String sql = "INSERT INTO `sisfut`.`incidencia`\n" +
"(`idPart`,\n" +
"`idJug`,\n" +
"`minuto`,\n" +
"`tiempo`,`Eq`)\n" +
"VALUES\n" +
"("+in.getIdPart()+",\n" +
""+in.getJugador().getIdJug()+",\n" +
"'"+in.getMinuto()+"',\n" +
"'"+in.getTiempo()+"','"+in.getEquipo()+"');"
               , msj ="";
        int idInc = 0;
       
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            st.executeUpdate("BEGIN WORK");
            System.err.println(sql);
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            res = st.getGeneratedKeys();
            while(res.next()){
            idInc = res.getInt(1);
            }
            
            if (in.getTipo().toLowerCase().contains("gol")) {
                
                sql = "INSERT INTO `sisfut`.`gol`\n" +
"(\n" +
"`idInc`,\n" +
"`tipo`)\n" +
"VALUES\n" +
"(\n" +
""+idInc+",\n" +
"'"+in.getTipo()+"');";
                 
            }else if (in.getTipo().toLowerCase().contains("tarjeta")) {
                sql = "INSERT INTO `sisfut`.`tarjeta`(`idInc`,`color`)VALUES("+idInc+","+in.getTipo()+");";
                
            }else{
            sql = "INSERT INTO `sisfut`.`tiros`(`idInc`,`tipo`)VALUES("+idInc+",'"+in.getTipo()+"');";
            
            }
             System.err.println(sql);
            st.executeUpdate(sql);
            st.executeUpdate("COMMIT");
            res.close();
            st.close();
            cn.close();
            
          //st.executeUpdate("COMMIT");
            msj = "Incidencia insertada exitosamente!";
        } catch (Exception e) {
             msj = e.toString();
             System.out.println(msj);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(Object obj) {
        Incidencia in = (Incidencia) obj;
        Statement st = null;
        Database db = new Database();
        Connection cn = null;
        String sql = "";
        String msj = "";
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
               if (in.getTipo().toLowerCase().contains("gol")) {
                     sql = "delete from gol where idInc = " + in.getIdInc();
               st.executeUpdate(sql);
                }else if (in.getTipo().toLowerCase().contains("tarjeta")) {
                    sql = "delete from tarjeta where idInc = " + in.getIdInc();
               st.executeUpdate(sql);
                }else{
                sql = "delete from tiros where idInc = " + in.getIdInc();
               st.executeUpdate(sql);
                
                }
              sql = "delete from incidencia where idInc = " + in.getIdInc();
               st.executeUpdate(sql);
               st.close();
               cn.close();
                System.err.println(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        
            return msj; 
    }

    @Override
    public ArrayList show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Incidencia> getIncidencias(Partido p){
        ArrayList<Incidencia> ins = new ArrayList<Incidencia>();
        Database db = new Database();
        Connection cn = null;
        Statement st = null;
        ResultSet res = null;
        Jugador jug;
        ControlJugador cj= new ControlJugador();
        String sql = "";
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "select * from incidencia i inner join gol g on g.idInc = i.idInc  where i.idPart = "  + p.getIdPart();
            res = st.executeQuery(sql);
            while (res.next()) {
                jug = (Jugador) cj.crearJugador(res.getInt("idJug"));
                ins.add(new Incidencia(res.getInt("idPart"), res.getInt("idInc"), p, res.getInt("idJug"), jug, res.getString("minuto"), res.getString("tiempo"), res.getString("tipo"), res.getString("Eq")));
            }
              sql = "select * from incidencia i inner join tiros t on t.idInc = i.idInc  where i.idPart = "  + p.getIdPart();
            res = st.executeQuery(sql);
            while (res.next()) {
                jug = (Jugador) cj.crearJugador(res.getInt("idJug"));
                ins.add(new Incidencia(res.getInt("idPart"), res.getInt("idInc"), p, res.getInt("idJug"), jug, res.getString("minuto"), res.getString("tiempo"), res.getString("tipo"), res.getString("Eq")));
            }
                 sql = "select * from incidencia i inner join tarjeta t on t.idInc = i.idInc  where i.idPart = "  + p.getIdPart();
            res = st.executeQuery(sql);
            while (res.next()) {
                jug = (Jugador) cj.crearJugador(res.getInt("idJug"));
                ins.add(new Incidencia(res.getInt("idPart"), res.getInt("idInc"), p, res.getInt("idJug"), jug, res.getString("minuto"), res.getString("tiempo"), res.getString("color"), res.getString("Eq")));
            }
            
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return ins;
    }
}
