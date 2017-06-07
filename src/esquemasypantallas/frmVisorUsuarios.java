/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esquemasypantallas;

import clases.Usuario;
import connection.Database;
import controlador.ControlUsuario;
import esquemasypantallas.frmInternal.frmModUser;
import esquemasypantallas.frmInternal.frmUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author Luis
 */
public class frmVisorUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmVisorUsuarios
     */
    public frmVisorUsuarios() {
        
        initComponents();
        try {
            ControlUsuario cu = new ControlUsuario();
            ArrayList<Usuario> u = cu.show();
            llenarTabla(u);
        } catch (Exception e) {
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnMod = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTxtFiltnom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setVisible(true);

        jButton1.setText("Agregar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        btnMod.setText("Modificar");
        btnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModMouseClicked(evt);
            }
        });

        jTxtFiltnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFiltnomKeyTyped(evt);
            }
        });

        jLabel1.setText("Filtrar Resultado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTxtFiltnom, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtFiltnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnMod))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModMouseClicked
    modUser();
       
    }//GEN-LAST:event_btnModMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          frmUser obj = new frmUser();
        obj.setVisible(true);
        JDesktopPane p = getDesktopPane();
        p.add(obj);
        obj.setVisible(true);
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTxtFiltnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFiltnomKeyTyped
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_jTxtFiltnomKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTxtFiltnom;
    // End of variables declaration//GEN-END:variables
 public void llenarTabla(ArrayList<Usuario> usuarios){
  
  
 String [] columnas = {"idUser","Nombre","Apellido","Usuario","Nivel"};
Object [] obj = new Object [5];
DefaultTableModel tm= new DefaultTableModel(null,columnas);
  
  
 
  
     try {
        
         
           for (int i = 0; i < usuarios.size(); i++) {
               obj[0] = usuarios.get(i).getIdUser();
         obj[1] = usuarios.get(i).getNombre();
         obj[2] = usuarios.get(i).getApellido();
         obj[3] = usuarios.get(i).getUsuario();
         obj[4] = usuarios.get(i).getNivel();
         
         tm.addRow(obj);
     }
         
     this.jTable2.setModel(tm);
     //TableColumnModel tcm = this.jTable2.getColumnModel();
     //tcm.removeColumn(tcm.getColumn(0));
     } catch (Exception e) {
         JOptionPane.showMessageDialog(rootPane, e.toString());
     }
 
   
     
 }

 public void modUser(){
         int fila = this.jTable2.getSelectedRow();
         ControlUsuario cu = new ControlUsuario();
        if (fila != -1) {
            /* Usuario u = new Usuario();
        u.setNombre(String.valueOf(this.jTable2.getValueAt(fila, 0)));
        u.setApellido(String.valueOf(this.jTable2.getValueAt(fila, 1)));
        u.setUsuario(String.valueOf(this.jTable2.getValueAt(fila, 2)));
        u.setNivel(String.valueOf(this.jTable2.getValueAt(fila, 3)));*/
        Usuario u = new Usuario();
        u = (Usuario) cu.crearUser(Integer.parseInt(String.valueOf(this.jTable2.getValueAt(fila, 0))));
           frmModUser eq = new frmModUser(u);
        JDesktopPane p = getDesktopPane();
        p.add(eq);
        eq.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un item de la lista antes!","Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
 }

 public void filtrar(){
 
     String filtro = this.jTxtFiltnom.getText();
     
     ControlUsuario cu = new ControlUsuario();
     llenarTabla(cu.filtrar(filtro));
 }
 
   
}
