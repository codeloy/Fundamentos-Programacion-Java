package iipUtil;

 
/**
 * <p>
 * Esta clase permite representar instantes o marcas de tiempo
 * (<code>Timestamp</code>) con detalle de minutos. Así, esta 
 * clase representa el momento o instante que define una hora,
 * en este caso, las horas y los minutos de la misma.
 * </p>
 * 
 *  @author IIP 
 *  @version Curso 2016-17
 */
public class Instante {

    // ATRIBUTOS:
    /** Variable entera para almacenar el atributo horas. 
     *  Debe pertenecer al rango <code>[0,23]</code>. */
        private int horas;

    /** Variable entera para almacenar el atributo minutos. 
     *  Debe pertenecer al rango <code>[0,59]</code>. */
         private int minutos;
     
    /** long Instante = System.currentTimeMillis() / (60 * 1000);
    int tMinAct = (int) (Instante % (24 * 60));
    int h = tMinAct / 60+2;
    int m = tMinAct % 60;
    //System.out.println();*/
    
    // CONSTRUCTORES:
    /**
     *  Crea un <code>Instante</code> con el valor de
     *  las horas y los minutos que recibe como argumentos,
     *  <code>h</code> y <code>m</code> respectivamente.
     *
     *  <p> Debe cumplirse la precondición: 
      // <code>0 <= h < 24, 0 <= m < 60</code>. </p> */
    
        public Instante(int h, int m){
            horas = h;
            minutos = m;
    }
    
    /**
     * Crea un <code>Instante</code> con el valor del instante
     * actual UTC (tiempo universal coordinado).
     */
        public Instante(){
        long time = System.currentTimeMillis() / (60 * 1000);
        int minActual = (int) time % (24 * 60);
        horas = darH(minActual) ;
        minutos = darM(minActual);
    }
    private int darH(int minutos){
        return minutos / 60; 
    }
    private int darM(int minutos){
        return minutos % 60; 
    }    
    
    // CONSULTORES Y MODIFICADORES:
    /** Devuelve las <code>horas</code> del Instante. */
    public int getHoras(){
        return horas;
    }

    /** Devuelve los <code>minutos</code> del Instante. */
    public int getMinutos(){
        return minutos;
    }
   
    /** Actualiza las <code>horas</code> del Instante. */ 
    public void setHoras(int horas){
        this.horas = horas;
    }
   
    /** Actualiza los <code>minutos</code> del Instante. */ 
    public void setMinutos(int minutos){
        this.minutos = minutos;
    }
    // OTROS MÉTODOS:
    /** Devuelve el Instante en el formato "<code>hh:mm</code>". */
    public String toString(){
        String h = "0" + horas;
        int n = h.length();
        String hh = h.substring(n -2);
        String m = "0" + minutos;
        int n1 = m.length();
        String mm = m.substring(n1 -2);
        return hh + ":" + mm ;
    }
   
    /** Devuelve <code>true</code> sii <code>o</code> es 
     *  un objeto de la clase <code>Instante</code>
     *  y sus <code>horas</code> y <code>minutos</code>
     *  coinciden con los del objeto en curso. 
     */
      public boolean equals(Object o){
        return o instanceof Instante && this.horas == ((Instante)o).horas && this.minutos == ((Instante)o).minutos; 
        }
      
    /** Devuelve el número de minutos transcurridos desde las 00:00 
     *  hasta el instante representado por el objeto en curso.
     */
    public int aMinutos(){
        return horas * 60 + minutos;
    }
    
   
    /** Compara cronologicamente el instante del objeto en curso
     *  con el del objeto de la clase <code>Instante</code> referenciado
     *  por <code>otro</code>.
     *
     *  <p>
     *  El resultado es un valor:
     *  <ul>
     *     <li> negativo si el instante del objeto en curso 
     *     es anterior al de <code>otro</code>, </li>
     *     <li> cero si son iguales, </li>
     *     <li> positivo si el Instante del objeto en curso 
     *     es posterior al de <code>otro</code>. </li>
     *  </ul>
     *  </p>
     */
     public int compareTo(Instante otro){
        return this.aMinutos() - otro.aMinutos();
    }

    // ACTIVIDAD EXTRA:
    /** Devuelve un <code>Instante</code> a partir de la descripción 
     *  textual (<code>String</code>) en formato "<code>hh:mm</code>".
     */
    
}
