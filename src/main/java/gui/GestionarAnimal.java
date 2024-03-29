package gui;

import com.cadri.gestionganaderia.Animal;
import com.cadri.gestionganaderia.Animal.TipoAnimal;
import com.cadri.gestionganaderia.IOUtils;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author cadri
 */
public class GestionarAnimal extends javax.swing.JFrame {

    private Animal animalGestionar;
    private JFileChooser fc;
    /**
     * Creates new form GestionarAnimal
     */
    public GestionarAnimal(Animal animalGestionar) {
        this.animalGestionar = animalGestionar;
        this.fc = new JFileChooser();
        fc.setFileFilter(GUIManager.filtroArchivos);
        
        initComponents();
        
        jTF_id.setText(animalGestionar.getId());
        jTFNombre.setText(animalGestionar.getNombre());
        LocalDate fechaIngreso = animalGestionar.getFechaIngreso();
        if(fechaIngreso != null)
            jDateIngreso.setDate(Date.from(animalGestionar.getFechaIngreso().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        LocalDate fechaNacimiento = animalGestionar.getFechaNacimiento();
        if(fechaNacimiento != null)
            jDateNacimiento.setDate(Date.from(animalGestionar.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        jCBTipo.setSelectedItem(animalGestionar.getTipo());
        jTFCosto.setText(Double.toString(animalGestionar.getCosto()));
        jTFColor.setText(animalGestionar.getColor());
        jTFEdad.setText(animalGestionar.getEdad());
        
        Animal padre = animalGestionar.getPadre();
        if(padre != null)
            jTFPadre.setText(padre.getNombre());
        
        Animal madre = animalGestionar.getMadre();
        if(madre != null)
            jTFMadre.setText(madre.getNombre());
        
        setAnimalEditable(false);
        animalGestionar.ponerTratamientosEnTabla(jTableTratamientos);
        
        try {
            Image foto = animalGestionar.getSigFoto();
            if(foto != null)
                GUIManager.dibujarImagen(foto, jLabImagen);
        } catch (IOException ex) {
            Logger.getLogger(GestionarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setAnimalEditable(boolean editable){
        jBGuardar.setVisible(editable);
        jTFNombre.setEnabled(editable);
        jDateIngreso.setEnabled(editable);
        jDateNacimiento.setEnabled(editable);
        jCBTipo.setEnabled(editable);
        jTFCosto.setEnabled(editable);
        jTFColor.setEnabled(editable);
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTFEdad = new javax.swing.JTextField();
        jLabImagen = new javax.swing.JLabel();
        jBModificar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jDateIngreso = new com.toedter.calendar.JDateChooser();
        jDateNacimiento = new com.toedter.calendar.JDateChooser();
        jCBTipo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTFPadre = new javax.swing.JTextField();
        jTFMadre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jBAgregarImagen = new javax.swing.JButton();
        jBFotoPrev = new javax.swing.JButton();
        jBSigFoto = new javax.swing.JButton();
        jBEliminarImagen = new javax.swing.JButton();

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAniadirTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEliminarTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
        );

        jLabel13.setText("Fecha de Nacimiento");

        jLabel14.setText("Edad");

        jTFEdad.setEnabled(false);

        jLabImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBModificar.setText("Modificar Datos");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar Cambios");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jDateIngreso.setEnabled(false);

        jDateNacimiento.setEnabled(false);

        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(TipoAnimal.values()));
        jCBTipo.setEnabled(false);

        jLabel15.setText("Padre");

        jTFPadre.setEditable(false);

        jTFMadre.setEditable(false);

        jLabel16.setText("Madre");

        jBAgregarImagen.setText("Agregar Imagen");
        jBAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarImagenActionPerformed(evt);
            }
        });

        jBFotoPrev.setText("<");
        jBFotoPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFotoPrevActionPerformed(evt);
            }
        });

