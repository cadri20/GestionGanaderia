package com.cadri.gestionganaderia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private SimpleDateFormat formatter;
    public SQLiteSource(String url) throws SQLException{
        conn = DriverManager.getConnection("jdbc:sqlite:" + url);
        formatter = new SimpleDateFormat("dd/mm/yyyy");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DateFormat getDateFormatter() {
        return formatter;
    }
    
}
