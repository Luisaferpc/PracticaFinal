import java.util.Scanner;

class EstudianteIngenieria extends Estudiante {
    private int numeroSemestre;
    private float promedioAcumulado;
    private String serialEquipo;

    public EstudianteIngenieria(String cedula, String nombre, String apellido, String telefono, int numeroSemestre, float promedioAcumulado) {
        super(cedula, nombre, apellido, telefono);
        this.numeroSemestre = numeroSemestre;
        this.promedioAcumulado = promedioAcumulado;
        this.serialEquipo = null; 
    }

    public int getNumeroSemestre() {
        return numeroSemestre;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public float getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(float promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public String getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(String serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public void modificarPrestamo(String serialEquipo) {
        setSerialEquipo(serialEquipo);
    }

    public static void menuEstudiantesIngenieria(ServicioPrestamo servicioPrestamo) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nGESTIÓN ESTUDIANTES DE INGENIERIA");
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
                        servicioPrestamo.registrarPrestamoIngenieria();
                        break;
                    case 2:
                        System.out.print("Ingrese la cédula del estudiante o el serial del equipo a modificar: ");
                        String identificadorModificarIng = scanner.nextLine();
                        servicioPrestamo.modificarPrestamoIngenieria(identificadorModificarIng);
                        break;
                    case 3:
                        System.out.print("Ingrese la cédula del estudiante o el serial del equipo a devolver: ");
                        String identificadorDevolverIng = scanner.nextLine();
                        servicioPrestamo.devolverEquipoIngenieria(identificadorDevolverIng);
                        break;
                    case 4:
                        System.out.print("Ingrese la cédula del estudiante o el serial del equipo a buscar: ");
                        String identificadorBuscarIng = scanner.nextLine();
                        servicioPrestamo.buscarEquipoIngenieria(identificadorBuscarIng);
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