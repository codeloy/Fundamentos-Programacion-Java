import java.util.Scanner;
import java.util.Locale;
public class ProgramaTri{
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        Punto p1 = new Punto();
        Punto p2 = new Punto();
        Punto p3 = new Punto();
        System.out.println("Introduzca el valor de X e Y: ");
        p1.setX(teclado.nextDouble());
        p1.setY(teclado.nextDouble());
        System.out.println("Introduzca el valor de X e Y: ");
        p2.setX(teclado.nextDouble());
        p2.setY(teclado.nextDouble());
        System.out.println("Introduzca el valor de X e Y: ");
        p3.setX(teclado.nextDouble());
        p3.setY(teclado.nextDouble()); //Esto es un comentario
        double lado1 = p1.distancia(p2);
        double lado2 = Punto.distancia(p2, p3); 
        double lado3 = Punto.distancia(p1, p3);
        
    }   
    
}
