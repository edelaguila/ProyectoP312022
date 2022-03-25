/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipos.modelo;

import seguridad.modelo.*;
import prototipos.controlador.clsTipoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipoPago {

    private static final String SQL_SELECT = "SELECT TPid, TPnombre, TPestatus FROM tbl_TipoPago";
    private static final String SQL_INSERT = "INSERT INTO tbl_TipoPago(TPnombre, TPestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_TipoPago SET TPnombre=?, TPestatus=? WHERE TPid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_TipoPago WHERE TPid=?";
    private static final String SQL_QUERY = "SELECT TPid, TPnombre, TPestatus FROM tbl_TipoPago WHERE TPid = ?";

    public List<clsTipoPago> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsTipoPago pago = null;
        List<clsTipoPago> pagos = new ArrayList<clsTipoPago>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_pago = rs.getInt("TPid");
                String nombre = rs.getString("TPnombre");
                String estado = rs.getString("TPestatus");
                
                pago = new clsTipoPago();
                pago.setId_pago(id_pago);
                pago.setNombrePago(nombre);
                pago.setestadoPago(estado);
                
                pagos.add(pago);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return pagos;
    }

    public int insert(clsTipoPago pago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pago.getNombrePago());
            stmt.setString(2, pago.getestadoPago());


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

    public int update(clsTipoPago pago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pago.getNombrePago());
            stmt.setString(2, pago.getestadoPago());
            stmt.setInt(3, pago.getId_Pago());

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

    public int delete(clsTipoPago pago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pago.getId_pago());
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

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsTipoPago query(clsTipoPago pago) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsTipoPago> pagos = new ArrayList<clsTipoPago>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, pago.getId_pago());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aplicacion = rs.getInt("TPid");
                String nombre = rs.getString("TPnombre");
                String estado = rs.getString("TPestatus");
                
                pago = new clsTipoPago();
                pago.setId_aplicacion(id_aplicacion);
                pago.setNombreAplicacion(nombre);
                pago.setestadoAplicacion(estado);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return pago;
    }
        
}
