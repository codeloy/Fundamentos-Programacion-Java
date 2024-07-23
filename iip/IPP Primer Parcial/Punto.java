
/**
 * Write a description of class Punto here.
 * 
 * @author (Eloy) 
 * @version (23/07/24)
 */
public class Punto
{
    // instance variables - replace the example below with your own
    private double x = 0.0;
    private double y = 0.0 ;
    private static final double EPSILON = 1e-10;

    public Punto(double abs, double ord){
        this.x = abs;
        this.y = ord;
    }
    
    public double distancia(Punto p){
        double abs = this.x - p.x;
        double ord = this.y - p.y;
        double dist = Math.sqrt(abs * abs + ord * ord);
        return Math.round(dist * 10000)/10000.0;
    }
    
    public boolean equals(Object o){
        
        //return false;
        if (!(o instanceof Punto)) { //Paso 1
            return false;
        } else {
            //Paso 2
            Punto aux = (Punto) o;

            //Paso 3;
            return Math.abs(this.x - aux.x) < EPSILON
            && Math.abs(this.y - aux.y) < EPSILON;
        }
    }
    
    public String toString() {
        return "";
    }
}
