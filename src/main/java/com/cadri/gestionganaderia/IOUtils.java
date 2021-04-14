package com.cadri.gestionganaderia;

import gui.AgregarAnimal;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cadri
 */
public class IOUtils {
    public static String guardarImagen(File imagen) {
        File archivoImagen = new File(Main.dirImg + File.separator + imagen.getName());
        try {
            archivoImagen.createNewFile();
            return Files.copy(imagen.toPath(), archivoImagen.toPath(), StandardCopyOption.REPLACE_EXISTING).toString();

        } catch (IOException ex) {
            Logger.getLogger(AgregarAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
