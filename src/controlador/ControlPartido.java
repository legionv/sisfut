/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Arbitro;
import clases.Equipo;
import clases.Incidencia;
import clases.Partido;
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
        Database db = new Database();
        Connection cn = null;
        Incidencia in = new Incidencia();
        ControlIncidencia ci = new ControlIncidencia();
        Partido par = (Partido) obj;
        ResultSet res = null;
        Statement st = null;
        String sql = "", msj = "";
        int idInc = 0;
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql= "UPDATE `sisfut`.`partido`\n" +
"SET\n" +
"`idArb` = "+par.getIdArb()+",\n" +
"`idEqVis` = "+par.getIdEqVis()+",\n" +
"`idEqLoc` = "+par.getIdEqLoc()+",\n" +
"`partFecha` = '"+par.getFecha()+"',\n" +
"`partHora` = '"+par.getHora_inicio()+"',\n" +
"`partFin` = '"+par.getHora_fin()+"',\n" +
"`partGanador` = '"+par.getGanador()+"',\n" +
"`partScoreLoc` = "+par.getScoreLocal()+",\n" +
"`partScoreVis` = "+par.getScoreVisita()+",\n" +
"`partEstado` = '"+par.getEstado()+"',\n" +
"`partJornada` = '"+par.getJornada()+"'\n" +
" WHERE `idPart` = "+par.getIdPart()+";";
            
            st.executeUpdate("BEGIN WORK");
            st.executeUpdate(sql);
            
            
            for (int i = 0; i < par.getIncidencias().size(); i++) {
               
               in = par.getIncidencias().get(i);
               
               sql = "INSERT INTO `sisfut`.`incidencia`\n" +
"(`idPart`,\n" +
"`idJug`,\n" +
"`minuto`,\n" +
"`tiempo`,`Eq`)\n" +
"VALUES\n" +
"("+par.getIdPart()+",\n" +
""+in.getIdJug()+",\n" +
"'"+in.getMinuto()+"',\n" +
"'"+in.getTiempo()+"','"+in.getEquipo()+"');";
               
                st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            res = st.getGeneratedKeys();
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
                sql = "INSERT INTO `sisfut`.`tarjeta`(`idInc`,`color`)VALUES("+idInc+",'"+in.getTipo()+"');";
                
            }else{
            sql = "INSERT INTO `sisfut`.`tiros`(`idInc`,`tipo`)VALUES("+idInc+",'"+in.getTipo()+"');";
            
            }
            
            st.executeUpdate(sql);
                
            }
            st.executeUpdate("COMMIT");
            msj = "Partido modificado exitosamente!";
            res.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            msj = e.toString();
            System.out.println(e.getStackTrace()[0].getLineNumber());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ArrayList<Partido> show(Torneo tr){
    ControlEquipo ce = new ControlEquipo();
    Database db = new Database();
    Arbitro arb;
    ArrayList<Partido> parts = new ArrayList<Partido>();
    Statement st = null;
    Connection cn = null;
    ResultSet res = null;
    Partido par;
    String sql = "";
        try {
            Class.forName(db.getDriver());
            cn = (Connection) DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            st = (Statement) cn.createStatement();
            sql = "select * from partido where idTor = "  + tr.getIdTor();
            res = st.executeQuery(sql);
            while (res.next()) {         
               /* if (res.getString("partEstado").equals("Pendiente")) {
                    par = new Partido();
                    par.setEstado(res.getString("partEstado"));
                    par.setEquipoLocal(ce.crearEquipo(res.getInt("idEqLoc")));
                    par.setEquipoVisita(ce.crearEquipo(res.getInt("idEqVis")));
                    par.setGanador(res.getString("partGanador"));
                    par.setScoreLocal(res.getInt("partScoreLoc"));
                    par.setScoreVisita(res.getInt("partScoreVis"));
                    par.setIdTor(res.getInt("idTor"));
                    par.setIdPart(res.getInt("idPart"));
                    par.setIdEqLoc(res.getInt("idEqLoc"));
                    par.setIdEqVis(res.getInt("idEqVis"));
                    par.setJornada(res.getString("partJornada"));
                    parts.add(par);
                }*/
                
                parts.add(new Partido(res.getInt("idTor"),res.getInt("idPart"), res.getInt("idEqVis"), res.getInt("idEqLoc"), res.getInt("idArb"),null, ce.crearEquipo(res.getInt("idEqVis")), ce.crearEquipo(res.getInt("idEqLoc")), res.getString("partJornada"), String.valueOf(res.getTime("partHora")), String.valueOf(res.getTime("partFin")), String.valueOf(res.getDate("partFecha")), res.getInt("partScoreLoc"), res.getInt("partScoreVis"), res.getString("partGanador"),res.getString("partEstado")));
            }
            
            res.close();
            st.close();
            cn.close();
            
        } catch (Exception e) {
            
        }
    
        
    
    return parts;
    }
    
}
