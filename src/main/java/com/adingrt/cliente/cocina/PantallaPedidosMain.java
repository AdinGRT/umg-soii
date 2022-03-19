package com.adingrt.cliente.cocina;

import com.adingrt.servidor.ServerTest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adin Rubio
 */
public class PantallaPedidosMain {

    public static void main(String[] args) {
        PantallaPedidosVista pantallaPedidosVista = new PantallaPedidosVista();
        PantallaPedidosControlador ppControlador = new PantallaPedidosControlador(pantallaPedidosVista);
        pantallaPedidosVista.setVisible(true);
        try {
            ServerSocket ss = new ServerSocket(5000);
            Socket s;
            while(true) {
                System.out.println("Test Cliente Cocina -> Esperando conexiones...");
                s = ss.accept();
                Thread thread = new Thread(new CocinaTCP(s, ppControlador));
                thread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        

    }
}
