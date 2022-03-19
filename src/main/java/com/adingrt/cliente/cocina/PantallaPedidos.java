package com.adingrt.cliente.cocina;

import com.adingrt.negocio.Item;
import com.adingrt.negocio.Pedido;
import com.adingrt.negocio.Producto;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Adin Rubio
 */
public class PantallaPedidos {
    
    private int id;
    
    private Map<String, Pedido> pedidos;
    
    public void actualizarPedido(){
        
    }
    
    public void cancelarPedido() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Pedido> getPedidos() {
        Pedido pedido = new Pedido();
        pedido.setId(1);
        pedido.setNumeroDePedido("A01");
        pedido.addItem(new Item(1, new Producto(1, "Pan con Jamon", 7.0, 10), 2));
        pedido.addItem(new Item(2, new Producto(4, "Licuado de Banano con Leche", 10.0, 10), 2));
        
        Pedido pedido2 = new Pedido();
        pedido2.setId(1);
        pedido2.setNumeroDePedido("A02");
        pedido2.addItem(new Item(1, new Producto(3, "Pan con Frijol", 6.0, 10), 1));
        pedido2.addItem(new Item(2, new Producto(8, "Licuado de Mora con Agua", 8.0, 10), 1));
        pedido2.addItem(new Item(3, new Producto(6, "Licuado de Melon con Agua", 8.0, 10), 1));
        
        this.pedidos = new HashMap<>();
        
        
        this.pedidos.put(pedido.getNumeroDePedido(), pedido);
        this.pedidos.put(pedido2.getNumeroDePedido(), pedido2);
        
        
        return pedidos;
    }

    public void setPedidos(Map<String, Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
}
