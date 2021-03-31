package com.cadri.gestionganaderia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cadri
 */
public class Tratamiento {
    private LocalDate fecha;
    private String descripcion;
    private String productoUtilizado;

    public Tratamiento(LocalDate fecha, String descripcion, String productoUtilizado) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.productoUtilizado = productoUtilizado;
    }

    public Tratamiento(ResultSet rs) {
        
        try {
            this.fecha = LocalDate.parse(rs.getString("fecha"), SQLiteSource.formatter);
            this.descripcion = rs.getString("descripcion");
            this.productoUtilizado = rs.getString("producto_utilizado");
        } catch (SQLException ex) {
            Logger.getLogger(Tratamiento.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getProductoUtilizado() {
        return productoUtilizado;
    }
    
    
}
