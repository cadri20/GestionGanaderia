package gui;

import com.cadri.gestionganaderia.Animal;
import com.cadri.gestionganaderia.Finca;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cadri
 */
public class GUIManager {

    public static FileNameExtensionFilter filtroArchivos = new FileNameExtensionFilter("Imagen", "jpeg", "png");
    
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
    
    public static String getIDAnimalSeleccionado(JFrame root, Finca fincaGestionada){
        SeleccionAnimal seleccionAnimal = new SeleccionAnimal(root, true, fincaGestionada);
        seleccionAnimal.setVisible(true);
        seleccionAnimal.dispose();
        
        return seleccionAnimal.getIdSeleccionada();
    }

    public static void dibujarImagen(Image foto, JLabel label){
        ImageIcon icono = new ImageIcon(foto.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }    

}
