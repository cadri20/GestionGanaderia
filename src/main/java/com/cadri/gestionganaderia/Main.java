package com.cadri.gestionganaderia;

import gui.Inicio;
import gui.MenuPrincipal;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author cadri
 */
public class Main {
    public static void main(String[] args){
        try {
            File dirUsuario = new File(System.getProperty("user.home") + File.separator + "Gestion Ganaderia");
            File archivoDB = new File(dirUsuario.getAbsolutePath() + File.separator + "database.db");                  
            
            if(!dirUsuario.exists()){
                dirUsuario.mkdir();                                
            }  
                  
            DataSource datos = new SQLiteSource(archivoDB);
            if(!datos.esValida())
                datos.init();
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame inicio = new Inicio(datos);
            inicio.setLocationRelativeTo(null);
            inicio.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
