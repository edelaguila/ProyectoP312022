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

    public void setnombreperfil(String snombre) {
        this.sper_nombre = snombre;
    }

    public String getnombreperfil() {
        return sper_estado;
    }

    public void setEstado(String sestado) {
        this.sper_estado = sestado;
    }
    
    public String getEstado() {
        return sper_estado;
    }

    @Override
    public String toString() {
        return "tbl_perfil{" + "per_idPerfil=" + iper_id + ", per_NombrePerfil=" + sper_nombre + ", per_EstatusPerfil=" + sper_estado + '}';
    }
    
    
}
