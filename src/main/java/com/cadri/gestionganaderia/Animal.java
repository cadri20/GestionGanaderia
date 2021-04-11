package com.cadri.gestionganaderia;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
public class Animal {
    private String id;
    private String nombre;
    private LocalDate fechaIngreso;
    private LocalDate fechaNacimiento;
    private TipoAnimal tipo;
    private double costo;
    private String color;
    private String pathFoto;
    private String idPadre;
    private String idMadre;
    private DataSource datos;

    public Animal(DataSource datos, String id, String nombre, LocalDate fechaIngreso, LocalDate fechaNacimiento, TipoAnimal tipo, double costo, String color, String pathFoto, String idPadre, String idMadre) {
        this.id = id;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        this.costo = costo;
        this.color = color;
        this.pathFoto = pathFoto;
        this.idPadre = idPadre;
        this.idMadre = idMadre;
        this.datos = datos;
    }
    
    public Animal(ResultSet querySet, DataSource datos){
        try {
            this.datos = datos;
            this.id = querySet.getString("id_animal");
            this.nombre = querySet.getString("nombre_animal");
            
            String fechaIngresoStr = querySet.getString("fecha_ingreso");
            if(fechaIngresoStr != null)
                this.fechaIngreso = LocalDate.parse(fechaIngresoStr, SQLiteSource.formatter);
            
            else
                this.fechaIngreso = null;
            
            String fechaNacimientoStr = querySet.getString("fecha_nacimiento");
            if(fechaNacimientoStr != null)
                this.fechaNacimiento = LocalDate.parse(fechaNacimientoStr, SQLiteSource.formatter);
            else
                this.fechaNacimiento = null;
            
            String tipoStr = querySet.getString("tipo");
            if(tipoStr != null)
                this.tipo = TipoAnimal.getTipo(tipoStr);
            else
                this.tipo = null;
            this.costo = querySet.getDouble("costo");
            this.color = querySet.getString("color");
            this.pathFoto = querySet.getString("path_foto");
            this.idPadre = querySet.getString("id_padre");
            this.idMadre = querySet.getString("id_madre");
        } catch (SQLException ex) {
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaNacimiento() {
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

    public String getPathFoto() {
        return pathFoto;
    }

    public Animal getPadre(){
        return datos.getAnimal(idPadre);
    }
    
    public Animal getMadre(){
        return datos.getAnimal(idMadre);
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }
    
    
    public String getEdad(){
        if(fechaNacimiento == null)
            return null;
        
        LocalDate ahora = LocalDate.now();
        
        Period periodo = Period.between(fechaNacimiento, ahora);
        
        int anios = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();
        
        String edad = "";
        
        if(anios != 0)
            edad += anios + " años ";
        if(meses != 0)
            edad += meses + " meses ";
        if(dias != 0)
            edad += dias + " dias ";
        
        return edad;
    }
    
    
    public List<Tratamiento> getTratamientos(){
        return datos.getTratamientos(id);
    }
    
    public Image getFoto() throws IOException{
        if(pathFoto == null)
            return null;
        
        File archivoFoto = new File(pathFoto);
        return ImageIO.read(archivoFoto);
    }
    
    public void ponerTratamientosEnTabla(JTable tabla){
        tabla.setModel(new DefaultTableModel(getMatrizTratamientos(), new String[]{"Fecha", "Descripción", "Tratamiento"}));
    }
    
    private String[][] getMatrizTratamientos(){
        List<Tratamiento> listaTratamientos = getTratamientos();
        String[][] matrizTratamientos = new String[listaTratamientos.size()][3];
        
        int i = 0;
        for(Tratamiento tratamiento: listaTratamientos){
            matrizTratamientos[i][0] = SQLiteSource.formatter.format(tratamiento.getFecha());
            matrizTratamientos[i][1] = tratamiento.getDescripcion();
            matrizTratamientos[i][2] = tratamiento.getProductoUtilizado();
            i++;
        }
        
        return matrizTratamientos;
    }
    
    public void addTratamiento(Tratamiento tratamiento) throws SQLException{
        datos.addTratamiento(id, tratamiento);
    }
    
    public void eliminarTratamiento(String fecha, String descripcion) throws SQLException{
        datos.eliminarTratamiento(id, fecha, descripcion);
    }
    
    public void actualizar() throws SQLException{
        datos.actualizarAnimal(this);
    }

    @Override
    public String toString() {
        return id;
    }
    
    
    
    public enum TipoAnimal{
        TORO("Toro"),
        VACA("Vaca"),
        TORETE("Torete"),
        TERNERO("Ternero"),
        VACONA("Vacona");
        
        private String tipo;
        
        TipoAnimal(String tipo){
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return tipo;
        }
        
        public static TipoAnimal getTipo(String tipoStr){
            for(TipoAnimal tipo: values()){
                if(tipo.toString().equalsIgnoreCase(tipoStr))
                    return tipo;
            }
            
            return null;
        }
    }
}
