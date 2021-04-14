package com.cadri.gestionganaderia;

import java.io.File;
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
    
    public SQLiteSource(File fileDatabase) throws SQLException{
        this(fileDatabase.getAbsolutePath());
    }
    
    @Override
    public Animal getAnimal(String id) {
        String sql = "SELECT * FROM animal WHERE id_animal = '" + id + "'";
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);
            if(rs.isClosed())
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
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
        String sql = "INSERT INTO animal VALUES(?,?,?,?,?,?,?,?,?,?)";
          
        PreparedStatement s = conn.prepareStatement(sql);
        s.setString(1, animal.getId());
        s.setInt(2, idFinca);;
        s.setString(3, animal.getNombre());
        s.setString(4, SQLiteSource.formatter.format(animal.getFechaIngreso()));
        s.setString(5, SQLiteSource.formatter.format(animal.getFechaNacimiento()));
        s.setString(6, animal.getTipo().toString());
        s.setDouble(7, animal.getCosto());
        s.setString(8, animal.getColor());
        
        Animal padre = animal.getPadre();
        Animal madre = animal.getMadre();
        
        s.setString(9, padre == null ? null : padre.getId());
        s.setString(10, madre == null ? null: madre.getId());
        
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

    @Override
    public void actualizarFinca(Finca finca) throws SQLException {
        String sql = "UPDATE finca SET nombre_finca = ?, hectareas = ?, ubicacion = ? WHERE id = ?";
        PreparedStatement s = conn.prepareStatement(sql);
        
        s.setString(1, finca.getNombre());
        s.setDouble(2, finca.getNumHectareas());
        s.setString(3, finca.getUbicacion());
        s.setInt(4, finca.getId());
        
        s.executeUpdate();
    }

    @Override
    public void actualizarAnimal(Animal animal) throws SQLException {
        String sql = "UPDATE animal SET nombre_animal = ?, fecha_ingreso = ?, fecha_nacimiento = ?, tipo = ?, costo = ?, color = ? WHERE id_animal = ?";
        PreparedStatement s = conn.prepareStatement(sql);
        
        s.setString(1, animal.getNombre());
        s.setString(2, SQLiteSource.formatter.format(animal.getFechaIngreso()));
        s.setString(3, SQLiteSource.formatter.format(animal.getFechaNacimiento()));
        s.setString(4, animal.getTipo().toString());
        s.setDouble(5, animal.getCosto());
        s.setString(6, animal.getColor());
        s.setString(7, animal.getId());
        s.executeUpdate();
    }

    @Override
    public void init() {
        String sql = "CREATE TABLE \"finca\" (\n"
                + "	\"ID\"	INTEGER NOT NULL,\n"
                + "	\"nombre_finca\"	TEXT NOT NULL,\n"
                + "	\"hectareas\"	REAL,\n"
                + "	\"ubicacion\"	TEXT,\n"
                + "	\"path_foto\"	TEXT,\n"
                + "	PRIMARY KEY(\"ID\" AUTOINCREMENT)\n"
                + ");\n"
                + "\n"
                + "CREATE TABLE \"animal\" (\n"
                + "	\"id_animal\"	INTEGER NOT NULL,\n"
                + "	\"id_finca\"	TEXT,\n"
                + "	\"nombre_animal\"	TEXT NOT NULL,\n"
                + "	\"fecha_ingreso\"	TEXT,\n"
                + "	\"fecha_nacimiento\"	INTEGER,\n"
                + "	\"tipo\"	TEXT NOT NULL,\n"
                + "	\"costo\"	REAL,\n"
                + "	\"color\"	TEXT,\n"
                + "	\"path_foto\"	TEXT,\n"
                + "	PRIMARY KEY(\"id_animal\"),\n"
                + "	FOREIGN KEY(\"id_finca\") REFERENCES \"finca\"(\"ID\") ON DELETE CASCADE\n"
                + ");\n"
                + "\n"
                + "CREATE TABLE \"tratamiento\" (\n"
                + "	\"id_animal\"	TEXT NOT NULL,\n"
                + "	\"fecha\"	TEXT NOT NULL,\n"
                + "	\"descripcion\"	TEXT NOT NULL,\n"
                + "	\"producto_utilizado\"	TEXT,\n"
                + "	FOREIGN KEY(\"id_animal\") REFERENCES \"animal\"(\"id_animal\") ON DELETE CASCADE\n"
                + ");";
        
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public boolean esValida() {
        return existeTabla("finca") && existeTabla("animal") && existeTabla("tratamiento");
    }
    
    private boolean existeTabla(String nombre){
        String sql = "SELECT name FROM sqlite_master WHERE type = 'table' and name = '" + nombre + "'";
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public List<Animal> filtrarAnimal(int idFinca, String campo, String patron) {
        String sql = "SELECT * FROM animal where id_finca = " + idFinca + " AND " + campo + " LIKE '" + patron + "%'";
        List<Animal> listaAnimales = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                listaAnimales.add(new Animal(rs, this));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAnimales;
    }

    @Override
    public List<String> getPathImagenes(String idAnimal) {
        String sql = "SELECT path FROM imagen_animal WHERE id_animal = '" + idAnimal + "'";
        ResultSet rs = null;
        List<String> pathImagenes = new ArrayList<>();
        
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                pathImagenes.add(rs.getString("path"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(rs == null)
            return null;
        else
            return pathImagenes;
    }

    @Override
    public void addPathImagen(String idAnimal, String pathImagen) {
        String sql = "INSERT INTO imagen_animal VALUES(?,?)";
        try {
            PreparedStatement s = conn.prepareStatement(sql);
            s.setString(1, idAnimal);
            s.setString(2, pathImagen);
            s.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void eliminarImagen(String idAnimal, String path) {
         String sql = "DELETE FROM imagen_animal WHERE id_animal = '" + idAnimal + "' AND path = '" + path + "'";
         
         try{
             Statement s = conn.createStatement();
             s.executeUpdate(sql);
         }catch(SQLException ex){
             Logger.getLogger(SQLiteSource.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
        
}
