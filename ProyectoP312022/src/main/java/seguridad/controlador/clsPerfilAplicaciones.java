package seguridad.controlador;

public class clsPerfilAplicaciones {

    private String perid;//perfil id
    private String aplid;//aplicacion id

    public clsPerfilAplicaciones() {
    }


    
    public clsPerfilAplicaciones(String perid, String aplid) {
        this.perid = perid;
        this.aplid = aplid;
    }
    
 
   

    public String getUsername() {
        return perid;
    }

    public void setUsername(String perid) {
        this.perid= perid;
    }

    public String getPassword() {
        return aplid;
    }

    public void setPassword(String aplid) {
        this.aplid = aplid;
    }

    @Override
    public String toString() {
        return "PerfilAplicacion{"  + " Pefil=" + perid + ", aplicacion=" + aplid + '}';
    }
    
    
}
