/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;


import logistica.controlador.clsProductos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProductos {

    private static final String SQL_SELECT = "SELECT proid, marid, linid, pronombre, procantidad, proprecio, prostatus FROM tbl_productos";
    private static final String SQL_INSERT = "INSERT INTO tbl_productos ( marid, linid, pronombre, procantidad, proprecio) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_productos SET marid = ?, linid = ?, pronombre = ?, procantidad = ?, proprecio = ? FROM tbl_productos = ? WHERE tbl_productos.proid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_productos WHERE tbl_productos.proid = ?";
    private static final String SQL_QUERY = "SELECT proid, marid, linid, pronombre, procantidad, proprecio, prostatus FROM tbl_productos WHERE proid =?";

    public List<clsProductos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProductos producto = null;
        List<clsProductos> product = new ArrayList<clsProductos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int proid = rs.getInt("proid");
                int marid = rs.getInt("marid");
                int linid = rs.getInt("linid");
                String pronombre = rs.getString("pronombre");
                int procantidad = rs.getInt("procantidad");
                double proprecio = rs.getDouble("proprecio");
                String prostatus = rs.getString("prostatus");
                

                producto = new clsProductos();
                producto.setProid(proid);
                producto.setMarid(marid);
                producto.setLinid(linid);
                producto.setPronombre(pronombre);
                producto.setProcantidad(procantidad);
                producto.setProprecio(proprecio);
                producto.setProstatus(prostatus);
                

                product.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return product;
    }

   public int insert(clsProductos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getPronombre());
            stmt.setInt(2, producto.getProcantidad());
            stmt.setDouble(3, producto.getProprecio());
            stmt.setString(4, producto.getProstatus());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }


    public int update(clsProductos producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getPronombre());
            stmt.setInt(2, producto.getProcantidad());
            stmt.setDouble(3, producto.getProprecio());
            stmt.setString(4, producto.getProstatus());
            stmt.setInt(5, producto.getProid());
            stmt.setInt(6, producto.getMarid());
            stmt.setInt(7, producto.getLinid());
            

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsProductos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getProid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsProductos query(clsProductos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, producto.getProid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String pronombre = rs.getString("pronombre");
                int procantidad = rs.getInt("procantidad");
                double proprecio = rs.getDouble("proprecio");
                String prostatus = rs.getString("prostatus");

                producto = new clsProductos();
              
                producto.setPronombre(pronombre);
                producto.setProcantidad(procantidad);
                producto.setProprecio(proprecio);
                producto.setProstatus(prostatus);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return producto;
    }
}
