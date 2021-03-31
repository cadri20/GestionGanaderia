package com.cadri.gestionganaderia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cadri
 */
public class SQLiteSource implements DataSource{

    private Connection conn;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public SQLiteSource(String url) throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite:" + url);
    }
    
    @Override
    public Animal getAnimal(String id) {
        String sql = "SELECT * FROM animal WHERE id_animal = '" + id + "'";
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        if(rs == null)
            return null;
        else
            return new Animal(rs, this);
    }

    @Override
    public List<Animal> getAnimales(String nombreFinca) {
        String sql = "SELECT * FROM animal WHERE nombre_finca = '" + nombreFinca + "'";
        ResultSet rs = null;
        List<Animal> animales = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                animales.add(new Animal(rs, this));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return animales;
    }

    @Override
    public Finca getFinca(String nombreFinca) {
        String sql = "SELECT * FROM finca WHERE nombre_finca = '" + nombreFinca + "'";
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(rs == null)
            return null;
        else
            return new Finca(rs, this);
    }

    @Override
    public List<Finca> getFincas() {
        String sql = "SELECT * FROM finca";
        ResultSet rs = null;
        List<Finca> fincas = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                fincas.add(new Finca(rs, this));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fincas;
    }

    @Override
    public List<Tratamiento> getTratamientos(String idAnimal) {
        String sql = "SELECT * FROM tratamiento WHERE id_animal = '" + idAnimal + "'";
        ResultSet rs = null;
        List<Tratamiento> listaTratamientos = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                listaTratamientos.add(new Tratamiento(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(rs == null)
            return null;
        else
            return listaTratamientos;
                 
    }

    @Override
    public void addFinca(Finca finca) {
        String sql = "INSERT INTO finca VALUES(?,?,?,?)";
        try {
            PreparedStatement s = conn.prepareStatement(sql);
            s.setString(1, finca.getNombre());
            s.setDouble(2, finca.getNumHectareas());
            s.setString(3, finca.getUbicacion());
            s.setString(4, finca.getPathImagen());
            
            s.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void addAnimal(String finca, Animal animal) throws SQLException{
        String sql = "INSERT INTO animal VALUES(?,?,?,?,?,?,?,?,?)";
          
        PreparedStatement s = conn.prepareStatement(sql);
        s.setString(1, animal.getId());
        s.setString(1, finca);
        s.setString(2, animal.getNombre());
        s.setDate(4, Date.valueOf(animal.getFechaIngreso()));
        s.setDate(5, Date.valueOf(animal.getFechaNacimiento()));
        s.setString(6, animal.getTipo().toString());
        s.setDouble(7, animal.getCosto());
        s.setString(8, animal.getColor());
        s.setString(9, animal.getPathFoto());

        s.executeUpdate();

    }
    
}
