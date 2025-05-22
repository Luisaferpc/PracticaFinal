import java.util.InputMismatchException;
import java.util.Scanner;

class ComputadorPortatil extends EquipoElectronico {
    private String sistemaOperativo;
    private String procesador;

    public ComputadorPortatil(String serial, String marca, float tamano, float precio, String sistemaOperativo, String procesador) {
        super(serial, marca, tamano, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public static String seleccionarSistemaOperativo(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Seleccione el sistema operativo:");
            System.out.println("1. Windows 7");
            System.out.println("2. Windows 10");
            System.out.println("3. Windows 11");
            System.out.print("Ingrese su opción: ");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); 
                opcion = -1;
            }
        } while (opcion < 1 || opcion > 3);

        switch (opcion) {
            case 1:
                return "Windows 7";
            case 2:
                return "Windows 10";
            case 3:
                return "Windows 11";
            default:
                return ""; 
        }
    }

    public static String seleccionarProcesador(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Seleccione el procesador:");
            System.out.println("1. AMD Ryzen");
            System.out.println("2. Intel® Core™ i5");
            System.out.print("Ingrese su opción: ");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); 
                opcion = -1; 
            }
        } while (opcion < 1 || opcion > 2);

        switch (opcion) {
            case 1:
                return "AMD Ryzen";
            case 2:
                return "Intel® Core™ i5";
            default:
                return ""; 
        }
    }
}