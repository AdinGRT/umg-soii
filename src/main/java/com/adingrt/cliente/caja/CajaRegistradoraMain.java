package com.adingrt.cliente.caja;

/**
 *
 * @author Adin Rubio
 */
public class CajaRegistradoraMain {
    public static void main(String[] args) {
        CajaRegistradoraVista seleccionDeMenu = new CajaRegistradoraVista();
        CajaRegistradoraController cajaController = new CajaRegistradoraController(seleccionDeMenu);
        seleccionDeMenu.setVisible(true);
        
    }
    
}
