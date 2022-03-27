package com.adingrt.datos;

import com.adingrt.negocio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class ProductoDAO {

    private static final String SQL_SELECT = "SELECT * FROM producto;";

    public List<Producto> obtenerProductosBD() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        
        conn = Conexion.conectar();
        stmt = conn.prepareStatement(SQL_SELECT);
        
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            producto = new Producto();
            producto.setId(rs.getInt(1));
            producto.setDescripcion(rs.getString(2));
            producto.setPrecio(rs.getDouble(3));
            producto.setStock(rs.getInt(4));
            productos.add(producto);
        }
        return productos;
    }
//
//    public List<RegistroDeParqueo> listarRegistrosPorEstado(int idEstado) throws SQLException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        RegistroDeParqueo registro = null;
//
//        List<RegistroDeParqueo> registros = new ArrayList<>();
//
//        conn = Conexion.conectar();
//        stmt = conn.prepareStatement(SQL_SELECT_REGISTROS_POR_ESTADO);
//        stmt.setInt(1, idEstado);
//        rs = stmt.executeQuery();
//
//        while (rs.next()) {
//            registro = new RegistroDeParqueo();
//            registro.setIdRegistroParqueo(rs.getInt(1));
//            registro.setFechaHoraEntrada(rs.getString(2));
//            registro.setFechaHoraSalida(rs.getString(3));
//            registro.setEstado(EstadoRegistroDeParqueo.valueOf(String.valueOf(idEstado)));
//            registros.add(registro);
//        }
//        return registros;
//    }

}
