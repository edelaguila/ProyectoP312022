package seguridad.controlador;

public class clsPerfilAplicaciones {

    private int perid;
    private int aplid;
    private String aplnombre;
    private int aplperR,aplperE,aplperM,aplperL,aplperB;
   

    public clsPerfilAplicaciones() {
    }

    public clsPerfilAplicaciones(int perid, int aplid, String aplnombre, int aplperR, int aplperE, int aplperM, int aplperL, int aplperB) {
        this.perid = perid;
        this.aplid = aplid;
        this.aplnombre = aplnombre;
        this.aplperR = aplperR;
        this.aplperE = aplperE;
        this.aplperM = aplperM;
        this.aplperL = aplperL;
        this.aplperB = aplperB;
    }

 
   

   

   

   
    
    public int getPerid() {
        return perid;
    }

    public void setPerid(int perid) {
        this.perid = perid;
    }

    public int getAplid() {
        return aplid;
    }

    public void setAplid(int aplid) {
        this.aplid = aplid;
    }

    public String getAplnombre() {
        return aplnombre;
    }

    public void setAplnombre(String aplnombre) {
        this.aplnombre = aplnombre;
    }

    public int getAplperR() {
        return aplperR;
    }

    public void setAplperR(int aplperR) {
        this.aplperR = aplperR;
    }

    public int getAplperE() {
        return aplperE;
    }

    public void setAplperE(int aplperE) {
        this.aplperE = aplperE;
    }

    public int getAplperM() {
        return aplperM;
    }

    public void setAplperM(int aplperM) {
        this.aplperM = aplperM;
    }

    public int getAplperL() {
        return aplperL;
    }

    public void setAplperL(int aplperL) {
        this.aplperL = aplperL;
    }

    public int getAplperB() {
        return aplperB;
    }

    public void setAplperB(int aplperB) {
        this.aplperB = aplperB;
    }

   


  

    @Override
    public String toString() {
        return "clsPerfilAplicaciones{" + "perid=" + perid + ", aplid=" + aplid + ", aplnombre=" + aplnombre + ", aplperR=" + aplperR + ", aplperE=" + aplperE + ", aplperM=" + aplperM + ", aplperL=" + aplperL + ", aplperB=" + aplperB + '}';
    }

  
    

    
    
    


 

    

   
 
    
}