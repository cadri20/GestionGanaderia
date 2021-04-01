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
    
    public Animal getAnimal(String id);
    public List<Animal> getAnimales(String nombreFinca);
    public Finca getFinca(String nombreFinca);
    public List<Finca> getFincas();
    public List<Tratamiento> getTratamientos(String idAnimal);
    public void addFinca(Finca finca) throws SQLException;
    public void addAnimal(String finca, Animal animal) throws SQLException;
    public void addTratamiento(String idAnimal, Tratamiento tratamiento) throws SQLException;
    public int countTipo(String finca, TipoAnimal tipo);
    public int getTotalAnimales(String finca);
    public void eliminarAnimal(String idAnimal) throws SQLException;
}
