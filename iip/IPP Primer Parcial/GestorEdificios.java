
/**
 * 1 Parcial 
 * Eloy Arana 23-08-2024
 */
public class GestorEdificios{
    
     
     // codigo, entidad, tipo, coordenadas
   public static void main(String[]args){
       Punto coordenadas = new Punto(39.4826, -0.3470);
       Edificio e1 = new Edificio("1G", "ETSINF", Edificio.ESCUELA, coordenadas);
       
       //Contructor por defecto e2
       Edificio e2 = new Edificio();
           
       int distEdificios = e1.masCercaRectorado(e2);
           String res = "El edificio mas cercano de rectorado es ";
           if(distEdificios == -1){
                res += e1.toString();
            }
            else if(distEdificios == 1){
                res += e2.toString();
            }
           else{
                res = "Ambos edificios estan a igual distancia de rectorado";
            }
       System.out.println(res);
    }
    

}
