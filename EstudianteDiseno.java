import java.util.Scanner;

class EstudianteDiseno extends Estudiante {
    private String modalidadEstudio;
    private int cantidadAsignaturas;
    private int serialEquipo;

    public EstudianteDiseno(String cedula, String nombre, String apellido, String telefono, String modalidadEstudio, int cantidadAsignaturas) {
        super(cedula, nombre, apellido, telefono);
        this.modalidadEstudio = modalidadEstudio;
        this.cantidadAsignaturas = cantidadAsignaturas;
        this.serialEquipo = 0;
    }

    public String getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
    }

    public int getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(int serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public void modificarPrestamo(int serialEquipo) {
        setSerialEquipo(serialEquipo);
    }


    public static void menuEstudiantesDiseno(ServicioPrestamo servicioPrestamo) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nGESTIÓN ESTUDIANTES DE DISEÑO");
            System.out.println("1. Registrar préstamo de equipo.");
            System.out.println("2. Modificar préstamo de equipo (Por serial o cedula).");
            System.out.println("3. Devolución de equipo (se elimina el registro) (Por serial o cedula).");
            System.out.println("4. Buscar equipo (Por serial o cedula).");
            System.out.println("5. Volver al menú principal.");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcion) {
                    case 1:
                        servicioPrestamo.registrarPrestamoDiseno();
                        break;
                    case 2:
                        System.out.print("Ingrese la cédula del estudiante o el serial del equipo a modificar: ");
                        String identificadorModificarDis = scanner.nextLine();
                        servicioPrestamo.modificarPrestamoDiseno(identificadorModificarDis);
                        break;
                    case 3:
                        System.out.print("Ingrese la cédula del estudiante o el serial del equipo a devolver: ");
                        String identificadorDevolverDis = scanner.nextLine();
                        servicioPrestamo.devolverEquipoDiseno(identificadorDevolverDis);
                        break;
                    case 4:
                        System.out.print("Ingrese la cédula del estudiante o el serial del equipo a buscar: ");
                        String identificadorBuscarDis = scanner.nextLine();
                        servicioPrestamo.buscarEquipoDiseno(identificadorBuscarDis);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); 
                opcion = -1;
            }
        } while (true);
    }
}