/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsModulo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoModulo {

    private static final String SQL_SELECT = "SELECT Id_Modulo, Codigo, Nombre, Estatus FROM tbl_modulo";
    private static final String SQL_INSERT = "INSERT INTO tbl_modulo(Codigo, Nombre, Estatus) VALUES(?, ?, ? )";
    private static final String SQL_UPDATE = "UPDATE tbl_modulo SET Codigo=?, Nombre=?, Estatus=? WHERE Id_Modulo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_modulo WHERE Id_Modulo=?";
    private static final String SQL_QUERY = "SELECT Id_Modulo, Codigo, Nombre, Estatus FROM tbl_modulo WHERE Id_Modulo = ?";

    public List<clsModulo> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsModulo modulo = null;
        List<clsModulo> modulos = new ArrayList<clsModulo>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_Modulo = rs.getInt("Id_Modulo");
                String Codigo = rs.getString("Codigo");
                String Nombre = rs.getString("Nombre");
                String Estatus = rs.getString("Estatus");

                modulo = new clsModulo();
                modulo.fSetid_modulo(Id_Modulo);
                modulo.fSetcodigo(Codigo);
                modulo.fSetnombre(Nombre);
                modulo.fSetestatus(Estatus);
                modulos.add(modulo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return modulos;
    }

    public int insert(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, modulo.fGetcodigo());
            stmt.setString(2, modulo.fGetnombre());
            stmt.setString(3, modulo.fGetstatus());

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

    public int update(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, modulo.fGetcodigo());
            stmt.setString(2, modulo.fGetnombre());
            stmt.setString(3, modulo.fGetstatus());
            stmt.setInt(4, modulo.fGetid_modulo());

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

    public int delete(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, modulo.fGetid_modulo());
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

    public clsModulo query(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, modulo.fGetcodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_Modulo = rs.getInt("Id_Modulo");
                String Codigo = rs.getString("Codigo");
                String Nombre = rs.getString("Nombre");
                String Estatus = rs.getString("Estatus");

                modulo = new clsModulo();
                modulo.fSetid_modulo(Id_Modulo);
                modulo.fSetcodigo(Codigo);
                modulo.fSetnombre(Nombre);
                modulo.fSetestatus(Estatus);
              
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
        return modulo;
    }
}
