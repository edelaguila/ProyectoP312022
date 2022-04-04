*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import seguridad.controlador.clsBitacora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    //int id_aplicacion;
    //String nombre_aplicacion;
    //String estado_aplicacion;
/**
 *
 * @author visitante
 */
public class daoBitacora {

    private static final String SQL_SELECT = "SELECT id_bitacora, fecha, accion, id_usuario, id_aplicacion, ip, nombrepc FROM bitacora";
    private static final String SQL_INSERT = "INSERT INTO bitacora(fecha, accion, id_usuario, id_aplicacion, ip, nombrepc) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE bitacora SET fecha=?, accion=?, id_usuario=?, id_aplicacion=?, ip=?, nombrepc=? WHERE id_bitacora = ?";
    private static final String SQL_DELETE = "DELETE FROM bitacora WHERE id_bitacora=?";
    private static final String SQL_QUERY = "SELECT id_bitacora, fecha, accion, id_usuario, id_aplicacion, ip, nombrepc FROM bitacora WHERE id_aplicacion = ?";


//se agrega metodo para bitacora
//averiguar IP

    public List<clsBitacora> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsBitacora bitacora = null;
        List<clsBitacora> bitacoras = new ArrayList<clsBitacora>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_bitacora = rs.getInt("id_bitacora");
                String fecha = rs.getString("fecha");
                String accion = rs.getString("accion");
                String ip = rs.getString("ip");
                String nombrepc = rs.getString("nombrepc");
                int id_usuario = rs.getInt("id_usuario");
                int id_aplicacion = rs.getInt("id_aplicacion");
                
                bitacora = new clsBitacora();
                bitacora.fSetId_Bitacora(id_bitacora);
                bitacora.fSetfecha_Bitacora(fecha);
                bitacora.fSetaccion_Bitacora(accion);
                bitacora.fSetip_Bitacora(ip);
                bitacora.fSetnombrepc_Bitacora(nombrepc);
                bitacora.fSetId_Usuario(id_usuario);
                bitacora.fSetId_Aplicacion(id_aplicacion);
                
                bitacoras.add(bitacora);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return bitacoras;
    }

    public int insert(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bitacora.fGetfecha_Bitacora());
            stmt.setString(2, bitacora.fGetaccion_Bitacora());
            stmt.setInt(3, bitacora.fGetId_Aplicacion());
            stmt.setInt(4, bitacora.fGetId_Usuario());
            stmt.setString(5, bitacora.fGetip_Bitacora());
            stmt.setString(6, bitacora.fGetnombrepc_Bitacora());


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

    public int update(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, bitacora.fGetfecha_Bitacora());
            stmt.setString(2, bitacora.fGetaccion_Bitacora());
            stmt.setInt(3, bitacora.fGetId_Aplicacion());
            stmt.setInt(4, bitacora.fGetId_Usuario());
            stmt.setString(5, bitacora.fGetip_Bitacora());
            stmt.setString(6, bitacora.fGetnombrepc_Bitacora());

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

    public int delete(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bitacora.fGetId_bitacora());
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
    public clsBitacora query(clsBitacora bitacora) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsBitacora> bitacoras = new ArrayList<clsBitacora>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, bitacora.fGetId_bitacora());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_bitacora = rs.getInt("id_bitacora");
                String fecha = rs.getString("fecha");
                String accion = rs.getString("accion");
                String ip = rs.getString("ip");
                String nombrepc = rs.getString("nombrepc");
                int id_usuario = rs.getInt("id_usuario");
                int id_aplicacion = rs.getInt("id_aplicacion");
                
                bitacora = new clsBitacora();
                bitacora.fSetId_Bitacora(id_bitacora);
                bitacora.fSetfecha_Bitacora(fecha);
                bitacora.fSetaccion_Bitacora(accion);
                bitacora.fSetip_Bitacora(ip);
                bitacora.fSetnombrepc_Bitacora(nombrepc);
                bitacora.fSetId_Usuario(id_usuario);
                bitacora.fSetId_Aplicacion(id_aplicacion);
                
               
                
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
        return bitacora;
    }
        
}
