/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esquemasypantallas.frmInternal;
import clases.Jugador;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis
 */
public class frmJugador extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmJugador
     */
    private int idEq;
    public frmJugador( int idEq) {
        initComponents();
        this.idEq = idEq;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnNew = new javax.swing.JButton();
        jBtnAgre = new javax.swing.JButton();
        jBtnMod = new javax.swing.JButton();
        jBtnElim = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jTxtDui = new javax.swing.JFormattedTextField();
        jTxtBirth = new javax.swing.JFormattedTextField();
        jcmbPos = new javax.swing.JComboBox();
        jTxtEmail = new javax.swing.JTextField();
        jTxtTel = new javax.swing.JFormattedTextField();
        jTxtTarj = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jSpCamisa = new javax.swing.JSpinner();

        setClosable(true);
        setMaximizable(true);

        jBtnNew.setText("Nuevo");

        jBtnAgre.setText("Agregar");
        jBtnAgre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAgreMouseClicked(evt);
            }
        });

        jBtnMod.setText("Modificar");

        jBtnElim.setText("Eliminar");

        jLabel1.setText("Nombre");

        jLabel2.setText("DUI");

        jLabel3.setText("Fecha Nacimiento");

        jLabel4.setText("Posición");

        jLabel5.setText("Email");

        jLabel6.setText("Telefono");

        jLabel7.setText("Número de tarjeta deportiva");

        jTxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNombreKeyTyped(evt);
            }
        });

        try {
            jTxtDui.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTxtBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jcmbPos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Portero", "Defensa", "Volante", "Delantero", " " }));

        try {
            jTxtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTxtTarj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("Número camiseta");

        jSpCamisa.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtBirth)
                            .addComponent(jTxtDui)
                            .addComponent(jTxtNombre)
                            .addComponent(jTxtEmail)
                            .addComponent(jcmbPos, 0, 110, Short.MAX_VALUE)
                            .addComponent(jTxtTel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtTarj)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSpCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcmbPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtTarj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSpCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jBtnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAgre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnElim))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNew)
                    .addComponent(jBtnAgre)
                    .addComponent(jBtnMod)
                    .addComponent(jBtnElim))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAgreMouseClicked
        // TODO add your handling code here:
        llenar();

    }//GEN-LAST:event_jBtnAgreMouseClicked

    private void jTxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNombreKeyTyped
        // TODO add your handling code here:

        char s =evt.getKeyChar();

        if(Character.isDigit(s) && s != KeyEvent.VK_SPACE){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_jTxtNombreKeyTyped

  
private void llenar(){

    Jugador p = new Jugador();
    p.setEmail(jTxtEmail.getText());
    p.setFechaNac(jTxtBirth.getText());
    p.setCamiseta(Integer.parseInt(jSpCamisa.getValue().toString()));
    p.setDui(jTxtDui.getText());
    p.setEmail(jTxtEmail.getText());
    p.setNombre(jTxtNombre.getText());
    p.setPos(jcmbPos.getSelectedItem().toString());
    p.setTarjeta(jTxtTarj.getText());
    p.setTel(jTxtTel.getText());
    if(p.validar()){
          String m = "Datos: \n Nombre: " + p.getNombre()+ "\n DUI: " + p.getDui()+"\n Fecha Nacimiento: " + p.getFechaNac() + "\n Posición: "+ p.getPos() + "\n Email: "+ p.getEmail() + "\n Teléfono: "+ p.getTel()+ "\n Tarjeta: "+ p.getTarjeta()+"\n Camiseta: "+ p.getCamiseta() ;
    JOptionPane.showMessageDialog(this, m);
        getToolkit().beep();
    }

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgre;
    private javax.swing.JButton jBtnElim;
    private javax.swing.JButton jBtnMod;
    private javax.swing.JButton jBtnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpCamisa;
    private javax.swing.JFormattedTextField jTxtBirth;
    private javax.swing.JFormattedTextField jTxtDui;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JFormattedTextField jTxtTarj;
    private javax.swing.JFormattedTextField jTxtTel;
    private javax.swing.JComboBox jcmbPos;
    // End of variables declaration//GEN-END:variables
}
