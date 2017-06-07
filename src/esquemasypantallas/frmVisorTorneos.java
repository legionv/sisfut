/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esquemasypantallas;

import javax.swing.JDesktopPane;

/**
 *
 * @author Luis
 */
public class frmVisorTorneos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmVisorTorneos
     */
    public frmVisorTorneos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnNewTorneo = new javax.swing.JButton();
        jBtnMostrarDet = new javax.swing.JButton();
        jBtnAutorizar = new javax.swing.JButton();

        setClosable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tigers Cup", "25/05/17", "15/06/17", "Proceso", "Pendiente"},
                {"Lions Cup", "12/02/17", "30/03/17", "Completado", "Boca Juniors"},
                {"Gold Cup", "01/04/17", "30/04/17", "Pendiente", "Pendiente"}
            },
            new String [] {
                "Torneo", "Fecha Inicio", "Fecha Fin", "Estado", "Campeon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jBtnNewTorneo.setText("Crear Nuevo Torneo");

        jBtnMostrarDet.setText("Mostrar Detalles");
        jBtnMostrarDet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnMostrarDetMouseClicked(evt);
            }
        });

        jBtnAutorizar.setText("Autorizar Torneo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jBtnNewTorneo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnMostrarDet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAutorizar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNewTorneo)
                    .addComponent(jBtnMostrarDet)
                    .addComponent(jBtnAutorizar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnMostrarDetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnMostrarDetMouseClicked
        // TODO add your handling code here:
          
        
        int indext= this.jTable1.getSelectedRow();
        int indexm = this.jTable1.convertRowIndexToModel(indext);
        if( indexm != -1){
      frmDetalleTorneo obj = new frmDetalleTorneo();
        JDesktopPane pane =getDesktopPane();
        pane.add(obj);
        obj.setVisible(true);
        
        }
    }//GEN-LAST:event_jBtnMostrarDetMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAutorizar;
    private javax.swing.JButton jBtnMostrarDet;
    private javax.swing.JButton jBtnNewTorneo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
