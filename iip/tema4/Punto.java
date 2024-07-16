/** Clase Punto. 
 * 
 *  @author (IIP. ETSInf. UPV. Grupos D, I) 
 *  @version (Curso 2016/167)
 */
public class Punto {
    public static final int DIMENSION = 2;
    private double x;
    private double y;
   
    /** Crea un Punto con abscisa 0.0 y ordenada 0.0. */
    public Punto() { 
    }
        
   /** Crea un Punto con abscisa px y ordenada py. */
    public Punto(double px, double py) { this.x = px; this.y = py; }
  
    /** Devuelve la abscisa del Punto. */
    public double getX() { return this.x; }
    
    /** Devuelve la ordenada del Punto. */
    public double getY() { return this.y; }

    /** Cambia la abscisa del Punto a px. */
    public void setX(double px) { this.x = px; }
    
    /** Cambia la ordenada del Punto a py. */
    public void setY(double py) { this.y = py; }
       
    /** Cambia la abscisa del Punto a px, y la ordenada a py.*/
    public void mover(double px, double py) { 
        this.x = px; this.y = py; 
    }  
   
    /** Gira el punto el angulo alfa con respecto al origen */
    public void girar(double alfa) { 
        double xAux = this.x;
        double seno = Math.sin(alfa),
        coseno = Math.cos(alfa);
        this.x = xAux * coseno - this.y * seno;
        this.y = xAux * seno + this.y * coseno;
    }

    /** Devuelve la distancia del Punto al origen (0.0,0.0). */
    public double distOrigen() { 
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }    
   
    /** Devuelve la distancia entre el Punto this y p. */
    public double distancia(Punto p) { 
        double x = p.x - this.x; double y = p.y - this.y; 
        return Math.sqrt(x * x + y * y); 
    }
    
    public static double distancia(Punto p1, Punto p2) {
        double dx = p1.x - p2.x; double dy = p1.y - p2.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    
    /** Devuelve true sii o es un Punto cuyas 
     *  coordenadas coinciden con las del Punto.
     */
    public boolean equals(Object o) {
        return o instanceof Punto 
               && this.x == ((Punto) o).x
               && this.y == ((Punto) o).y;
    }    
  
    /** Devuelve la informacion del Punto 
     *  en el formato "(x,y)". 
     */
    public String toString() {
         return "(" + this.x + "," + this.y + ")";
    }
    
    /** Devuelve la abscisa correpondiente a unas coordenadas polares
     *  distancia y alfa.
     */
    public static double absDePolares(double distancia, double alfa) {
        return distancia * Math.cos(alfa); 
    }
 
    /** Devuelve la ordenada correspondiente a unas coordenadas polares
     *  distancia y alfa.
     */
    public static double ordDePolares(double distancia, double alfa) {
        return distancia * Math.sin(alfa);
    }
           
    /** Devuelve un Punto cuyas coordenadas polares
     *  son distancia y alfa.
     */
    public static Punto polaresAPunto(double distancia, double alfa) { 
        Punto p = new Punto();
        p.x = Punto.absDePolares(distancia, alfa);
        p.y = Punto.ordDePolares(distancia, alfa);
        return p;
    }

}


