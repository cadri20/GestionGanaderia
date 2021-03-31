package gui;

import com.cadri.gestionganaderia.DataSource;
import com.cadri.gestionganaderia.Finca;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author cadri
 */
public class Inicio extends javax.swing.JFrame {

    private DataSource datos;
    /**
     * Creates new form Inicio
     */
    public Inicio(DataSource datos) {
        this.datos = datos;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBFincas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jBCrearFinca = new javax.swing.JButton();
        JBIngresarSistema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Inicio");

        jLabel2.setText("Seleccione una finca: ");

        jCBFincas.setModel(new javax.swing.DefaultComboBoxModel<>(datos.getFincas().toArray(new Finca[datos.getFincas().size()])));

        jLabel3.setText("o");

        jBCrearFinca.setText("Crear nueva finca");
        jBCrearFinca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearFincaActionPerformed(evt);
            }
        });

        JBIngresarSistema.setText("Ingresar al Sistema");
        JBIngresarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBIngresarSistemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jBCrearFinca))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBFincas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBIngresarSistema))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBFincas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCrearFinca)
                    .addComponent(JBIngresarSistema))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCrearFincaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearFincaActionPerformed
        JFrame frameCrearFinca = new CrearFinca();
        frameCrearFinca.setLocationRelativeTo(this);
        frameCrearFinca.setVisible(true);
    }//GEN-LAST:event_jBCrearFincaActionPerformed

    private void JBIngresarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBIngresarSistemaActionPerformed
        JFrame menuPrincipal = new MenuPrincipal(datos.getFinca(jCBFincas.getSelectedItem().toString()), datos);
        menuPrincipal.setLocationRelativeTo(this);
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBIngresarSistemaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBIngresarSistema;
    private javax.swing.JButton jBCrearFinca;
    private javax.swing.JComboBox<Finca> jCBFincas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
