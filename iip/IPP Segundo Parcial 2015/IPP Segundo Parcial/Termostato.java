
/**
 * @author (Eloy Arana) 
 * @version (25/08/24)
 */
//Atributos Privados y publicos de la clase
public class Termostato {
    public static final int FRIO = 0, CALOR = 1, T_IDEAL_FRIO = 25, T_IDEAL_CALOR = 20;
    private String nombre;
    private int modo;
    private int tConfort;
    private double tActual;
    //Constructor General
    public Termostato(String n, int m, int tC, double tA){
        this.nombre = n;
        this.modo = m;
        this.tConfort = tC;
        this.tActual = tA;
    }
    // Constructor por Defecto
    public Termostato(){
        nombre = "zona de estar";
        modo = FRIO;
        tConfort = T_IDEAL_FRIO;
        tActual = generarAleatorio(20.0, 40.0); 
    }    
    //Crea un numero aleatoreo entre el rango de x e y
    private static double generarAleatorio(double x, double y){
        double numAlea = Math.random(); //Entre 0 y 1
        double rangoVal = x + numAlea * (y-x);
        return rangoVal;
    }
    public int getModo(){
        return modo;
    }
    public void setModo(int nuevoModo){
        modo = nuevoModo;
    }
    public boolean equals(Object o){
        if(!(o instanceof Termostato)){
            return false;
        }else{
            return this.nombre.equals(((Termostato)o).nombre)
            && this.modo.equals(((Termostato)o).modo)
            && this.tConfort.equals(((Termostato)o).tConfort)
            && this.tActual.equals(((Termostato)o)).tActual)
            && Math.abs(this.tActual - o.tActual) < 1;
        }
    }
    public String toString(){
        String tipmodo = "refrigeracion";
        if(this.modo == CALOR){
            tipmodo = "calefaccion";
        }else{
            return nombre + ", " + tipmodo + ", " + "TConfort = " + tConfort + " y TActual = " + tActual;
        }
    }//Devuelve 0 si la tConfort es adecuada al modo, es decir, si es >= modo FRIO o <= modo CALOR
    public int diferenciaConIdeal(){
        int tAux = 0;
        if(tConfort == FRIO){
            if(tConfort < T_IDEAL_FRIO){
                tAux = Math.abs(tConfort - T_IDEAL_FRIO);
            }else{
                if(tConfort > T_IDEAL_CALOR){
                    tAux = Math.abs(tConfort - T_IDEAL_CALOR);
                }return tAux;
            }
        }
    }
}
