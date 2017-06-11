/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esquemasypantallas;

import clases.Partido;
import clases.Torneo;
import clases.Utilidades;
import controlador.ControlPartido;
import esquemasypantallas.frmInternal.frmModPart;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class frmDetalleTorneo extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmDetalleTorneo
     */
    public frmDetalleTorneo(Torneo tr) {
        initComponents();
        this.tr = tr;
        jTxtTorneo.setText(this.tr.getNombreTorneo());
        ControlPartido cp = new ControlPartido();
        jTxtEsta.setText(this.tr.getTorEstado());
        jTxtFechIn.setText(this.tr.getFechaInicio());
        jTxtFechEnd.setText(this.tr.getFechaFin());
        jTxtLugar3.setText(this.tr.getTercero());
        jTxtLug2.setText(this.tr.getSugundo());
        jTxtCam.setText(this.tr.getCampeon());
        jTxtcuarto.setText(this.tr.getCuarto());
        loadData(cp.show(tr));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnDetalle = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtFechIn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtLug2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtLugar3 = new javax.swing.JTextField();
        jTxtTorneo = new javax.swing.JTextField();
        jTxtGole = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaPartidos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtEsta = new javax.swing.JTextField();
        jTxtCam = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtFechEnd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtcuarto = new javax.swing.JTextField();
        jBtnMod = new javax.swing.JButton();

        setClosable(true);

        jBtnDetalle.setText("Ver Detalle Partido");
        jBtnDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnDetalleMouseClicked(evt);
            }
        });

        jLabel3.setText("Campeon");

        jLabel4.setText("3er Lugar");

        jLabel5.setText("2do Lugar");

        jLabel6.setText("Goleador");

        jTxtFechIn.setEnabled(false);

        jLabel1.setText("Torneo");

        jTxtLug2.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Partidos");

        jTxtLugar3.setEnabled(false);

        jTxtTorneo.setEnabled(false);
        jTxtTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTorneoActionPerformed(evt);
            }
        });

        jTxtGole.setEnabled(false);

        jTablaPartidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"17/05/17", "Metapan", "2-0", "semifinal", "Metapan", "Santa tecla"},
                {"12/04/17", "La union", "1-2", "primera", "la union", "soyapango"},
                {"20/05/17", "venus", "2-3", "segunda", "venus", "jupiter"},
                {"25/06/17", "marte", "0-1", "cuartos", "marte", "saturno"}
            },
            new String [] {
                "Fecha", "Ganador", "Puntaje", "Jornada", "Equipo Visita", "Equipo Local"
            }
        ));
        jScrollPane1.setViewportView(jTablaPartidos);

        jLabel7.setText("Fecha Inicio:");

        jLabel8.setText("Fecha Fin:");

        jTxtEsta.setEnabled(false);

        jTxtCam.setEnabled(false);

        jLabel9.setText("Estado");

        jTxtFechEnd.setEnabled(false);

        jLabel10.setText("4to Lugar");

        jTxtcuarto.setEnabled(false);

        jBtnMod.setText("Modificar");
        jBtnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnModMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtEsta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtGole, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtFechEnd))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtFechIn)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtCam))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtLug2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtLugar3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtcuarto)))
                                .addGap(81, 81, 81))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jBtnDetalle)
                .addGap(18, 18, 18)
                .addComponent(jBtnMod)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTxtTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel3)
                                .addComponent(jTxtFechIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jTxtLugar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtLug2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jTxtGole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTxtFechEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jTxtcuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDetalle)
                    .addComponent(jBtnMod))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTorneoActionPerformed

    private void jBtnDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnDetalleMouseClicked
        // TODO add your handling code here:
        int index = this.jTablaPartidos.convertRowIndexToModel(this.jTablaPartidos.getSelectedRow());
        if(index != -1){
        frmDetallePartido obj = new frmDetallePartido();
         
            JDesktopPane pane = getDesktopPane();
            pane.add(obj);
            obj.setVisible(true);
               
        }
    }//GEN-LAST:event_jBtnDetalleMouseClicked

    private void jBtnModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnModMouseClicked
        // TODO add your handling code here:
        int i = this.jTablaPartidos.getSelectedRow();
        Utilidades util = new Utilidades();
        Object item = this.jTablaPartidos.getValueAt(i, 5);
        frmModPart obj = new frmModPart(((Partido)item) );
        JDesktopPane pane = getDesktopPane();
        util.openForm(obj, pane);
    }//GEN-LAST:event_jBtnModMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDetalle;
    private javax.swing.JButton jBtnMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaPartidos;
    private javax.swing.JTextField jTxtCam;
    private javax.swing.JTextField jTxtEsta;
    private javax.swing.JTextField jTxtFechEnd;
    private javax.swing.JTextField jTxtFechIn;
    private javax.swing.JTextField jTxtGole;
    private javax.swing.JTextField jTxtLug2;
    private javax.swing.JTextField jTxtLugar3;
    private javax.swing.JTextField jTxtTorneo;
    private javax.swing.JTextField jTxtcuarto;
    // End of variables declaration//GEN-END:variables
    private Torneo tr;
    
    public void loadData(ArrayList<Partido> part){
        String[] cols = {"Fecha","Equipo Visita","Puntaje","Equipo Local","Ganador","Jornada"};
        DefaultTableModel tb = new DefaultTableModel(null,cols);
        Object[] obj = new Object[6];
        for (int i = 0; i < part.size(); i++) {
            
            
           
            obj[0] = ((obj[0] = part.get(i).getFecha()) != "null") ? obj[0] : "Sin Fecha" ;           
            obj[1] = part.get(i).getEquipoVisita();
            obj[2] = part.get(i).getScoreVisita() + " - " + part.get(i).getScoreLocal();
            obj[3] = part.get(i).getEquipoLocal();
            obj[4] = part.get(i).getGanador();
            obj[5] = part.get(i);
            tb.addRow(obj);
        }
        
        this.jTablaPartidos.setModel(tb);
        
    }



}
