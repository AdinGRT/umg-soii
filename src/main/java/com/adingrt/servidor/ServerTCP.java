package com.adingrt.servidor;

import com.adingrt.TestCocina;
import com.adingrt.negocio.Pedido;
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
public class ServerTCP implements Runnable{

    private static final int OBTENER_MENU = 1;
    private static final int PROCESAR_PEDIDO = 2;
    private static final int CANCELAR_PEDIDO = 3;
    private static final int OBTENER_PEDIDOS = 4;
    private static final int ACTUALIZAR_PEDIDO = 5;
    private static final int ACTUALIZAR_STOCK = 6;
    
    
    private int opcion;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public ServerTCP(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(this.socket.getInputStream());
            dos = new DataOutputStream(this.socket.getOutputStream());
            
            
            int codSvr = dis.readInt();
            
            
            System.out.println("Server Test -> Opcion: " + codSvr);
            switch (codSvr) {
                case PROCESAR_PEDIDO:
                    System.out.println("Server Test -> IMPRIMIENDO PEDIDO");
                    procesarPedido(this.socket);
                    break;
                case CANCELAR_PEDIDO:
                    System.out.println("Server Test -> Logica para Cancelar Un Pedido");
                    break;
                default:
                    System.out.println("Server Test -> Opcion no valida.");
                    break;
            }

        } catch (IOException ex) {
            Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void procesarPedido(Socket socket) throws IOException, ClassNotFoundException{
        Pedido pedido = new Pedido();
        ois = new ObjectInputStream(socket.getInputStream());
        pedido = (Pedido) ois.readObject();
        pedido.mostrarPedido();
        this.enviarPedido(pedido);
    }
    
    private void enviarPedido(Pedido pedido) {
        String ipClienteCocina = "192.168.0.16";
        int puertoClienteCocina = 5000;
        
        Socket s = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            s = new Socket(ipClienteCocina, puertoClienteCocina);
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