        jBSigFoto.setText(">");
        jBSigFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSigFotoActionPerformed(evt);
            }
        });

        jBEliminarImagen.setText("Eliminar Imagen");
        jBEliminarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(112, 112, 112)
                                        .addComponent(jTF_id, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTFNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(jDateIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jBModificar))
                                            .addComponent(jTFPadre))
                                        .addGap(82, 82, 82)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(jLabel14)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(1, 1, 1)))))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jBGuardar)
                                        .addComponent(jTFCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(jTFColor)
                                        .addComponent(jTFEdad)
                                        .addComponent(jCBTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jTFMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBFotoPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBSigFoto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAgregarImagen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBEliminarImagen)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBFotoPrev)
                                    .addComponent(jBSigFoto))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTF_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(jDateIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jTFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jDateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTFPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTFMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16))))
                            .addComponent(jLabImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBGuardar)
                        .addComponent(jBAgregarImagen)
                        .addComponent(jBEliminarImagen))
                    .addComponent(jBModificar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        setAnimalEditable(true);
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        animalGestionar.setNombre(jTFNombre.getText());
        LocalDate fechaIngreso = jDateIngreso.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaNacimiento = jDateNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        animalGestionar.setFechaIngreso(fechaIngreso);
        animalGestionar.setFechaNacimiento(fechaNacimiento);
        animalGestionar.setTipo(jCBTipo.getItemAt(jCBTipo.getSelectedIndex()));
        animalGestionar.setCosto(Double.parseDouble(jTFCosto.getText()));
        animalGestionar.setColor(jTFColor.getText());
        
        try {
            animalGestionar.actualizar();
            JOptionPane.showMessageDialog(this, "Animal modificado exitósamente");
            setAnimalEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(GestionarAnimal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar actualizar el animal", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBSigFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSigFotoActionPerformed
        try {
            Image imagenAnimal = animalGestionar.getSigFoto();
            if(imagenAnimal != null)
                GUIManager.dibujarImagen(imagenAnimal, jLabImagen);
        } catch (IOException ex) {
            Logger.getLogger(GestionarAnimal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al obtener la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBSigFotoActionPerformed

    private void jBAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarImagenActionPerformed
        int eleccion = fc.showOpenDialog(this);
        if(eleccion == JFileChooser.CANCEL_OPTION)
            return;
        
        String path = IOUtils.guardarImagen(fc.getSelectedFile());
        animalGestionar.addFoto(path);
        if(jLabImagen.getIcon() == null){
            try {
                GUIManager.dibujarImagen(animalGestionar.getSigFoto(), jLabImagen);
            } catch (IOException ex) {
                Logger.getLogger(GestionarAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al obtener la imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBAgregarImagenActionPerformed

    private void jBFotoPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFotoPrevActionPerformed
        try {
            Image imagenAnimal = animalGestionar.getPrevFoto();
            if(imagenAnimal != null)
                GUIManager.dibujarImagen(imagenAnimal, jLabImagen);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al obtener la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_jBFotoPrevActionPerformed

    private void jBEliminarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarImagenActionPerformed
        try{
            animalGestionar.eliminarFotoActual();
            JOptionPane.showMessageDialog(this, "Imagen eliminada exitósamente");
            Image imagenPrevia = animalGestionar.getPrevFoto();
            Image imagenSig = animalGestionar.getSigFoto();
            if(imagenPrevia != null)
                GUIManager.dibujarImagen(imagenPrevia, jLabImagen);
            else if(imagenSig != null){
                GUIManager.dibujarImagen(imagenSig, jLabImagen);
            }else{
                jLabImagen.setIcon(null);
            }
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar eliminar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(GestionarAnimal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al obtener la imagen previa o siguiente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBEliminarImagenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarImagen;
    private javax.swing.JButton jBAniadirTratamiento;
    private javax.swing.JButton jBEliminarImagen;
    private javax.swing.JButton jBEliminarTratamiento;
    private javax.swing.JButton jBFotoPrev;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBSigFoto;
    private javax.swing.JComboBox<TipoAnimal> jCBTipo;
    private com.toedter.calendar.JDateChooser jDateIngreso;
    private com.toedter.calendar.JDateChooser jDateNacimiento;
    private com.toedter.calendar.JDateChooser jDateTratamiento;
    private javax.swing.JLabel jLabImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField jTFMadre;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFPadre;
    private javax.swing.JTextField jTFProductoUtilizado;
    private javax.swing.JTextField jTF_id;
    private javax.swing.JTable jTableTratamientos;
    // End of variables declaration//GEN-END:variables
}
