import java.util.Locale;
import java.util.Scanner;
/** Clase VentaEntradas.
 *  Practica 5 - IIP - ETSINF-UPV.
 *  
 *  @author
 *  @version Curso 2016/17
 */
public class VentaEntradas {

    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);

        // Lectura de los datos de la entrada
        System.out.println("Caracteristicas de la entrada: ");
        System.out.print("   Titulo: ");
        String titulo = teclado.nextLine();
        System.out.print(" Cine ");
        String cine = teclado.nextLine();
        /* A COMPLETAR: Lectura del RESTO de datos de la Entrada */
        System.out.print(" Hora inicio ");
        int hora = teclado.nextInt();
        System.out.print(" Minutos inicio ");
        int minutos = teclado.nextInt();
        

        // Creacion de la Entrada
        Entrada e = new Entrada(titulo, cine, hora, minutos);/* A COMPLETAR */  

        // Lectura de los datos para aplicar descuentos
        // variables a utilizar inicializadas por defecto a false:
        /* A COMPLETAR: Lectura de RESTO de datos para aplicar DESCUENTOS */
        
        boolean bDiaEspec = false;
        boolean vispera = false; 
        boolean tCliente = false;
        boolean dSenior = false;
        boolean festivo = false;// Este lo agregue yo

        System.out.print("Edad? ");
        int edad = teclado.nextInt(); teclado.nextLine();
        
        if(edad < 0 || edad > 110){
            System.out.println("Edad no valida");
        } else if (edad >= 65) {    
            dSenior = true;
        }

        if( !dSenior ) {
            System.out.print("Es el dia del espectador? (SI/NO) "); 
            String res = teclado.next().toUpperCase(); 
            if (res.equals("SI")) { bDiaEspec = true; }
            
            
            if( !bDiaEspec ) {
                System.out.print("Es festivo? (SI/NO) "); 
                String fes = teclado.next().toUpperCase(); 
                if (fes.equals("SI")) { 
                    festivo = true; 
                } else { // Agregue este else para festivo o vispera
                    System.out.print("Es vispera? (SI/NO) "); 
                    String vis = teclado.next().toUpperCase(); 
                    if (vis.equals("SI")) { vispera = true; }
                }
                System.out.print("Tiene tarjeta cliente? (SI/NO) "); 
                String tCl = teclado.next().toUpperCase(); 
                if (tCl.equals("SI")) { tCliente = true; }
        
            }
            
        } 
        

  

        // Calculo del precio final de la Entrada e, 
        // invocando al metodo precioFinal
        //double precioFinal= e.precioFinal(edad,bDiaEspec,festivo,vispera,tCliente);
            
        double pFin = e.precioFinal(edad,bDiaEspec,festivo,vispera,tCliente);/* A COMPLETAR */ 

        // Mostrar por pantalla el precio final
            System.out.println("El precio final para la entrada es: " 
                + String.format("%.2f", pFin) + " euros");
    }
}