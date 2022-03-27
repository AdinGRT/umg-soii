package com.adingrt.datos;

import com.adingrt.negocio.Item;
import com.adingrt.negocio.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adin Rubio
 */
public class PedidoDAO {

    private static final String SQL_INSERT_PEDIDO = "INSERT INTO pedido (no_pedido, fecha, estado)\n"
            + "VALUES (?, now(), 1);";

    private static final String SQL_INSERT_ITEM = "INSERT INTO item (id_item, cantidad, id_producto, id_pedido)\n"
            + "VALUES (?, ?, ?, ?);";

    public int guardarPedidoBD(Pedido pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = Conexion.conectar();
            stmt = conn.prepareStatement(SQL_INSERT_PEDIDO, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pedido.getNumeroDePedido());
            rows = stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                pedido.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.desconectar(stmt);
                Conexion.desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rows;
    }

    public int guardarItemDB(Pedido pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.conectar();
            for (Item i : pedido.getItems()) {

                stmt = conn.prepareStatement(SQL_INSERT_ITEM);
                stmt.setInt(1, i.getNumeroDeItem());
                stmt.setInt(2, i.getCantidad());
                stmt.setInt(3, i.getProducto().getId());
                stmt.setInt(4, pedido.getId());
                rows = stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.desconectar(stmt);
                Conexion.desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rows;
    }
}
