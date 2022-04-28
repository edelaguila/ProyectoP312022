package logistica.controlador;


public class clsProductos {
    private int proid;
    private int marid;
    private int linid;
    private String pronombre;
    private int procantidad;
    private double proprecio;
    private String prostatus;
    public clsProductos() {
    }

    public clsProductos(int proid) {
        this.proid = proid;
    }
    
    public clsProductos(String pronombre) {
        this.pronombre = pronombre;
    }
    
    public clsProductos(int proid, int marid, int linid, String pronombre, int procantidad, double proprecio, String prostatus) {
        this.proid = proid;
        this.marid = marid;
        this.linid = linid;
        this.pronombre = pronombre;
        this.procantidad = procantidad;
        this.proprecio = proprecio;
        this.prostatus = prostatus;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }
    
    public int getMarid() {
        return marid;
    }

    public void setMarid(int marid) {
        this.marid = marid;
    }

    public int getLinid() {
        return linid;
    }

    public void setLinid(int linid) {
        this.linid = linid;
    }
    public String getPronombre() {
        return pronombre;
    }

    public void setPronombre(String pronombre) {
        this.pronombre = pronombre;
    }

    public int getProcantidad() {
        return procantidad;
    }

    public void setProcantidad(int procantidad) {
        this.procantidad = procantidad;
    }
    
    public double getProprecio() {
        return proprecio;
    }

    public void setProprecio(double proprecio) {
        this.proprecio = proprecio;
    }
    
    public String getProstatus() {
        return prostatus;
    }

    public void setProstatus(String prostatus) {
        this.prostatus = prostatus;
    }

    public void setProcantidad(String procantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setProprecio(String proprecio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
