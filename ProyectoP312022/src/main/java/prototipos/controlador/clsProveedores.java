package prototipos.controlador;

import seguridad.controlador.*;

public class clsProveedores {
    private int proid;
    private String pronombre;
    private String proestado;

    public clsProveedores() {
    }

    public clsProveedores(int iid) {
        this.proid = iid;
    }
    
    public clsProveedores(String snombre, String sestado) {
        this.pronombre = snombre;
        this.proestado = sestado;
    }
    
    public clsProveedores(int iid, String snombre, String sestado) {
        this.proid = iid;
        this.pronombre = snombre;
        this.proestado = sestado;
    }
    

    public int getId_perfil() {
        return proid;
    }

    public void setId_perfil(int iid) {
        this.proid = iid;
    }

 

    public void setnombreperfil(String snombre) {
        this.pronombre = snombre;
    }

    public String getnombreperfil() {
        return proestado;
    }

    public void setEstado(String sestado) {
        this.proestado = sestado;
    }
    
    public String getEstado() {
        return proestado;
    }

    @Override
    public String toString() {
        return "tbl_perfil{" + "per_idPerfil=" + proid+ ", per_NombrePerfil=" + pronombre+ ", per_EstatusPerfil=" + proestado + '}';
    }
    
    
}
