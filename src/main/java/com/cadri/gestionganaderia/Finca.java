package com.cadri.gestionganaderia;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cadri
 */
public class Finca {
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
            this.nombre = querySet.getString("nombre_finca");
            this.numHectareas = querySet.getDouble("hectareas");
            this.ubicacion = querySet.getString("ubicacion");
            this.pathImagen = querySet.getString("path_foto");
            this.datos = datos;
        } catch (SQLException ex) {
            Logger.getLogger(Finca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ponerAnimalesEnTabla(JTable tabla){
        tabla.setModel(new DefaultTableModel(getMatrizAnimales(), new String[]{"ID", "Nombre"}));
    }
    
    private String[][] getMatrizAnimales(){
        List<Animal> listaAnimales = getAnimales();
        String[][] matrizAnimales = new String[listaAnimales.size()][2];
        int i = 0;
        
        for(Animal animal: listaAnimales){
            matrizAnimales[i][0] = animal.getId();
            matrizAnimales[i][1] = animal.getNombre();
            i++;
        }
        
        return matrizAnimales;
    }
    
    public void addAnimal(Animal animal){
        datos.addAnimal(nombre, animal);
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
    
    public Image getFoto() throws IOException{
        if(pathImagen == null)
            return null;
        
        return ImageIO.read(new File(pathImagen));
    }
    
    public List<Animal> getAnimales(){
        return datos.getAnimales(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
}
