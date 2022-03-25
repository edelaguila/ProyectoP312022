/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipos.modelo;

import seguridad.controlador.clsPerfil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProveedores {

    private static final String SQL_SELECT = "SELECT proid, pronombre, proestado FROM tbl_proveedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_proveedores(proid,pronombre) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_proveedores SET proid=?, proestado=? WHERE proid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_proveedores WHERE proid=?";
    private static final String SQL_QUERY = "SELECT proid, pronombre, proestado FROM tbl_proveedores WHERE pronombre = ?";

    public List<clsPerfil> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfil usuario = null;
        List<clsPerfil> usuarios = new ArrayList<clsPerfil>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("proid");
                String sPerfil_nombre = rs.getString("pronombre");
                String sPerfil_estado = rs.getString("proestado");

                usuario = new clsPerfil();
                usuario.setId_perfil(iPerfil_id);
                usuario.setnombreperfil(sPerfil_nombre);
                usuario.setEstado(sPerfil_estado);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getnombreperfil());
            stmt.setString(2, perfil.getEstado());

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

    public int update(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, perfil.getnombreperfil());
            stmt.setString(2, perfil.getEstado());
            stmt.setInt(3, perfil.getId_perfil());

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

    public int delete(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getId_perfil());
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

    public clsPerfil query(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, perfil.getnombreperfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("per_idPerfil");
                String sPerfil_nombre = rs.getString("pronombre");
                String sPerfil_estado = rs.getString("proestado");

                perfil = new clsPerfil();
                perfil.setId_perfil(iPerfil_id);
                perfil.setnombreperfil(sPerfil_nombre);
                perfil.setEstado(sPerfil_estado);
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
        return perfil;
    }
}
