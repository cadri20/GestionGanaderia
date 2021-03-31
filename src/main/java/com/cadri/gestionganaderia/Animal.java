package com.cadri.gestionganaderia;

import java.util.Date;

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
