/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipos.controlador;

import seguridad.controlador.*;

/**
 *
 * @author visitante
 */
public class clsTipoPago {
    int TPid;
    String TPnombrePago;
    String TpestatusPago;

    public clsTipoPago() {
    }

    public clsTipoPago(int id_aplicacion) {
        this.TPid= id_aplicacion;
    }

    public clsTipoPago(String nombreAplicacion, String estadoAplicacion) {
        this.TPnombrePago = nombreAplicacion;
        this.TpestatusPago = estadoAplicacion;
    }

    public int getId_aplicacion() {
        return TPid;
    }

    public void setId_aplicacion(int id_aplicacion) {
        this.TPid = id_aplicacion;
    }

    public String getNombreAplicacion() {
        return TPnombrePago;
    }

    public void setNombreAplicacion(String nombreAplicacion) {
        this.TPnombrePago = nombreAplicacion;
    }

    public String getestadoAplicacion() {
        return TpestatusPago;
    }

    public void setestadoAplicacion(String estadoAplicacion) {
        this.TpestatusPago = estadoAplicacion;
    }

    @Override
    public String toString() {
        return "tbl_aplicacion{" + "aplid=" + TPid + ", aplnombre=" + TPnombrePago + ", aplestatus=" + TpestatusPago + '}';
    }

    public int getId_pago() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombrePago() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getestadoPago() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_Pago() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setNombrePago(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setestadoPago(String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setId_pago(int id_pago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
