package com.adingrt.cliente.caja;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adin Rubio
 */
public class CajaRegistradoraMain {
    public static void main(String[] args) {
        CajaRegistradoraVista seleccionDeMenu = new CajaRegistradoraVista();
        try {
            CajaRegistradoraController cajaController = new CajaRegistradoraController(seleccionDeMenu);
        } catch (IOException ex) {
            Logger.getLogger(CajaRegistradoraMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaRegistradoraMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        seleccionDeMenu.setVisible(true);
        
    }
    
}
