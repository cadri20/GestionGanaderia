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
import org.sqlite.SQLiteConfig;

/**
 *
 * @author cadri
 */
public class SQLiteSource implements DataSource{

    private Connection conn;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public SQLiteSource(String url) throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite:" + url);
        Statement s = conn.createStatement();
        s.execute("PRAGMA foreign_keys = ON");
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
    public List<Animal> getAnimales(int idFinca) {
        String sql = "SELECT * FROM animal WHERE id_finca = " + idFinca;
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
        String sql = "INSERT INTO finca(nombre_finca,hectareas,ubicacion,path_foto) VALUES(?,?,?,?)";
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
    public void addAnimal(int idFinca, Animal animal) throws SQLException{
        String sql = "INSERT INTO animal VALUES(?,?,?,?,?,?,?,?,?)";
          
        PreparedStatement s = conn.prepareStatement(sql);
        s.setString(1, animal.getId());
        s.setInt(2, idFinca);;
        s.setString(3, animal.getNombre());
        s.setString(4, SQLiteSource.formatter.format(animal.getFechaIngreso()));
        s.setString(5, SQLiteSource.formatter.format(animal.getFechaNacimiento()));
        s.setString(6, animal.getTipo().toString());
        s.setDouble(7, animal.getCosto());
        s.setString(8, animal.getColor());
        s.setString(9, animal.getPathFoto());

        s.executeUpdate();

    }

    @Override
    public int countTipo(int idFinca, Animal.TipoAnimal tipo) {
        String sql = "SELECT COUNT(*) FROM animal WHERE tipo = '" + tipo.toString() + "' and id_finca = " + idFinca ;
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;

    }

    @Override
    public int getTotalAnimales(int idFinca) {
        String sql = "SELECT COUNT(*) FROM animal WHERE id_finca = " + idFinca;
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
        
    }

    @Override
    public void addTratamiento(String idAnimal, Tratamiento tratamiento) throws SQLException{
        String sql = "INSERT INTO tratamiento VALUES (?,?,?,?)";
        PreparedStatement s = conn.prepareStatement(sql);
        
        s.setString(1, idAnimal);
        s.setString(2, formatter.format(tratamiento.getFecha()));
        s.setString(3, tratamiento.getDescripcion());
        s.setString(4, tratamiento.getProductoUtilizado());
        
        s.executeUpdate();
        
    }

    @Override
    public void eliminarAnimal(String idAnimal) throws SQLException {
        String sql = "DELETE FROM animal WHERE id_animal = '" + idAnimal + "'";
        Statement s = conn.createStatement();
        s.executeUpdate(sql);
    }

    @Override
    public void eliminarTratamiento(String id_animal, String fecha, String descripcion) throws SQLException {
        String sql = "DELETE FROM tratamiento WHERE id_animal = '" + id_animal + "' and fecha = '" + fecha + "' and descripcion = '" + descripcion + "'";
        Statement s = conn.createStatement();
        s.executeUpdate(sql);
    }
        
}
