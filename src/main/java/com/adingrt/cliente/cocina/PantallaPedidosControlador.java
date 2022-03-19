package com.adingrt.cliente.cocina;

import com.adingrt.cliente.ServiceLocatorTCP;
import com.adingrt.negocio.Item;
import com.adingrt.negocio.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Adin Rubio
 */
public class PantallaPedidosControlador {

    private ServiceLocatorTCP serviceLocator = new ServiceLocatorTCP();
    private PantallaPedidos pantallaPedidos = new PantallaPedidos();
    private PantallaPedidosVista pantallaPedidosVista = new PantallaPedidosVista();

    //private Lst<Producto> productos = new ArrayList<>();
    //private List<Producto> productosSeleccionados = new ArrayList<>();
    private List<TicketDePedidoPanel> ticketsPanel = new ArrayList<>();
    private List<ItemDePedidoPanel> itemsPanel = new ArrayList<>();

    public PantallaPedidosControlador(PantallaPedidosVista pantallaPedidosVista) {
        this.pantallaPedidosVista = pantallaPedidosVista;
        this.mostrarPedidosActivos();
        //this.activarEscucha();
    }

    public void agregarPedido(Pedido pedido) {
        this.pantallaPedidos.getPedidos().put(pedido.getNumeroDePedido(), pedido);
        ItemDePedidoPanel itemPanel2 = new ItemDePedidoPanel();

        TicketDePedidoPanel ticketPedido;
        ItemDePedidoPanel itemPanel;
        List<Item> items;
        ticketPedido = new TicketDePedidoPanel();

        this.pantallaPedidosVista.getPanelPedidos().add(ticketPedido);
        this.pantallaPedidosVista.getPanelPedidos().updateUI();

        ticketPedido.getLblNumeroPedido().setText(pedido.getNumeroDePedido());
        items = pedido.getItems();
        for (Item i : items) {
            itemPanel = new ItemDePedidoPanel();
            itemPanel.getTxtCantidad().setText(Integer.toString(i.getCantidad()));
            itemPanel.getTxtDescripcion().setText(i.getProducto().getDescripcion());
            ticketPedido.getPanelPedido().add(itemPanel);
            ticketPedido.getPanelPedido().updateUI();
        }
    }

    public void mostrarPedidosActivos() {
        //this.pantallaPedidos.setPedidos(this.serviceLocator.obtenerPedidosActivos());
        Map<String, Pedido> pedidos = this.pantallaPedidos.getPedidos();

        Set<String> numeros = pedidos.keySet();

        for (String numero : numeros) {
            this.agregarPedido(pedidos.get(numero));
        }
    }

}
