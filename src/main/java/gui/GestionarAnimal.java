package gui;

import com.cadri.gestionganaderia.Animal;
import com.cadri.gestionganaderia.SQLiteSource;
import com.cadri.gestionganaderia.Tratamiento;
import java.awt.Canvas;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author cadri
 */
public class GestionarAnimal extends javax.swing.JFrame {

    private Animal animalGestionar;
    /**
     * Creates new form GestionarAnimal
     */
    public GestionarAnimal(Animal animalGestionar) {
        this.animalGestionar = animalGestionar;
        initComponents();
        
        jTF_id.setText(animalGestionar.getId());
        jTFNombre.setText(animalGestionar.getNombre());
        LocalDate fechaIngreso = animalGestionar.getFechaIngreso();
        if(fechaIngreso != null)
            jTFFechaIngreso.setText(SQLiteSource.formatter.format(fechaIngreso));
        LocalDate fechaNacimiento = animalGestionar.getFechaNacimiento();
        if(fechaNacimiento != null)
            jTFFechaNacimiento.setText(SQLiteSource.formatter.format(fechaNacimiento));
        
        jTFTipo.setText(animalGestionar.getTipo().toString());
        jTFCosto.setText(Double.toString(animalGestionar.getCosto()));
        jTFColor.setText(animalGestionar.getColor());
        jTFEdad.setText(animalGestionar.getEdad());

        animalGestionar.ponerTratamientosEnTabla(jTableTratamientos);
    }

    public void dibujarImagen(){
        try {
            Image foto = animalGestionar.getFoto();
            if (foto != null) {
                ImageIcon icono = new ImageIcon(foto.getScaledInstance(jLabImagen.getWidth(), jLabImagen.getHeight(), Image.SCALE_DEFAULT));
                
                jLabImagen.setIcon(icono);
            }

        } catch (IOException ex) {
            Logger.getLogger(GestionarAnimal.class.getName()).log(Level.SEVERE, null, ex);
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

        jTFColor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTFCosto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTF_id = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jBAniadirTratamiento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTratamientos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTFDescripcion = new javax.swing.JTextField();
        jDateTratamiento = new com.toedter.calendar.JDateChooser();
        jTFProductoUtilizado = new javax.swing.JTextField();
        jBEliminarTratamiento = new javax.swing.JButton();
        jTFFechaIngreso = new javax.swing.JTextField();
        jTFTipo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTFFechaNacimiento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTFEdad = new javax.swing.JTextField();
        jLabImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTFColor.setEnabled(false);

        jLabel1.setText("ID");

        jTFCosto.setEnabled(false);

        jLabel2.setText("Nombre");

        jLabel3.setText("Fecha de Ingreso");

        jLabel9.setText("Tipo");

        jLabel4.setText("Costo");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Gestionar Animal");

        jLabel6.setText("Color");

        jLabel7.setText("Foto");

        jTF_id.setEnabled(false);
        jTF_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_idActionPerformed(evt);
            }
        });

        jTFNombre.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBAniadirTratamiento.setText("Añadir");
        jBAniadirTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAniadirTratamientoActionPerformed(evt);
            }
        });

        jTableTratamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha", "Tratamiento", "Producto Utilizado"
            }
        ));
        jTableTratamientos.setRowHeight(32);
        jScrollPane1.setViewportView(jTableTratamientos);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tratamientos");

        jLabel10.setText("Fecha");

        jLabel11.setText("Descripcion");

        jLabel12.setText("Producto Utilizado");

        jBEliminarTratamiento.setText("Eliminar");
        jBEliminarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarTratamientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12))
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFProductoUtilizado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(77, 77, 77)
                                .addComponent(jDateTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jBAniadirTratamiento)
                        .addGap(56, 56, 56)
                        .addComponent(jBEliminarTratamiento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jDateTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTFProductoUtilizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAniadirTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEliminarTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
        );

        jTFFechaIngreso.setEnabled(false);

        jTFTipo.setEnabled(false);

        jLabel13.setText("Fecha de Nacimiento");

        jTFFechaNacimiento.setEnabled(false);

        jLabel14.setText("Edad");

        jTFEdad.setEnabled(false);

        jLabImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel13))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(45, 45, 45))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel14)))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTFCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(jTFColor)
                                            .addComponent(jTFTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(jTFEdad))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(112, 112, 112)
                                .addComponent(jTF_id, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTF_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jTFTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTFCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTFColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jTFFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jTFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jTFFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_idActionPerformed

        
    }//GEN-LAST:event_jTF_idActionPerformed

    private void jBAniadirTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAniadirTratamientoActionPerformed
        LocalDate fechaTratamiento = jDateTratamiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Tratamiento nuevoTratamiento = new Tratamiento(fechaTratamiento, jTFDescripcion.getText(), jTFProductoUtilizado.getText());
        
        try {
            animalGestionar.addTratamiento(nuevoTratamiento);
            JOptionPane.showMessageDialog(this, "Tratamiento registrado con éxito");
            animalGestionar.ponerTratamientosEnTabla(jTableTratamientos);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar registrar el tratamiento", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jBAniadirTratamientoActionPerformed

    private void jBEliminarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarTratamientoActionPerformed
        int filaSeleccionada = jTableTratamientos.getSelectedRow();
        String fechaStr = jTableTratamientos.getValueAt(filaSeleccionada, 0).toString();
        String descripcion = jTableTratamientos.getValueAt(filaSeleccionada, 1).toString();
        
        int eleccion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que quiere eliminar el tratamiento seleccionado?", "", JOptionPane.YES_NO_OPTION);
        if(eleccion == JOptionPane.NO_OPTION)
            return;
        
        try {
            animalGestionar.eliminarTratamiento(fechaStr, descripcion);
            JOptionPane.showMessageDialog(this, "Tratamiento eliminado con éxito");
            animalGestionar.ponerTratamientosEnTabla(jTableTratamientos);
        } catch (SQLException ex) {
            Logger.getLogger(GestionarAnimal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar eliminar el tratamiento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBEliminarTratamientoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAniadirTratamiento;
    private javax.swing.JButton jBEliminarTratamiento;
    private com.toedter.calendar.JDateChooser jDateTratamiento;
    private javax.swing.JLabel jLabImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFColor;
    private javax.swing.JTextField jTFCosto;
    private javax.swing.JTextField jTFDescripcion;
    private javax.swing.JTextField jTFEdad;
    private javax.swing.JTextField jTFFechaIngreso;
    private javax.swing.JTextField jTFFechaNacimiento;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFProductoUtilizado;
    private javax.swing.JTextField jTFTipo;
    private javax.swing.JTextField jTF_id;
    private javax.swing.JTable jTableTratamientos;
    // End of variables declaration//GEN-END:variables
}
