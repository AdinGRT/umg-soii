package com.adingrt.cliente.cocina;

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
public class CocinaTCP implements Runnable{
    private static final int AGREGAR_PEDIDO = 1;
    
    private int opcion;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    private PantallaPedidosControlador pantallaPedidosControlador;
    
    
    public CocinaTCP(Socket socket, PantallaPedidosControlador pantallaPedidosControlador) {
        this.socket = socket;
        this.pantallaPedidosControlador = pantallaPedidosControlador;
    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(this.socket.getInputStream());
            dos = new DataOutputStream(this.socket.getOutputStream());
            int codSvr = dis.readInt();
            System.out.println("Cocina Test -> Opcion: " + codSvr);
            switch (codSvr) {
                case AGREGAR_PEDIDO:
                    System.out.println("Cocina Test -> AGREGANDO PEDIDO");
                    agregarPedido(this.socket, this.pantallaPedidosControlador);
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
    
    private void agregarPedido(Socket socket, PantallaPedidosControlador pantallaPedidosControlador) throws IOException, ClassNotFoundException {
        Pedido pedido = new Pedido();
        ois = new ObjectInputStream(socket.getInputStream());
        pedido = (Pedido) ois.readObject();
        pantallaPedidosControlador.agregarPedido(pedido);
    }
}
