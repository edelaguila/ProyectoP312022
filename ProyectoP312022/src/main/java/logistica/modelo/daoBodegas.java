/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;


import logistica.controlador.clsBodegas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoBodegas {

    private static final String SQL_SELECT = "SELECT bodid, proid, bodnombre, bodubicacion, bodingresos, bodegresos, bodstatus FROM tbl_bodegas";
    private static final String SQL_INSERT = "INSERT INTO tbl_bodegas ( bodnombre, bodubicacion, bodingresos, bodegresos, bodstatus) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bodegas SET bodnombre = ?, bodubicacion = ?, bodingresos = ?, bodegresos = ?, bodstatus = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_bodegas WHERE tbl_bodegas.bodid = ?";
    private static final String SQL_QUERY = "SELECT bodid, proid, bodnombre, bodubicacion, bodingresos, bodegresos, bodstatus FROM tbl_bodegas WHERE bodid=?";

    public List<clsBodegas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsBodegas producto = null;
        List<clsBodegas> product = new ArrayList<clsBodegas>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int bodid = rs.getInt("bodid");
                int proid = rs.getInt("proid");
                String bodnombre = rs.getString("bodnombre");
                String bodubicacion = rs.getString("bodubicacion");
                String bodingresos = rs.getString("bodingresos");
                String bodegresos = rs.getString("bodegresos");
                String bodstatus = rs.getString("bodstatus");
                

                producto = new clsBodegas();
                producto.setBodid(bodid);
                producto.setproid(proid);
                producto.setBodnombre(bodnombre);
                producto.setBodubicacion(bodubicacion);
                producto.setBodingresos(bodingresos);
                producto.setBodegresos(bodegresos);
                producto.setBodstatus(bodstatus);
                

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

   public int insert(clsBodegas producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getBodnombre());
            stmt.setString(2, producto.getBodubicacion());
            stmt.setString(3, producto.getBodingresos());
            stmt.setString(4, producto.getBodegresos());
            stmt.setString(5, producto.getBodstatus());
            stmt.setInt(6, producto.getBodid());
            stmt.setInt(7, producto.getProid());

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


    public int update(clsBodegas producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getBodnombre());
            stmt.setString(2, producto.getBodubicacion());
            stmt.setString(3, producto.getBodingresos());
            stmt.setString(4, producto.getBodegresos());
            stmt.setString(5, producto.getBodstatus());
            stmt.setInt(6, producto.getBodid());
            stmt.setInt(7, producto.getProid());
            

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

    public int delete(clsBodegas producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getBodid());
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

    public clsBodegas query(clsBodegas producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, producto.getBodid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int bodid = rs.getInt("bodid");
                int proid = rs.getInt("proid");
                String bodnombre = rs.getString("Bodnombre");
                String bodubicacion= rs.getString("Bodubicacion");
                String bodingresos= rs.getString("Bodingresos");
                String bodegresos= rs.getString("Bodegresos");
                String bodstatus= rs.getString("Bodstatus");

                producto = new clsBodegas();
              
                producto.setBodid(bodid);
                producto.setproid(proid);
                producto.setBodnombre(bodnombre);
                producto.setBodubicacion(bodubicacion);
                producto.setBodingresos(bodingresos);
                producto.setBodegresos(bodegresos);
                producto.setBodstatus(bodstatus);
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

    public void update(prototipos.controlador.clsBodegas bodegasAActualizar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
