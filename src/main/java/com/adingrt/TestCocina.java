package com.adingrt;

import com.adingrt.negocio.Item;
import com.adingrt.negocio.Pedido;
import com.adingrt.negocio.Producto;
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
public class TestCocina {
    
    public static final String SERVER_IP = "192.168.1.206";
    public static final int SERVER_PORT = 9999;
    
    public static void main(String[] args) {
        
        Pedido pedido = new Pedido();
        pedido.setId(1);
        pedido.setNumeroDePedido("A03");
        pedido.addItem(new Item(1, new Producto(1, "Pan con Jamon", 7.0, 10), 3));
        pedido.addItem(new Item(2, new Producto(4, "Licuado de Banano con Leche", 10.0, 10), 1));
        
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
            oos.writeObject(pedido);
        } catch (IOException ex) {
            Logger.getLogger(TestCocina.class.getName()).log(Level.SEVERE, null, ex);
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
