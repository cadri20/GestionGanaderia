package com.cadri.gestionganaderia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cadri
 */
public class Animal {
    private String id;
    private String nombre;
    private Date fechaIngreso;
    private Date fechaNacimiento;
    private TipoAnimal tipo;
    private double costo;
    private String color;
    private String pathFoto;
    
    public Animal(ResultSet querySet, DataSource datos){
        try {
            this.id = querySet.getString("id_animal");
            this.nombre = querySet.getString("nombre_animal");
            
            String fechaIngresoStr = querySet.getString("fecha_ingreso");
            if(fechaIngresoStr != null)
                this.fechaIngreso = datos.getDateFormatter().parse(fechaIngresoStr);
            else
                this.fechaIngreso = null;
            
            String fechaNacimientoStr = querySet.getString("fecha_nacimiento");
            if(fechaNacimientoStr != null)
                this.fechaNacimiento = datos.getDateFormatter().parse(fechaNacimientoStr);
            else
                this.fechaNacimiento = null;
            
            String tipoStr = querySet.getString("tipo");
            if(tipoStr != null)
                this.tipo = TipoAnimal.valueOf(tipoStr);
            else
                this.tipo = null;
            this.costo = querySet.getDouble("costo");
            this.color = querySet.getString("color");
            this.pathFoto = querySet.getString("path_foto");
        } catch (SQLException ex) {
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }

    public String getColor() {
        return color;
    }
    
    
   
    
    public enum TipoAnimal{
        TORO("toro"),
        VACA("vaca"),
        TORETE("torete"),
        TERNERO("ternero"),
        VACONA("vacona");
        
        private String tipo;
        
        TipoAnimal(String tipo){
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return tipo;
        }
        
        
    }
}
