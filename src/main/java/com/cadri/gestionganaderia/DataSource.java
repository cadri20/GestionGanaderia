package com.cadri.gestionganaderia;

import com.cadri.gestionganaderia.Animal.TipoAnimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;

/**
 *
 * @author cadri
 */
public interface DataSource {
    
    public void init();
    public boolean esValida();
    
    public Animal getAnimal(String id);
    public List<Animal> getAnimales(int idFinca);
    public Finca getFinca(String nombreFinca);
    public List<Finca> getFincas();
    public List<Tratamiento> getTratamientos(String idAnimal);
    public void addFinca(Finca finca) throws SQLException;
    public void addAnimal(int idFinca, Animal animal) throws SQLException;
    public void addTratamiento(String idAnimal, Tratamiento tratamiento) throws SQLException;
    public int countTipo(int idFinca, TipoAnimal tipo);
    public int getTotalAnimales(int idFinca);
    public void eliminarAnimal(String idAnimal) throws SQLException;
    public void eliminarTratamiento(String id_animal, String fecha, String descripcion) throws SQLException;
    public void actualizarFinca(Finca finca) throws SQLException;
    public void actualizarAnimal(Animal animal) throws SQLException;
}
