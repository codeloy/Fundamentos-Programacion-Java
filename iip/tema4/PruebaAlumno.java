import java.util.Scanner;
import java.util.Locale;
public class PruebaAlumno{
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Asignatura " + AlumnoIIP.ASIGNATURA);
        System.out.println("Nombre y apellido del Alumno: ");
        AlumnoIIP alu = new AlumnoIIP(); 
        alu.nombre = teclado.nextLine();
        System.out.println("DNI: ");
        alu.DNI = teclado.nextLine();
        System.out.println("Nota ponderada parciales (en [0.0, 10.0]): ");
        alu.NPP = teclado.nextDouble();
        System.out.println("Nota laboratorio (en [0.0, 10.0]): ");
        alu.NPL = teclado.nextDouble();
        System.out.println("Nota de actividades de seguimiento (en [0.0, 10.0])");
        alu.NAS = teclado.nextDouble();
        double nota = (0.6*alu.NPP + 0.2*alu.NPL + 0.2*alu.NAS);
        nota = Math.round(nota * 10.0) / 10.0;
        System.out.println(alu.nombre + ": " + nota);

    }  
}
