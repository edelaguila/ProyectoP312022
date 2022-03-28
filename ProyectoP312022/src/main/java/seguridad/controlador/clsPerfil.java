package seguridad.controlador;

public class clsPerfil {
    private int perid;
    private String pernombre;
    private String perestatus;

    public clsPerfil() {
    }

    public clsPerfil(int perid) {
        this.perid = perid;
    }
    
    public clsPerfil(String pernombre, String perestatus) {
        this.pernombre = pernombre;
        this.perestatus = perestatus;
    }
    
    public clsPerfil(int perid, String pernombre, String perestatus) {
        this.perid = perid;
        this.pernombre = pernombre;
        this.perestatus = perestatus;
    }
    

    public int getId_perfil() {
        return perid;
    }

    public void setId_perfil(int iid) {
        this.perid = iid;
    }


    public void setnombreperfil(String snombre) {
        this.pernombre = snombre;
    }

    public String getnombreperfil() {
        return pernombre;
    }

    public void setEstado(String sestado) {
        this.perestatus = sestado;
    }
    
    public String getEstado() {
        return perestatus;
    }

    @Override
    public String toString() {
        return "tbl_perfil{" + "perid=" + perid + ", pernombre=" + pernombre + ", perestatus=" + perestatus + '}';
    }
    
    
}
