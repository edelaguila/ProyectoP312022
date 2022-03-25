package prototipos.controlador;

import seguridad.controlador.*;

public class clsTipoDoctos {
    private int idoc_id;
    private String sdoc_nombre;
    private String sdoc_estado;

    public clsTipoDoctos() {
    }

    public clsTipoDoctos(int idoc) {
        this.idoc_id = idoc;
    }
    
    public clsTipoDoctos(String snombre, String sestado) {
        this.sdoc_nombre = snombre;
        this.sdoc_estado = sestado;
    }
    
    public clsTipoDoctos(int iido, String snombre, String sestado) {
        this.idoc_id = iido;
        this.sdoc_nombre = snombre;
        this.sdoc_estado = sestado;
    }
    

    public int getId_documentos() {
        return idoc_id;
    }

    public void setId_documentos(int ido) {
        this.idoc_id = ido;
    }

    public String getperfil() {
        return sdoc_nombre;
    }

    public void setNombre(String snombre) {
        this.sdoc_nombre = snombre;
    }

    public String getNombre() {
        return sdoc_nombre;
    }

    public void setestado(String sestado) {
        this.sdoc_estado = sestado;
    }
    
    public String getEstado() {
        return sdoc_estado;
    }

    @Override
    public String toString() {
        return "tbl_perfil{" + "per_idPerfil=" + idoc_id + ", per_NombrePerfil=" + sdoc_nombre + ", per_EstatusPerfil=" + sdoc_estado + '}';
    }
    
    
}
