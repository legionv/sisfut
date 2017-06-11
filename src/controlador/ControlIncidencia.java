/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Incidencia;
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
        ResultSet res;
        Incidencia in = (Incidencia) obj;
        String sql = "INSERT INTO `sisfut`.`incidencia`\n" +
"(`idPart`,\n" +
"`idJug`,\n" +
"`minuto`,\n" +
"`tiempo`)\n" +
"VALUES\n" +
""+in.getPart().getIdPart()+",\n" +
""+in.getJugador().getIdJug()+",\n" +
""+in.getMinuto()+",\n" +
""+in.getTiempo()+");"
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
            //for (int i = 0; i < tr.getEquipo().size(); i++) {
                //sql = "INSERT INTO `sisfut`.`compite`(`idTor`,`idEq`)VALUES("+idTor+","+tr.getEquipo().get(i).getIdEq()+");";
                st.executeUpdate(sql);
            //}
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
