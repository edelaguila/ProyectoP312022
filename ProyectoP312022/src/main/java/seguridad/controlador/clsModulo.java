package seguridad.controlador;

public class clsModulo {
    private int piId_modulo;
    private String psCodigo;
    private String psNombre;
    private String psStatus;

    public clsModulo() {
    }

    public clsModulo(int piId_modulo) {
        this.piId_modulo = piId_modulo;
    }
    
    public clsModulo(String psCodigo, String psNombre,String psStatus ) {
        this.psCodigo = psCodigo;
        this.psNombre = psNombre;
        this.psNombre = psStatus;
    }
    
    public clsModulo(int piId_modulo, String psCodigo, String psNombre,String psStatus) {
        this.piId_modulo = piId_modulo;
        this.psCodigo = psCodigo;
        this.psNombre = psNombre;
        this.psStatus = psStatus;
    }
    

    public int fGetid_modulo() {
        return piId_modulo;
    }

    public void fSetid_modulo(int piId_modulo) {
        this.piId_modulo = piId_modulo;
    }

    public String fGetcodigo() {
        return psCodigo;
    }

    public void fSetcodigo(String psCodigo) {
        this.psCodigo = psCodigo;
    }

    public String fGetnombre() {
        return psNombre;
    }

    public void fSetnombre(String psNombre) {
        this.psNombre = psNombre;
    }

 public String fGetstatus() {
        return psStatus;
    }

    public void fSetestatus(String psStatus) {
        this.psStatus = psStatus;
    }


    @Override
    public String toString() {
        return "clsModulo{" + "piId_modulo=" + piId_modulo + ", psCodigo=" + psCodigo + ", psNombre=" + psNombre + ", psStatus=" + psStatus + '}';
    }
   
}
