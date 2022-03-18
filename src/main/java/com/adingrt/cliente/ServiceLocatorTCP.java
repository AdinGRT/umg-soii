package com.adingrt.cliente;

import com.adingrt.negocio.Menu;
import com.adingrt.negocio.Pedido;
import com.adingrt.servidor.ServerTCP;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adin Rubio
 */
public class ServiceLocatorTCP {

    public static final String SERVER_IP = "192.168.0.16";
    public static final int SERVER_PORT = 9999;

    public ServiceLocatorTCP() {
    }

    public Menu obtenerMenu() throws IOException {
        Socket s = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            s = new Socket(SERVER_IP, SERVER_PORT);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());

            //Solicitud
            dos.writeInt(1);

            oos = new ObjectOutputStream(s.getOutputStream());
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
                if (dos != null) {
                    dos.close();
                }
                if (s != null) {
                    s.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException(ex);
            }
        }

        return null;
    }
    
    public void procesarPedido(Pedido pedido) throws IOException {
        Socket s = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            s = new Socket(SERVER_IP, SERVER_PORT);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());

            //Solicitud
            dos.writeInt(2);

            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(pedido);
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
                if (dos != null) {
                    dos.close();
                }
                if (s != null) {
                    s.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException(ex);
            }
        }
    }

}