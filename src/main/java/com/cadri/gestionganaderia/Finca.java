package com.cadri.gestionganaderia;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Finca(ResultSet querySet){
        try {
            this.nombre = querySet.getString("nombre_finca");
            this.numHectareas = querySet.getDouble("hectareas");
            this.ubicacion = querySet.getString("ubicacion");
            this.pathImagen = querySet.getString("path_foto");
        } catch (SQLException ex) {
            Logger.getLogger(Finca.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public Image getFoto(){
        return null;
    }
    
    public List<Animal> getAnimales(){
        return datos.getAnimales(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
}
