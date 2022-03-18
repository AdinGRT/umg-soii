package com.adingrt.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class Menu {
    
    private List<Producto> productos;
    
    public Menu() {
       this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public boolean agregarProducto(Producto producto) {
        return this.productos.add(producto);
    }
    
}
