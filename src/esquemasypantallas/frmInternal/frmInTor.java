/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esquemasypantallas.frmInternal;

import clases.Equipo;
import clases.Torneo;
import controlador.ControlTorneo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class frmInTor extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTorneos
     */
    public frmInTor() {
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

        jLabel4 = new javax.swing.JLabel();
        jButnAgregarEquipo = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBtnAgregarTorneo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcmbEquip = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLocal = new javax.swing.JTable();
        jTxtFechaFin = new javax.swing.JFormattedTextField();
        jTxtFechaInicio = new javax.swing.JFormattedTextField();
        jTxtNombreTorneo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jLabel4.setText("Equipo");

        jButnAgregarEquipo.setText("Agregar equipo");
        jButnAgregarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButnAgregarEquipoMouseClicked(evt);
            }
        });

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarMouseClicked(evt);
            }
        });

        jLabel1.setText("Nombre Torneo");

        jBtnAgregarTorneo.setText("Agregar Torneo");
        jBtnAgregarTorneo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAgregarTorneoMouseClicked(evt);
            }
        });

        jLabel2.setText("Fecha Inicio");

        jcmbEquip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Real Madrid", "Fútbol Club Barcelona", "Bayern de Múnich", "Juventus de Turín", "Manchester United Football Club", "Chelsea Football Club", "Club Atlético de Madrid", "Arsenal Football Club", "París Saint-Germain Football Club", "Club Atlético River Plate", "Club Atlérico Boca Juniors" }));

        jLabel3.setText("Fecha Fin");

        jTableLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipo"
            }
        ));
        jScrollPane1.setViewportView(jTableLocal);

        try {
            jTxtFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTxtFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jBtnAgregarTorneo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(43, 43, 43))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(26, 26, 26)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcmbEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTxtNombreTorneo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtFechaInicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButnAgregarEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTxtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBtnEliminar))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButnAgregarEquipo)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnEliminar)
                    .addComponent(jcmbEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jBtnAgregarTorneo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButnAgregarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButnAgregarEquipoMouseClicked
        // TODO add your handling code here:
        if(alreadyInTable(this.jcmbEquip.getSelectedItem().toString(), this.jTableLocal)){
            agregarTabla(this.jcmbEquip.getSelectedItem().toString(),this.jTableLocal);
            Remover();
        }
    }//GEN-LAST:event_jButnAgregarEquipoMouseClicked

    private void jBtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarMouseClicked
        // TODO add your handling code here:

        int index = jTableLocal.getSelectedRow();
        eliminarTabla(index,this.jTableLocal);
    }//GEN-LAST:event_jBtnEliminarMouseClicked

    private void jBtnAgregarTorneoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAgregarTorneoMouseClicked
       
            // TODO add your handling code here:
            llenarTorneo();
     
    }//GEN-LAST:event_jBtnAgregarTorneoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregarTorneo;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jButnAgregarEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLocal;
    private javax.swing.JFormattedTextField jTxtFechaFin;
    private javax.swing.JFormattedTextField jTxtFechaInicio;
    private javax.swing.JTextField jTxtNombreTorneo;
    private javax.swing.JComboBox<String> jcmbEquip;
    // End of variables declaration//GEN-END:variables
 public void llenarTorneo() {
    Torneo obj= new Torneo();
    obj.setNombreTorneo(this.jTxtNombreTorneo.getText());
    obj.setFechaInicio(this.jTxtFechaInicio.getText());
    obj.setFechaFin(this.jTxtFechaFin.getText());
    obj.setEquipo(this.agregarEquipos(jTableLocal));
    ControlTorneo cr = new ControlTorneo();
    
    if(obj.getEquipo().size() == 10){
        if(obj.validar()){
           String equipos = this.getEquipos(obj.getEquipo());
            
    /*JOptionPane.showMessageDialog(this, "Torneo Agregado Exitosamente"+
              "\n \n Nombre del Torneo :" + obj.getNombreTorneo()+
              "\n Fecha de Inicio del torneo:" + obj.getFechaInicio()+
              "\n Fecha Final del Torneo:"+obj.getFechaFin()+
            "\n" + equipos,"Torneo",1);*/
    JOptionPane.showMessageDialog(rootPane, cr.insert(obj),"Confirmación",1);
             
    }
    }
    
    
    
    
    
    }
    
    private void agregarTabla(String equipo, JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        String[] vector = new String[1];
        vector[0] = equipo;
                
        modelo.addRow(vector);
}
    
    private void eliminarTabla(int index, JTable tabla){
    
        if(index != -1){
        int mIndex = tabla.convertRowIndexToModel(index);
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.removeRow(mIndex);
        }
    }
     private boolean alreadyInTable(String name, JTable tabla){
       DefaultTableModel model = (DefaultTableModel) tabla.getModel();
       int c = model.getColumnCount();
       int r = model.getRowCount();
       boolean band = true;
       String aux = "";
       ArrayList<String> repe = new ArrayList<String>();
      
       for(int j =0; j<r;j++){
           aux += model.getValueAt(j,0 );
           repe.add(aux);
           aux = "";
       }
       for(int i= 0; i< repe.size();i++){
       if(name.toLowerCase().equals(repe.get(i).toLowerCase())){
       band= false;
       JOptionPane.showMessageDialog(rootPane, "El equipo "+ name + " ya está en este torneo","Error",2);
       }
       
       }
       if(model.getRowCount() == 10){
           mostrarAlerta("El máximo de equipos permitidos por torneo es de 10");
       band = false;
       }
       if(this.jcmbEquip.getSelectedItem().toString() == "Seleccionar"){
       band = false;
           mostrarAlerta("Debe seleccionar un equipo");
       }

       return band;
   }
   private ArrayList<Equipo> agregarEquipos(JTable t){
   DefaultTableModel m = (DefaultTableModel) t.getModel();
   ArrayList<Equipo> equipos = new ArrayList<Equipo>();
   
   int size = m.getRowCount();
   String errores = "";
   if(size != 10){
   errores += "Tiene que haber como minimo y máximo 10 equipos";
   mostrarAlerta(errores);
   }else{
   for(int i = 0; i < size;i++){
   equipos.add(crearEquipo());
   equipos.get(i).setNombre(m.getValueAt(i, 0).toString());
   }
   }
   
       
   return equipos;
   }
   private void mostrarAlerta(String mensaje){
   JOptionPane.showMessageDialog(rootPane, mensaje,"Error",2);
   }
   private Equipo crearEquipo(){
   Equipo equipo = new Equipo();
   return equipo;
   }
   
   private String getEquipos(ArrayList<Equipo> equipo){
   String mensaje ="";
   int corre = 1;
       for(int i = 0;i < equipo.size();i++){
   mensaje += corre+". "+equipo.get(i).getNombre() + "\n";
   
   }
       
   
   return mensaje;
   }
   public void Anadir(){
       DefaultComboBoxModel cmb = (DefaultComboBoxModel) this.jcmbEquip.getModel();
       int i = this.jcmbEquip.getSelectedIndex();
       cmb.removeElementAt(i);
       this.jcmbEquip.setModel(cmb);
   
   }
   public void Remover(){
       if (!this.jcmbEquip.getSelectedItem().toString().equalsIgnoreCase("Seleccionar")) {
           DefaultComboBoxModel cmb = (DefaultComboBoxModel) this.jcmbEquip.getModel();
       int i = this.jcmbEquip.getSelectedIndex();
       cmb.removeElementAt(i);
       this.jcmbEquip.setModel(cmb);
       }
   }
   
   public void limpiar(){
   this.jTableLocal.removeAll();
   this.jTxtNombreTorneo.setText("");
   this.jTxtFechaFin.setText("");
   this.jTxtFechaInicio.setText("");
   }
   
   public void comboEq(ArrayList<Equipo> eqs){
       
   
   }
}
