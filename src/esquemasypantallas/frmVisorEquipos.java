/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esquemasypantallas;

import clases.Equipo;
import clases.Utilidades;
import controlador.ControlEquipo;
import esquemasypantallas.frmInternal.frmModEquipo;
import esquemasypantallas.frmInternal.frmRegistroEquipo;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class frmVisorEquipos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmVisorEquipos
     */
    public frmVisorEquipos() {
        initComponents();
        ControlEquipo ce = new ControlEquipo();
        llenarTabla(ce.show());
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jBtnMod = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxtFiltnom = new javax.swing.JTextField();

        setClosable(true);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Futbol Club Barcelona", "Rojo, Azul", "Roy Hodgson"},
                {"Real Madrid", "Blanco", "Martin O'Neill"},
                {"Manchester United", "Rojo", "Marcelo Biesla"},
                {"Club Atletico de Madrid", "Gris,Negro", "Joachim Loew"},
                {"Arsenal", "Negro,blanco", "Ottmar Hitzfeld"},
                {"Inter de Milan", "Blanco,Negro", "Adenor Leonardo"},
                {"Valencia", "Amarillo,Blanco", "Cesare Prandelli"}
            },
            new String [] {
                "Nombre", "Color", "Entrenador"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Agregar Equipo");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Ver Detalle");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jBtnMod.setText("Modificar");
        jBtnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnModMouseClicked(evt);
            }
        });

        jLabel1.setText("Filtrar Resultado");

        jTxtFiltnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFiltnomKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTxtFiltnom, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtFiltnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jBtnMod))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        frmDetalleEquipo eq = new frmDetalleEquipo();
        JDesktopPane p = getDesktopPane();
        p.add(eq);
        eq.setVisible(true);
        
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        frmRegistroEquipo obj = new frmRegistroEquipo();
        JDesktopPane pane = getDesktopPane();
        pane.add(obj);
        obj.setVisible(true);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jBtnModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnModMouseClicked
       
        int i = this.jTable2.getSelectedRow();
        if (i != -1) {
            Equipo eq = (Equipo) this.jTable2.getValueAt(i, 1);
            frmModEquipo obj = new frmModEquipo(eq);
        JDesktopPane pane = getDesktopPane();
        pane.add(obj);
        obj.setVisible(true);
        }
        
    }//GEN-LAST:event_jBtnModMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
         int i = this.jTable2.getSelectedRow();
        if (i != -1) {
            Equipo eq = (Equipo) this.jTable2.getValueAt(i, 1);
            int idEq = eq.getIdEq();
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTxtFiltnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFiltnomKeyTyped
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_jTxtFiltnomKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnMod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTxtFiltnom;
    // End of variables declaration//GEN-END:variables

 public void llenarTabla(ArrayList<Equipo> equipos){
  
  
 String [] columnas = {"Entrenador","Nombre","Email","Direccion","Numero Tarjeta","Fecha Inscripcion","Telefono","Color"};
Object [] obj = new Object [8];
DefaultTableModel tm= new DefaultTableModel(null,columnas);
  
           for (int i = 0; i < equipos.size(); i++) {
               obj[0] = equipos.get(i).getIdEntrenador();
               obj[1] = equipos.get(i);
         obj[2] = equipos.get(i).getEmail();
         obj[3] = equipos.get(i).getDireccion();
         obj[4] = equipos.get(i).getNumeroTar();
         obj[5] = equipos.get(i).getFecha();
         obj[6] = equipos.get(i).getTelefono();
         obj[7] = equipos.get(i).getColor();
         
         tm.addRow(obj);
     }
          this.jTable2.setModel(tm);
     
 }

  public void filtrar(){
 
     String filtro = this.jTxtFiltnom.getText();
     
     ControlEquipo eq = new ControlEquipo();
     llenarTabla(eq.filtrar(filtro));
 }
 public void reset(){
  try {
            ControlEquipo ce = new ControlEquipo();
            ArrayList<Equipo> e = ce.show();
            llenarTabla(e);
        } catch (Exception e) {
        }
 }
}


