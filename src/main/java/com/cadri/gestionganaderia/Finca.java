package com.cadri.gestionganaderia;

import com.cadri.gestionganaderia.Animal.TipoAnimal;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cadri
 */
public class Finca {
    private int id;
    private String nombre;
    private double numHectareas;
    private String ubicacion;
    private String pathImagen;
    private DataSource datos;

    public Finca(String nombre, double numHectareas, String ubicacion, String pathImagen) {
        this.nombre = nombre;
        this.numHectareas = numHectareas;
        this.ubicacion = ubicacion;
        this.pathImagen = pathImagen;
    }
    
    public Finca(ResultSet querySet, DataSource datos){
        try {
            this.id = querySet.getInt("id");
            this.nombre = querySet.getString("nombre_finca");
            this.numHectareas = querySet.getDouble("hectareas");
            this.ubicacion = querySet.getString("ubicacion");
            this.pathImagen = querySet.getString("path_foto");
            this.datos = datos;
        } catch (SQLException ex) {
            Logger.getLogger(Finca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Animal> filtrarAnimalesPorNombre(String patronNombre){
        return datos.filtrarAnimal(id, "nombre_animal", patronNombre);
    }
    
    public List<Animal> filtrarAnimalesPorId(String patronId){
        return datos.filtrarAnimal(id, "id_animal", patronId);
    }
    
    public void mostrarAnimales(JComboBox<Animal> comboBox){
        List<Animal> listaAnimales = getAnimales();
        comboBox.setModel(new DefaultComboBoxModel<>(listaAnimales.toArray(new Animal[listaAnimales.size()])));
    }
    
    
    public void addAnimal(Animal animal) throws SQLException{
        datos.addAnimal(id, animal);
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getNumHectareas() {
        return numHectareas;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public int getId() {
        return id;
    }
    
    public Image getFoto() throws IOException{
        if(pathImagen == null)
            return null;
        
        return ImageIO.read(new File(pathImagen));
    }
    
    public List<Animal> getAnimales(){
        return datos.getAnimales(id);
    }

    public int getNum(TipoAnimal tipo){
        return datos.countTipo(id, tipo);
    }
    
    public int getTotalAnimales(){
        return datos.getTotalAnimales(id);
    }

    public DataSource getDatos() {
        return datos;
    }
    
    
    public void actualizar() throws SQLException{
        datos.actualizarFinca(this);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumHectareas(double numHectareas) {
        this.numHectareas = numHectareas;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public void setDatos(DataSource datos) {
        this.datos = datos;
    }
    
    
    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
}
