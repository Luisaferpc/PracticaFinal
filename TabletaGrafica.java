import java.util.InputMismatchException;
import java.util.Scanner;

class TabletaGrafica extends EquipoElectronico {
    private String almacenamiento;
    private float peso;

    public TabletaGrafica(String serial, String marca, float tamano, float precio, String almacenamiento, float peso) {
        super(serial, marca, tamano, precio);
        this.almacenamiento = almacenamiento;
        this.peso = peso;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public static String seleccionarAlmacenamiento(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Seleccione el almacenamiento:");
            System.out.println("1. 256 GB");
            System.out.println("2. 512 GB");
            System.out.println("3. 1 TB");
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
                return "256 GB";
            case 2:
                return "512 GB";
            case 3:
                return "1 TB";
            default:
                return ""; 
        }
    }
}