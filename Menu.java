package PracticaFinal;
import java.util.Scanner;

public class Menu {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bandera =true;
        int opt=0;



        System.out.println("----Bienvenido a la universidad ****-----");
        System.out.println("Sistema de gestion de equipos");


           while (bandera) {
        try {
            System.out.println("1. Estudiante de Ingenieria");
            System.out.println("2. Estudiante de diseño");
            System.out.println("3. Salir del sistema");
            opt= sc.nextInt();
            if (opt < 1 || opt > 3) {
                System.out.println("Por favor, ingrese un valor valido\n");
                
            }
                switch (opt) {
                    case 1:
                    System.out.println("Menu ingenieros");
                        //Menu para estudiantes de ingenieria
                        break;
                    case 2:
                    System.out.println("Menu diseño");
                        //Menu para estudiantes de diseño
                        break;
                    case 3:
                    System.out.println("Cerrando sesion");
                    bandera = false;
                    break;
                
                    default:
                        break;
                }

        } catch (Exception e) {
            System.out.println("Invalido, intente de nuevo\n");
            sc.nextLine();
            
        }
                
            }

        
    }
}