package logistica.controlador;


public class clsBodegas {
    private int bodid;
    private int proid;
    private String bodnombre;
    private String bodubicacion;
    private String bodingresos;
    private String bodegresos;
    private String bodstatus;
    public clsBodegas() {
    }

    public clsBodegas(int bodid) {
        this.bodid = bodid;
    }
    
    public clsBodegas(String bodnombre) {
        this.bodnombre = bodnombre;
    }
    
    public clsBodegas(int bodid, int proid, String bodnombre, String bodingresos, String bodegresos, String bodstatus) {
        this.bodid = bodid;
        this.proid = proid;
        this.bodnombre = bodnombre;
        this.bodingresos = bodingresos;
        this.bodegresos = bodegresos;
        this.bodstatus = bodstatus;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getBodid() {
        return bodid;
    }

    public void setBodid(int bodid) {
        this.bodid = bodid;
    }
    
    public int getProid() {
        return proid;
    }

    public void setproid(int proid) {
        this.proid = proid;
    }

    public String getBodnombre() {
        return bodnombre;
    }

    public void setBodnombre(String bodnombre) {
        this.bodnombre = bodnombre;
    }

    public String getBodubicacion() {
        return bodubicacion;
    }

    public void setBodubicacion(String bodubicacion) {
        this.bodubicacion = bodubicacion;
    }
    
    public String getBodingresos() {
        return bodingresos;
    }

    public void setBodingresos(String bodingresos) {
        this.bodingresos = bodingresos;
    }
    
    public String getBodegresos() {
        return bodegresos;
    }

    public void setBodegresos(String bodegresos) {
        this.bodegresos = bodegresos;
    }
    public String getBodstatus() {
        return bodstatus;
    }

    public void setBodstatus(String bodstatus) {
        this.bodstatus = bodstatus;
    }
}
