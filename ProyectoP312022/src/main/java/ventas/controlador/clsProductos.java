/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.controlador;



/**
 *
 * @author visitante
 */
public class clsVentas {
    //declaracion de variable para Vendedores 
    int iId_venta;
    String sTipo;
    int iCantidad;
    String sProducto;
    String sFecha;
    int iId_cliente;

    public clsVentas() {
    }

    public clsVentas(int iId_venta) {
    this.iId_venta = iId_venta;
    }

     public clsVentas(int iId_venta, String sTipo, int iCantidad, String sProducto, String sFecha, int iId_cliente) {
        this.iId_venta = iId_venta;
        this.sTipo = sTipo;
        this.iCantidad = iCantidad;
        this.sProducto = sProducto;
        this.sFecha = sFecha;
        this.iId_cliente = iId_cliente;
    }



public int fGetid_Venta () {
        return iId_venta;
    }

    public void fSetid_Venta(int iId_venta) {
        this.iId_venta = iId_venta;
    }


    public String fGettipo_Venta() {
        return sTipo;
    }

    public void fSettipo_Venta(String sTipo) {
        this.sTipo = sTipo;
    }



public int fGetcantidad_Venta () {
        return iCantidad;
    }

    public void fSetcantidad_Venta(int iCantidad) {
        this.iCantidad = iCantidad;
    }



    public String fGetproducto_Venta() {
        return sProducto;
    }

    public void fSetproducto_Venta(String sProducto) {
        this.sProducto = sProducto;
    }



    public String fGetfecha_Venta() {
        return sFecha;
    }

    public void fSetfecha_Venta(String sFecha) {
        this.sFecha = sFecha;
    }

    

 public int fGetid_Cliente () {
        return iId_cliente;
    }

    public void fSetid_Cliente(int iId_cliente) {
        this.iId_cliente = iId_cliente;
    }




    @Override
    public String toString() {
         return "tbl_ventas{" + "id_venta =" + iId_venta + ", tipo=" + sTipo + ", cantidad=" + iCantidad + ", producto=" + sProducto +", fecha=" + sFecha +", id_cliente=" + iId_cliente + '}';
    }
    
}
