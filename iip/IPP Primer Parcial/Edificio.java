/**
 * 
 * @author (Eloy Arana) 
 * @version (23/08/24)
 */
public class Edificio{
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
            // Edificio edificioAux = (Edificio) otro;
            return this.codigo.equals(((Edificio)otro).codigo)// Es edificioAux u otro?
            && this.coordenadas.equals(((Edificio)otro).coordenadas);
        }
    }
    public String toString(){
        //Inicializo la String que voy a devolver
        String res = "Edificio ";
        
        //Dependiendo del tipo, concateno la representacion textual
        switch (this.tipo) {
            case DEPARTAMENTO:
                res += "departamental ";
                break;
            case ESCUELA:
                res += "docente ";
                break;
            case SERVICIOS:
                res += "de servicios ";
                break;
        }
        
        // if(tipo == 0) {
            // res += "departamental ";
        // } else if(tipo == ESCUELA) {
            // res += "docente ";
        // } else if(tipo == SERVICIOS) {
            // res += "de servicios ";
        // }
        
        //Termino de montar la string poniendo el codigo, la entidad y las coordenadas (uso metodo toString
        //de la clase Punto)
        res += this.codigo +" ("+ this.entidad +"), GPS:" + this.coordenadas.toString();
        return res;
    }
    
    // e1.masCercaRectorado(e2)
    public int masCercaRectorado(Edificio e){
        
        //Crear un objeto de la clase Punto con las coordenadas del rectorado
        Punto rectorado = new Punto(39.4823, -0.3457);
        
        //Calcular las distancias de this y e con respecto al rectorado
        double distanciaThis = rectorado.distancia(this.coordenadas);
        double distanciaE = rectorado.distancia(e.coordenadas);
        
        
        //Caso 1: la distancia this es menor que la de e
        if(distanciaThis < distanciaE) {
            return -1;
        }

        //Caso 2: la distancia this es mayor que la de e
        else if(distanciaThis > distanciaE) {
            return 1;
        }
        
        //Caso 3: la distancia de los dos edificios es igual
        else {
            // Servicio > docentes > departamento
            int aux = this.tipo - e.tipo;
            
            //Caso 3.1: El tipo de this es más cercano que el tipo de e
            if(aux > 0) {
                return -1;
            
            //Caso 3.2: El tipo de this es más lejano que el tipo de e
            } else if(aux < 0){
                return 1;
            
            //Caso 3.3: El tipo de los edificios coincide
            } else {
                return 0;
            }
            
            // if(this.tipo == SERVICIOS) {
                // if(e.tipo == SERVICIOS) {
                    // return 0;
                // } else if(e.tipo == ESCUELA) {
                    // return -1;
                // } else if(e.tipo == DEPARTAMENTO) {
                    // return -1;
                // }
            // }
            
            // if (this.tipo == ESCUELA) {
                // if(e.tipo == SERVICIOS) {
                    // return 1;
                // } else if(e.tipo == ESCUELA) {
                    // return 0;
                // } else if(e.tipo == DEPARTAMENTO) {
                    // return -1;
                // }
            // }
            
            // if (this.tipo == DEPARTAMENTO) {
                // if(e.tipo == SERVICIOS) {
                    // return 1;
                // } else if(e.tipo == ESCUELA) {
                    // return 1;
                // } else if(e.tipo == DEPARTAMENTO) {
                    // return 0;
                // }
            // }
            
            // switch (this.tipo) {
                // case SERVICIOS:
                    // switch(e.tipo) {
                        // case SERVICIOS: 
                            // return 0;
                        // case ESCUELA: 
                            // return -1;
                        // case DEPARTAMENTO:
                            // return -1;
                    // }
                    // break;
                // case ESCUELA:
                    // switch(e.tipo) {
                        // case SERVICIOS: 
                            // return 1;
                        // case ESCUELA: 
                            // return 0;
                        // case DEPARTAMENTO:
                            // return -1;
                    // }
                    // break;
                // case DEPARTAMENTO:
                    // switch(e.tipo) {
                        // case SERVICIOS: 
                            // return 1;
                        // case ESCUELA: 
                            // return 1;
                        // case DEPARTAMENTO:
                            // return 0;
                    // }
                    // break;
            // }
        }
        
    }
}
