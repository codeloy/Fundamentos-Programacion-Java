/**
 * Write a description of class Edificio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Edificio
{
    public static final int DEPARTAMENTO = 0;
    public static final int ESCUELA = 1;
    public static final int SERVICIOS = 2;
    private String codigo;
    private String entidad;
    private int tipo;
    private Punto coordenadas;
    
    /**
     * Constructor for objects of class Edificio
     */
    public Edificio(String c,String e, int t, Punto p){
        this.codigo = c;
        this.entidad = e;
        this.tipo = t;
        this.coordenadas = p;
    }
    public Edificio(){
        this.tipo = DEPARTAMENTO;
        this.entidad = "DSIC";
        this.codigo = "1F";
        this.coordenadas = new Punto(39.4625,-0.3472);
    }
    public Punto getCoordenadas(){
        return this.coordenadas;
    }
    
    public void setCoordenadas(Punto nuevasCoordenadas){
        this.coordenadas = nuevasCoordenadas;
    }
    public boolean equals(Object otro){
        if(!(otro instanceof Edificio)){
            return false;
        } else{
            Edificio edificioAux = (Edificio) otro;
            
            return this.codigo.equals(((Edificio)edificioAux).codigo)// Es edificioAux u otro?
            && this.coordenadas.equals(((Edificio)edificioAux).coordenadas);
            }
    }
    public String toString(){
        String res = "Edificio ";
        switch (tipo) {
            case DEPARTAMENTO:
                res += "departamental ";
                break;
            case ESCUELA:
                res += "docente ";
                break;
            case SERVICIOS:
                res += "servicios ";
                break;
        }
        res += codigo +" ("+ entidad +"),GPS:" + coordenadas;
        return res;
    }
}
