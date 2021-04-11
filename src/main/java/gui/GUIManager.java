package gui;

import com.cadri.gestionganaderia.Animal;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cadri
 */
public class GUIManager {

    public static void ponerAnimalesEnTabla(JTable tabla, List<Animal> animales) {
        tabla.setModel(new DefaultTableModel(getMatrizAnimales(animales), new String[]{"ID", "Nombre"}));
    }
    
    private static String[][] getMatrizAnimales(List<Animal> listaAnimales) {
        String[][] matrizAnimales = new String[listaAnimales.size()][2];
        int i = 0;

        for (Animal animal : listaAnimales) {
            matrizAnimales[i][0] = animal.getId();
            matrizAnimales[i][1] = animal.getNombre();
            i++;
        }

        return matrizAnimales;
    }
}
