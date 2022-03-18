package com.adingrt.negocio;

import java.io.Serializable;

/**
 *
 * @author Adin Rubio
 */
public class Item implements Serializable {
    private int numeroDeItem;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    
    public double calcularSubTotal(){
        return this.cantidad * this.producto.getPrecio();
    }

    public Item(int numeroDeItem, Producto producto, int cantidad) {
        this.numeroDeItem = numeroDeItem;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public int getNumeroDeItem() {
        return numeroDeItem;
    }

    public void setNumeroDeItem(int numeroDeItem) {
        this.numeroDeItem = numeroDeItem;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getSubTotal(){
        return this.producto.getPrecio() * this.cantidad;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item{");
        sb.append("numeroDeItem=").append(numeroDeItem);
        sb.append(", producto=").append(producto);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }
    
}
