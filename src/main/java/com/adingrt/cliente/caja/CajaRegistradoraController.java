package com.adingrt.cliente.caja;

import com.adingrt.negocio.Item;
import com.adingrt.negocio.Menu;
import com.adingrt.negocio.Producto;
import com.adingrt.cliente.ServiceLocatorTCP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adin Rubio
 */
public class CajaRegistradoraController implements ActionListener {

    private ServiceLocatorTCP serviceLocator = new ServiceLocatorTCP();
    private CajaRegistradora caja = new CajaRegistradora();
    private CajaRegistradoraVista seleccionDeMenu = new CajaRegistradoraVista();

    private List<Producto> productos = new ArrayList<>();
    private List<Producto> productosSeleccionados = new ArrayList<>();
    private List<ProductoPanel> productosPanel = new ArrayList<>();

    private DefaultTableModel modelo = new DefaultTableModel();

    public CajaRegistradoraController(CajaRegistradoraVista seleccionDeMenu) throws IOException, ClassNotFoundException {
        this.seleccionDeMenu = seleccionDeMenu;
        this.seleccionDeMenu.getBtnConfirmar().addActionListener(this);
        this.seleccionDeMenu.getBtnCancelar().addActionListener(this);
        this.modelo.addColumn("Item");
        this.modelo.addColumn("Cantidad");
        this.modelo.addColumn("Subtotal");
        this.seleccionDeMenu.getjTablePedido().setModel(modelo);
        this.verMenu();
        this.nuevoPedido();

    }

    public void verMenu() throws IOException, ClassNotFoundException {
        Menu menu = serviceLocator.obtenerMenu();
        //Menu menu = new Menu();

//        menu.agregarProducto(new Producto(1, "Pan con Jamon", 7.0, 10));
//        menu.agregarProducto(new Producto(2, "Pan con Pollo", 8.0, 10));
//        menu.agregarProducto(new Producto(3, "Pan con Frijol", 6.0, 10));
//        menu.agregarProducto(new Producto(4, "Licuado de Banano con Leche", 10.0, 10));
//        menu.agregarProducto(new Producto(5, "Licuado de Fresa con Leche", 10.0, 10));
//        menu.agregarProducto(new Producto(6, "Licuado de Melon con Agua", 8.0, 10));
//        menu.agregarProducto(new Producto(7, "Licuado de Mora con Leche", 10.0, 10));
//        menu.agregarProducto(new Producto(8, "Licuado de Mora con Agua", 8.0, 10));

        for (Producto p : menu.getProductos()) {
            ProductoPanel productoPanel = new ProductoPanel();
            productoPanel.getLblDescripcionProducto().setText(p.getDescripcion());
            productoPanel.getLblPrecioProducto().setText(Double.toString(p.getPrecio()));
            productoPanel.getBtnAgregarItem().addActionListener(this);
            this.seleccionDeMenu.getjPanelMenu().add(productoPanel);
            this.seleccionDeMenu.getjPanelMenu().updateUI();
            this.productosPanel.add(productoPanel);
        }

        this.productos = menu.getProductos();

    }

    public void nuevoPedido() {
        this.caja.crearPedido();
    }

    public void agregarItemATablaPedido(JTable tabla, Producto producto) {
        int cantidad = 0;
        double subtotal = 0.0;
        int fila = tabla.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            String valor = this.modelo.getValueAt(i, 0).toString();
            if (valor.equals(producto.getDescripcion())) {
                cantidad = Integer.parseInt(this.modelo.getValueAt(i, 1).toString()) + 1;
                subtotal = Double.parseDouble(this.modelo.getValueAt(i, 2).toString());
                this.modelo.setValueAt(Integer.toString(cantidad), i, 1);
                this.modelo.setValueAt(Double.toString(cantidad * producto.getPrecio()), i, 2);
                this.mostrarTotalPedido(tabla);
                return;
            }
        }
        String[] info = new String[3];
        info[0] = producto.getDescripcion();
        info[1] = Integer.toString(1);
        info[2] = Double.toString(producto.getPrecio());
        this.productosSeleccionados.add(producto);
        this.modelo.addRow(info);
        this.mostrarTotalPedido(tabla);
    }

    public double calcularTotalPedido(JTable tabla) {
        double total = 0.0;
        int fila = tabla.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            total = total + Double.parseDouble(this.modelo.getValueAt(i, 2).toString());
        }
        return total;
    }

    public void mostrarTotalPedido(JTable tabla) {
        this.seleccionDeMenu.getLblTotal().setText(Double.toString(this.calcularTotalPedido(tabla)));
    }

    public void confirmarPedido(JTable tabla) { //IMPLEMENTAR METODO DEL SERVICELOCATOR
        this.caja.agregarItemsAPedido(this.tomarPedido(tabla));
        System.out.println("SE CONFIRMO PEDIDO ENVIANDO AL SERVIDOR");
        this.caja.getPedido().mostrarPedido();
        try {
            this.serviceLocator.procesarPedido(this.caja.getPedido());
        } catch (IOException ex) {
            Logger.getLogger(CajaRegistradoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Item> tomarPedido(JTable tabla) {
        List<Item> items = new ArrayList<>();
        int fila = tabla.getRowCount();
        for (int i = 0; i < fila; i++) {
            items.add(new Item(i + 1, this.productosSeleccionados.get(i), Integer.parseInt(tabla.getValueAt(i, 1).toString())));
        }
        return items;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 0;
        for (ProductoPanel pp : this.productosPanel) {

            if (e.getSource() == pp.getBtnAgregarItem()) {
                System.out.println(pp.getLblDescripcionProducto().getText());
                System.out.println("INDICE: " + i);
                System.out.println(productos.get(i));
                this.agregarItemATablaPedido(this.seleccionDeMenu.getjTablePedido(), productos.get(i));
            }
            i++;
        }

        if (e.getSource() == this.seleccionDeMenu.getBtnConfirmar()) {
            this.confirmarPedido(this.seleccionDeMenu.getjTablePedido());
        }

    }

}
