//import iipUtil.Instante;
/**
 *  Clase Entrada. 
 *  Practica 5 - IIP - ETSINF-UPV.
 *  
 *  @author
 *  @version Curso 2016/17
 */
public class Entrada {
    // Definicion de constantes para el calculo del precio de la entrada:
    // Precio Base a partir del cual se calcula el precio final
    public static final double PRECIO_BASE = 7.60;
    // Descuento por espectador mayor de 65 anyos (SENIOR)    
    public static final int SENIOR = 65;
    public static final double DTO_SENIOR = 0.3;

    // Descuento por ser el dia del espectador        
    public static final double DTO_DIA_ESPECTADOR = 0.8;

    // Descuento por ser festivo
    //   /* A COMPLETAR */    
    public static final double ATO_FESTIVO = 1.2;// Aumento Festivo
    // Descuento por ser vispera de festivo
    //   /* A COMPLETAR */
    public static final double ATO_VIS_FESTIVO = 1.1;// Aumento Vispera Festivo
    // Descuento por ser cliente
    //   /* A COMPLETAR */
    public static final double DTO_TJT_CLIENTE = 0.8;

    //   // Definicion de ATRIBUTOS de INSTANCIA PRIVADOS
    //   /* A COMPLETAR */
    private String titulo;
    private String cine;
    private Instante horaSesion;
    //private int hora;
    //private int minutos;
    /** Crea una Entrada con titulo t, cine c, horas hs,
     *  y minutos ms de la sesion.
     */
    public Entrada(String t, String c, int hs, int ms) {
        /* A COMPLETAR */
        this.titulo = t;
        this.cine = c;
        this.horaSesion = new Instante(hs, ms);

    }

    public Entrada(){
        this.titulo = "";
        this.cine = "";
        this.horaSesion = new Instante();
        //this.hs = 0;
        //this.ms = 0;
    }

    /** Devuelve el <b>titulo</b> de la pelicula de la Entrada. */
    public String getTitulo() { return titulo; }

    /** Devuelve el <b>cine</b> de la entrada. */
    public String getCine() { return cine;/* A COMPLETAR */ }

    /** Devuelve la <b>hora de la sesion</b> de la Entrada. */
    public Instante getHoraSesion() { return horaSesion; }

    /** Actualiza a <b>t</b> el titulo de la pelicula de la Entrada. */
    public void setTitulo(String t) { titulo = t; }

    /** Actualiza a <b>c</b> el cine de la Entrada. */
    public void setCine(String c) { cine = c;/* A COMPLETAR */ }

    /** Actualiza a <b>hs</b> la hora de la sesion de la Entrada. */
    public void setHoraSesion(Instante hs) { horaSesion = hs; }

    /** Devuelve un String con los datos de la Entrada.
     * El formato de la salida sigue el siguente ejemplo: 
     *   "Anochece en La India", proyectada en Cines Babel, a las 22:30
     *   Precio base: 7.60 euros
     */
    public String toString() {
        return "\"" + titulo + "\", proyectada en " + cine + ", a las " 
        + horaSesion + "\nPrecio base: " + PRECIO_BASE + " euros";
    }

    /** Comprueba si o es una Entrada con los mismos datos 
     *  que la Entrada actual. */
    // public boolean equals(Object o) {
    // /* A COMPLETAR */
    // return o instanceof Entrada 
    // && this.titulo.equals(((Entrada) o).titulo)
    // && this.cine == ((Entrada) o).cine
    // && this.horaSesion.equals(((Entrada) o).horaSesion);
    // // Falta por comparar this.horaSesion con horaSesion de o

    // }
    public boolean equals(Object o){

        if (!(o instanceof Entrada)) { //Paso 1
            return false;
        } else {
            //Paso 2
            Entrada aux = (Entrada) o;

            //Paso 3;
            return this.titulo.equals(aux.titulo)
            && this.cine.equals(aux.cine)
            && this.horaSesion.equals(aux.horaSesion);
        }

    }

    /** 
     *  Calcula el precio final de la Entrada aplicando al precio base  
     *  los descuentos segun la edad del espectador, el dia de la sesion 
     *  (espectador, festivo o vispera) y si tiene tarjeta de cliente o no
     */
    public double precioFinal(int edad, boolean diaEspec, boolean festivo, 
    boolean visp, boolean tCliente) {
        /* A COMPLETAR */  
        double precioEntrada = PRECIO_BASE;

        if(edad >= SENIOR){
            precioEntrada = PRECIO_BASE * DTO_SENIOR;
        } else if (diaEspec == true){
            precioEntrada = PRECIO_BASE * DTO_DIA_ESPECTADOR;
        } else {            
            if (festivo == true) {
                precioEntrada = PRECIO_BASE * ATO_FESTIVO;
            }else if (visp == true) {
                precioEntrada = PRECIO_BASE * ATO_VIS_FESTIVO;
            } else {
                precioEntrada = PRECIO_BASE;
            }
            
            if (tCliente == true){
                precioEntrada = precioEntrada * DTO_TJT_CLIENTE;
            }
            else{
                precioEntrada = PRECIO_BASE;
            }
        }
        
        
        return precioEntrada;
    }

}
