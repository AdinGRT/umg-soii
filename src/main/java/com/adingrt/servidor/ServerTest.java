package com.adingrt.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adin Rubio
 */
public class ServerTest {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            Socket s;
            while(true) {
                System.out.println("Test Server -> Esperando conexiones...");
                s = ss.accept();
                Thread thread = new Thread(new ServerTCP(s));
                thread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
