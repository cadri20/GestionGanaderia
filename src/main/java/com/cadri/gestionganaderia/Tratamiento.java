package com.cadri.gestionganaderia;

import java.util.Date;

/**
 *
 * @author cadri
 */
public class Tratamiento {
    private Date fecha;
    private String descripcion;
    private String productoUtilizado;

    public Tratamiento(Date fecha, String descripcion, String productoUtilizado) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.productoUtilizado = productoUtilizado;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getProductoUtilizado() {
        return productoUtilizado;
    }
    
    
}
