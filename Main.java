import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioPrestamo servicioPrestamo = new ServicioPrestamo(scanner);
        int opcionPrincipal;

        do {
            System.out.println("\nGESTIÓN PRÉSTAMO EQUIPOS ELECTRÓNICOS SAN JUAN DE DIOS");
            System.out.println("1. ESTUDIANTES DE INGENIERIA");
            System.out.println("2. ESTUDIANTES DE DISEÑO");
            System.out.println("3. IMPRIMIR INVENTARIO TOTAL");
            System.out.println("4. SALIR DEL PROGRAMA");
            System.out.print("Seleccione una opción: ");
            try {
                opcionPrincipal = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcionPrincipal) {
                    case 1:
                        EstudianteIngenieria.menuEstudiantesIngenieria(servicioPrestamo);
                        break;
                    case 2:
                        EstudianteDiseno.menuEstudiantesDiseno(servicioPrestamo);
                        break;
                    case 3:
                        servicioPrestamo.imprimirInventarioTotal();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); 
                opcionPrincipal = -1;
            }
        } while (opcionPrincipal != 4);
        scanner.close();
    }
}