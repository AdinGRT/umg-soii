package com.adingrt.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class Pedido implements Serializable{
    private int id;
    private String fechaHora;
    private String numeroDePedido; //A10
    private String estado; //CONFIRMADO, PAGADO, ENTREGADO
    
    private List<Item> items; // 2 PANES CON JAMON // 1 LICUADO DE MELON // 1 LICUADO DE FRESA
    private double montoTotal; // SUMA DE LOS ITEMS

    public Pedido() {
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(String numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public void addItem(Item item) {
        this.items.add(item);
    }
    
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    
    public void mostrarPedido() {
        for (Item i: this.items){
            System.out.println(i);
        }
    }
    
}
