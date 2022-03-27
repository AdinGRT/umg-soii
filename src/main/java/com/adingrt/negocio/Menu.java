package com.adingrt.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class Menu implements Serializable {
    
    private List<Producto> productos;
    
    public Menu() {
       this.productos = new ArrayList<>();
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public boolean agregarProducto(Producto producto) {
        return this.productos.add(producto);
    }
    
}
