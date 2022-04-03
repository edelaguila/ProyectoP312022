/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;
import seguridad.vista.frmMantenimientoPapps;
import seguridad.controlador.clsPerfilAplicaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPerfilApps {

    private static final String SQL_SELECT = "SELECT  perid,aplid FROM tbl_aplicacionperfil";
   
    private static final String SQL_INSERT = "INSERT INTO tbl_aplicacionperfil (perid, aplid, aplperR, aplperE, aplperM, aplperL, aplperB) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_aplicacionesperfil SET perid=?, aplid=? WHERE perid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_aplicacionesperfil WHERE perid=?";
    private static final String SQL_DELETE2 = "DELETE FROM tbl_aplicacionperfil WHERE tbl_aplicacionperfil.aplid = ? AND tbl_aplicacionperfil.perid = ?";
    private static final String SQL_QUERY = "SELECT  perid, aplid FROM tbl_aplicacionperfil WHERE perid = ?";
     private static final String SQL_QUERY2 = "SELECT tbl_aplicacionperfil.aplid, tbl_aplicacionperfil.perid , tbl_aplicacion.aplnombre FROM tbl_aplicacionperfil INNER JOIN tbl_aplicacion ON tbl_aplicacionperfil.aplid=tbl_aplicacion.aplid  WHERE tbl_aplicacionperfil.perid=?";
//"SELECT perid ,aplnombre FROM tbl_aplicacionperfil INNER JOIN tbl_aplicacion ON tbl_aplicacionperfil.aplid=tbl_aplicacion.aplid  WHERE perid=?";
    public List<clsPerfilAplicaciones> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilAplicaciones usuario = null;
        List<clsPerfilAplicaciones> usuarios = new ArrayList<clsPerfilAplicaciones>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int perfil = rs.getInt("perid");
                int aplicacion = rs.getInt("aplid");

                usuario = new clsPerfilAplicaciones();
               
                usuario.setPerid(perfil);
                usuario.setAplid(aplicacion);

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

    public int insert(clsPerfilAplicaciones perfil_app) {
        frmMantenimientoPapps ventana = new frmMantenimientoPapps();
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            if(ventana.getVa()==1){
            for (int i = 0; i < 10; i++) {
                stmt.setInt(i, perfil_app.getPerid());
            }
            }
             stmt.setInt(1, perfil_app.getPerid());
            stmt.setInt(2, perfil_app.getAplid());
            stmt.setInt(3,perfil_app.getAplperR());
            stmt.setInt(4,perfil_app.getAplperE());
            stmt.setInt(5,perfil_app.getAplperM());
            stmt.setInt(6,perfil_app.getAplperL());
            stmt.setInt(7,perfil_app.getAplperB());
            
           

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

    public int update(clsPerfilAplicaciones perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, perfil_app.getPerid());
            stmt.setInt(2, perfil_app.getAplid());
            

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

    public int delete(clsPerfilAplicaciones perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
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

    public clsPerfilAplicaciones query(clsPerfilAplicaciones perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, perfil_app.getPerid());
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int username = rs.getInt("perid");
                int password = rs.getInt("aplid");

                perfil_app = new clsPerfilAplicaciones();
                perfil_app.setPerid(username);
                perfil_app.setAplid(password);
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
        return perfil_app;
    }
    
    
    
     public List<clsPerfilAplicaciones> select2(clsPerfilAplicaciones perApl) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilAplicaciones usuario = null;
        List<clsPerfilAplicaciones> usuarios = new ArrayList<clsPerfilAplicaciones>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setInt(1, perApl.getPerid());            
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int aplicacion = rs.getInt("aplid");
                int perfil = rs.getInt("perid");
                String nombreAplicacion = rs.getString("aplnombre");

                usuario = new clsPerfilAplicaciones();
               
                usuario.setPerid((perfil));
                usuario.setAplid((aplicacion));
                usuario.setAplnombre(String.valueOf(nombreAplicacion));
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
     
     
       public int delete2(clsPerfilAplicaciones perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setInt(1, perfil.getAplid());
            stmt.setInt(2, perfil.getPerid());
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
     
     
     
     
     
     
     
     
     
     
     
}
