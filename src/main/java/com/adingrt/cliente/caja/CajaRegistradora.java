package com.adingrt.cliente.caja;

import com.adingrt.negocio.Item;
import com.adingrt.negocio.Menu;
import com.adingrt.negocio.Pedido;
import com.adingrt.negocio.Producto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class CajaRegistradora {
    private int id;
    
    private Pedido pedido;

    public CajaRegistradora() {
    }

    public CajaRegistradora(int id) {
        this.id = id;
    }
    
    public void crearPedido(){
        this.pedido = new Pedido();
        this.pedido.setFechaHora(this.obtenerFechaHora());
    }
    
    public void agregarItemsAPedido(List<Item> items) {
        this.pedido.setItems(items);
    }
    
    public void procesarPago(){
        System.out.println("NO IMPLEMENTADO");
    }
    
    public void verMenu(Menu menu) {
        for (Producto p: menu.getProductos()){
            System.out.println(p);
        }
    }
    
    public String obtenerFechaHora() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String fechaHora = dateFormat.format(date);
        return fechaHora;
    }

    public int getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }
    
}
