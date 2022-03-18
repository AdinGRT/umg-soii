package com.adingrt;

import com.adingrt.cliente.caja.CajaRegistradora;
import com.adingrt.negocio.Item;
import com.adingrt.negocio.Menu;
import com.adingrt.negocio.Pedido;
import com.adingrt.negocio.Producto;

/**
 *
 * @author Adin Rubio
 */
public class Test {
    public static void main(String[] args) {
        
        
        Menu menu = new Menu();
        
        menu.agregarProducto(new Producto(1, "Pan con Jamon", 7.0, 10));
        menu.agregarProducto(new Producto(2, "Pan con Pollo", 8.0, 10));
        menu.agregarProducto(new Producto(3, "Pan con Frijol", 6.0, 10));
        menu.agregarProducto(new Producto(4, "Licuado de Banano con Leche", 10.0, 10));
        menu.agregarProducto(new Producto(5, "Licuado de Fresa con Leche", 10.0, 10));
        menu.agregarProducto(new Producto(6, "Licuado de Melon con Agua", 10.0, 10));
        
        CajaRegistradora caja = new CajaRegistradora();
        
        caja.verMenu(menu);
        
        System.out.println("\nAGREGAR PRODUCTOS A LA COMPRA");
        
        Pedido pedido = new Pedido();
        
        pedido.addItem(new Item(1, menu.getProductos().get(1), 3));
        pedido.addItem(new Item(5, menu.getProductos().get(4), 2));
        
        pedido.mostrarPedido();
        
        
        
        
        System.out.println(menu.getProductos().get(0));
        
    }
}
