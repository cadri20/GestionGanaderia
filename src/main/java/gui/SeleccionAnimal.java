package gui;

import com.cadri.gestionganaderia.Finca;

/**
 *
 * @author cadri
 */
public class SeleccionAnimal extends javax.swing.JDialog {

    private String idSeleccionada;
    private Finca fincaGestionada;
    /**
     * Creates new form SeleccionAnimal
     */
    public SeleccionAnimal(java.awt.Frame parent, boolean modal, Finca fincaGestionada) {
        super(parent, modal);
        this.fincaGestionada = fincaGestionada;
        initComponents();
        GUIManager.ponerAnimalesEnTabla(jTableAnimalesBusqueda, fincaGestionada.getAnimales());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAnimalesBusqueda = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTFIdPatron = new javax.swing.JTextField();
        jTFNombrePatron = new javax.swing.JTextField();
        jBSeleccionarAnimal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableAnimalesBusqueda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableAnimalesBusqueda);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Seleccione un Animal");

        jLabel13.setText("ID");

        jLabel14.setText("Nombre");

        jTFIdPatron.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTFIdPatronCaretUpdate(evt);
            }
        });

        jTFNombrePatron.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTFNombrePatronCaretUpdate(evt);
            }
        });
        jTFNombrePatron.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTFNombrePatronInputMethodTextChanged(evt);
            }
        });
        jTFNombrePatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombrePatronActionPerformed(evt);
            }
        });

        jBSeleccionarAnimal.setText("Seleccionar Animal");
        jBSeleccionarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSeleccionarAnimalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(32, 32, 32)
                                .addComponent(jTFIdPatron, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel14))
                            .addComponent(jLabel12))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jTFNombrePatron, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBSeleccionarAnimal)
                                .addGap(75, 75, 75))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jBSeleccionarAnimal))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jTFIdPatron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNombrePatron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFIdPatronCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTFIdPatronCaretUpdate
        GUIManager.ponerAnimalesEnTabla(jTableAnimalesBusqueda, fincaGestionada.filtrarAnimalesPorId(jTFIdPatron.getText()));
    }//GEN-LAST:event_jTFIdPatronCaretUpdate

    private void jTFNombrePatronCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTFNombrePatronCaretUpdate
          GUIManager.ponerAnimalesEnTabla(jTableAnimalesBusqueda, fincaGestionada.filtrarAnimalesPorNombre(jTFNombrePatron.getText()));
    }//GEN-LAST:event_jTFNombrePatronCaretUpdate

    private void jTFNombrePatronInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTFNombrePatronInputMethodTextChanged

    }//GEN-LAST:event_jTFNombrePatronInputMethodTextChanged

    private void jTFNombrePatronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombrePatronActionPerformed

    }//GEN-LAST:event_jTFNombrePatronActionPerformed

    private void jBSeleccionarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSeleccionarAnimalActionPerformed
        idSeleccionada = jTableAnimalesBusqueda.getValueAt(jTableAnimalesBusqueda.getSelectedRow(), 0).toString();    
        this.setVisible(false);
    }//GEN-LAST:event_jBSeleccionarAnimalActionPerformed

    public String getIdSeleccionada(){
        return idSeleccionada;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSeleccionarAnimal;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFIdPatron;
    private javax.swing.JTextField jTFNombrePatron;
    private javax.swing.JTable jTableAnimalesBusqueda;
    // End of variables declaration//GEN-END:variables
}
