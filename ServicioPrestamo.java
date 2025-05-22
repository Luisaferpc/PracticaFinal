import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ServicioPrestamo {
        private List<EstudianteIngenieria> estudiantesIngenieria = new ArrayList<>();
        private List<EstudianteDiseno> estudiantesDiseno = new ArrayList<>();
        private List<EquipoElectronico> portatiles = new ArrayList<>();
        private List<EquipoElectronico> tabletas = new ArrayList<>();
    private Scanner scanner;

    public ServicioPrestamo(Scanner scanner) {
        this.scanner = scanner;
        inicializarEquipos(); 
    }

    private void inicializarEquipos() {
        portatiles.add(new ComputadorPortatil("CP001", "HP", 14.0f, 1200.0f, "Windows 10", "Intel® Core™ i5"));
        portatiles.add(new ComputadorPortatil("CP002", "Dell", 15.6f, 1500.0f, "Windows 11", "AMD Ryzen"));
        tabletas.add(new TabletaGrafica("TB001", "Wacom", 13.3f, 800.0f, "256 GB", 0.7f));
        tabletas.add(new TabletaGrafica("TB002", "Huion", 15.6f, 500.0f, "512 GB", 1.0f));
    }

    
    private Estudiante buscarEstudiante(String cedula, List<? extends Estudiante> listaEstudiantes) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    private EstudianteIngenieria buscarEstudianteIngenieriaPorIdentificador(String identificador) {
        for (EstudianteIngenieria estudiante : estudiantesIngenieria) {
            if (estudiante.getCedula().equals(identificador) || (estudiante.getSerialEquipo() != null && estudiante.getSerialEquipo().equals(identificador))) {
                return estudiante;
            }
        }
        return null;
    }

    private EstudianteDiseno buscarEstudianteDisenoPorIdentificador(String identificador) {
        for (EstudianteDiseno estudiante : estudiantesDiseno) {
            if (estudiante.getCedula().equals(identificador) || (estudiante.getSerialEquipo() != 0 && String.valueOf(estudiante.getSerialEquipo()).equals(identificador))) {
                return estudiante;
            }
        }
        return null;
    }

    
    public void registrarPrestamoIngenieria() {
        System.out.println("\nREGISTRAR PRÉSTAMO PARA ESTUDIANTE DE INGENIERIA");
        System.out.print("Ingrese la cédula del estudiante: ");
        String cedula = scanner.nextLine();

        if (buscarEstudiante(cedula, estudiantesIngenieria) != null && ((EstudianteIngenieria) buscarEstudiante(cedula, estudiantesIngenieria)).getSerialEquipo() != null) {
            System.out.println("El estudiante con cédula " + cedula + " ya tiene un computador portátil asignado.");
            return;
        }

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el teléfono del estudiante: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el número de semestre actual: ");
        int numeroSemestre = scanner.nextInt();
        System.out.print("Ingrese el promedio acumulado: ");
        float promedioAcumulado = scanner.nextFloat();
        scanner.nextLine();
        
        EstudianteIngenieria nuevoEstudiante = new EstudianteIngenieria(cedula, nombre, apellido, telefono, numeroSemestre, promedioAcumulado);
        estudiantesIngenieria.add(nuevoEstudiante);

        if (portatiles.isEmpty()) {
            System.out.println("No hay computadores portátiles disponibles para prestar.");
            return;
        }

        System.out.println("\nCOMPUTADORES PORTATILES DISPONIBLES:");
        for (int i = 0; i < portatiles.size(); i++) {
            System.out.println((i + 1) + ". Serial: " + portatiles.get(i).getSerial() + ", Marca: " + portatiles.get(i).getMarca());
        }

        int opcionPortatil = obtenerOpcion(1, portatiles.size(), "Seleccione el numero del computador portátil a prestar");
        if (opcionPortatil > 0) {
            EquipoElectronico equipoAsignado = portatiles.remove(opcionPortatil - 1);
            nuevoEstudiante.setSerialEquipo(equipoAsignado.getSerial());
            System.out.println("Prestamo registrado exitosamente para el estudiante " + nombre + " " + apellido +
                               " con el computador portatil serial: " + nuevoEstudiante.getSerialEquipo());
        }
    }

    public void registrarPrestamoDiseno() {
        System.out.println("\nREGISTRAR PRESTAMO PARA ESTUDIANTE DE DISEÑO");
        System.out.print("Ingrese la cedula del estudiante: ");
        
        //Se usa la expresion regular ("^[a-zA-Z0-9]+$"), para que  
        //permite solo letras (mayúsculas y minúsculas) y  números, sin espacios ni símbolos especiales.
        
        String cedula = validarCadena(scanner.nextLine(), "^[a-zA-Z0-9]+$", "La cedula no puede contener caracteres especiales.");

        if (buscarEstudiante(cedula, estudiantesDiseno) != null && ((EstudianteDiseno) buscarEstudiante(cedula, estudiantesDiseno)).getSerialEquipo() != 0) {
            System.out.println("El estudiante con cédula " + cedula + " ya tiene una tableta digital asignada.");
            return;
        }

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = validarCadena(scanner.nextLine(), "^[a-zA-Z\\s]+$", "El nombre no puede contener numeros ni caracteres especiales.");
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = validarCadena(scanner.nextLine(), "^[a-zA-Z\\s]+$", "El apellido no puede contener numeros ni caracteres especiales.");
        System.out.print("Ingrese el teléfono del estudiante: ");
        String telefono = validarCadena(scanner.nextLine(), "^[0-9]+$", "El telefono no puede contener caracteres especiales.");
        System.out.print("Ingrese la modalidad de estudio (virtual/presencial): ");
        String modalidadEstudio = scanner.nextLine();
        System.out.print("Ingrese la cantidad de asignaturas que esta viendo: ");
        int cantidadAsignaturas = scanner.nextInt();
        scanner.nextLine();

        EstudianteDiseno nuevoEstudiante = new EstudianteDiseno(cedula, nombre, apellido, telefono, modalidadEstudio, cantidadAsignaturas);
        estudiantesDiseno.add(nuevoEstudiante);

        if (tabletas.isEmpty()) {
            System.out.println("No hay tabletas digitales disponibles para prestar.");
            return;
        }

        System.out.println("\nTABLETAS DIGITALES DISPONIBLES:");
        for (int i = 0; i < tabletas.size(); i++) {
            System.out.println((i + 1) + ". Serial: " + tabletas.get(i).getSerial() + ", Marca: " + tabletas.get(i).getMarca());
        }

        int opcionTableta = obtenerOpcion(1, tabletas.size(), "Seleccione el número de la tableta digital a prestar");
        if (opcionTableta > 0) {
            EquipoElectronico equipoAsignado = tabletas.remove(opcionTableta - 1);
            nuevoEstudiante.setSerialEquipo(Integer.parseInt(equipoAsignado.getSerial()));
            System.out.println("Préstamo registrado exitosamente para el estudiante " + nombre + " " + apellido +
                               " con la tableta digital serial: " + nuevoEstudiante.getSerialEquipo());
        }
    }

   
    public void modificarPrestamoIngenieria(String identificador) {
        validarCadena(identificador, "^[a-zA-Z0-9]+$", "El identificador no puede contener caracteres especiales.");
        EstudianteIngenieria estudiante = buscarEstudianteIngenieriaPorIdentificador(identificador);
        if (estudiante == null) {
            System.out.println("No se encontró ningún préstamo registrado con la cédula o serial proporcionado.");
            return;
        }

        System.out.println("Información actual del préstamo:");
        System.out.println("Cédula del estudiante: " + estudiante.getCedula());
        System.out.println("Nombre del estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Serial del equipo prestado: " + estudiante.getSerialEquipo());

       
        if (estudiante.getSerialEquipo() != null) {
            portatiles.add(new ComputadorPortatil(estudiante.getSerialEquipo(), "Desconocida", 0.0f, 0.0f, "Desconocido", "Desconocido"));
        }

        System.out.println("\nNuevos computadores portátiles disponibles:");
        for (int i = 0; i < portatiles.size(); i++) {
            System.out.println((i + 1) + ". Serial: " + portatiles.get(i).getSerial() + ", Marca: " + portatiles.get(i).getMarca());
        }
        System.out.println((portatiles.size() + 1) + ". Dejar sin equipo asignado.");

        int opcionNuevoPortatil = obtenerOpcion(1, portatiles.size() + 1, "Seleccione el número del nuevo computador portátil a asignar (o " + (portatiles.size() + 1) + " para quitar el equipo)");
        if (opcionNuevoPortatil > 0 && opcionNuevoPortatil <= portatiles.size()) {
            EquipoElectronico nuevoEquipo = portatiles.remove(opcionNuevoPortatil - 1);
            estudiante.setSerialEquipo(nuevoEquipo.getSerial());
            System.out.println("Préstamo modificado exitosamente. Nuevo serial asignado: " + estudiante.getSerialEquipo());
        } else if (opcionNuevoPortatil == portatiles.size() + 1) {
            estudiante.setSerialEquipo(null);
            System.out.println("El préstamo del equipo ha sido removido para el estudiante.");
        }
    }

    public void modificarPrestamoDiseno(String identificador) {
        EstudianteDiseno estudiante = buscarEstudianteDisenoPorIdentificador(identificador);
        if (estudiante == null) {
            System.out.println("No se encontró ningún préstamo registrado con la cédula o serial proporcionado.");
            return;
        }

        System.out.println("Información actual del préstamo:");
        System.out.println("Cédula del estudiante: " + estudiante.getCedula());
        System.out.println("Nombre del estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Serial del equipo prestado: " + estudiante.getSerialEquipo());

        
        if (estudiante.getSerialEquipo() != 0) {
            tabletas.add(new TabletaGrafica(String.valueOf(estudiante.getSerialEquipo()), "Desconocida", 0.0f, 0.0f, "Desconocido", 0.0f));
        }

        System.out.println("\nNuevas tabletas digitales disponibles:");
        for (int i = 0; i < tabletas.size(); i++) {
            System.out.println((i + 1) + ". Serial: " + tabletas.get(i).getSerial() + ", Marca: " + tabletas.get(i).getMarca());
        }
        System.out.println((tabletas.size() + 1) + ". Dejar sin equipo asignado.");

        int opcionNuevaTableta = obtenerOpcion(1, tabletas.size() + 1, "Seleccione el número de la nueva tableta digital a asignar (o " + (tabletas.size() + 1) + " para quitar el equipo)");
        if (opcionNuevaTableta > 0 && opcionNuevaTableta <= tabletas.size()) {
            EquipoElectronico nuevoEquipo = tabletas.remove(opcionNuevaTableta - 1);
            estudiante.setSerialEquipo(Integer.parseInt(nuevoEquipo.getSerial()));
            System.out.println("Préstamo modificado exitosamente. Nuevo serial asignado: " + estudiante.getSerialEquipo());
        } else if (opcionNuevaTableta == tabletas.size() + 1) {
            estudiante.setSerialEquipo(0);
            System.out.println("El préstamo del equipo ha sido removido para el estudiante.");
        }
    }

    
    public void devolverEquipoIngenieria(String identificador) {
        EstudianteIngenieria estudiante = buscarEstudianteIngenieriaPorIdentificador(identificador);
        if (estudiante == null || estudiante.getSerialEquipo() == null) {
            System.out.println("No se encontró ningún préstamo registrado con la cédula o serial proporcionado.");
            return;
        }

        String serialDevuelto = estudiante.getSerialEquipo();
        System.out.println("Equipo con serial " + serialDevuelto + " devuelto por el estudiante " +
                           estudiante.getNombre() + " " + estudiante.getApellido() + ".");
        portatiles.add(new ComputadorPortatil(serialDevuelto, "Desconocida", 0.0f, 0.0f, "Desconocido", "Desconocido"));
        estudiantesIngenieria.remove(estudiante);
        System.out.println("Registro de préstamo eliminado.");
    }

    public void devolverEquipoDiseno(String identificador) {
        EstudianteDiseno estudiante = buscarEstudianteDisenoPorIdentificador(identificador);
        if (estudiante == null || estudiante.getSerialEquipo() == 0) {
            System.out.println("No se encontró ningún préstamo registrado con la cédula o serial proporcionado.");
            return;
        }

        int serialDevuelto = estudiante.getSerialEquipo();
        System.out.println("Equipo con serial " + serialDevuelto + " devuelto por el estudiante " +
                           estudiante.getNombre() + " " + estudiante.getApellido() + ".");
        tabletas.add(new TabletaGrafica(String.valueOf(serialDevuelto), "Desconocida", 0.0f, 0.0f, "Desconocido", 0.0f));
        estudiantesDiseno.remove(estudiante);
        System.out.println("Registro de préstamo eliminado.");
    }

   
    public void buscarEquipoIngenieria(String identificador) {
        EstudianteIngenieria estudiante = buscarEstudianteIngenieriaPorIdentificador(identificador);
        if (estudiante != null) {
            System.out.println("\nInformación del préstamo:");
            System.out.println("Cédula del estudiante: " + estudiante.getCedula());
            System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
            System.out.println("Equipo prestado (Serial): " + estudiante.getSerialEquipo());
        } else {
            System.out.println("No se encontró ningún préstamo registrado con la cédula o serial proporcionado.");
        }
    }

    public void buscarEquipoDiseno(String identificador) {
        EstudianteDiseno estudiante = buscarEstudianteDisenoPorIdentificador(identificador);
        if (estudiante != null) {
            System.out.println("\nInformación del préstamo:");
            System.out.println("Cédula del estudiante: " + estudiante.getCedula());
            System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
            System.out.println("Equipo prestado (Serial): " + estudiante.getSerialEquipo());
        } else {
            System.out.println("No se encontró ningún préstamo registrado con la cédula o serial proporcionado.");
        }
    }

    
    public void imprimirInventarioTotal() {
        System.out.println("\nINVENTARIO TOTAL DE EQUIPOS ELECTRONICOS");
        System.out.println("\nCOMPUTADORES PORTATILES:");
        if (portatiles.isEmpty()) {
            System.out.println("No hay computadores portátiles registrados.");
        } else {
            for (EquipoElectronico portatil : portatiles) {
                System.out.println(portatil);
            }
        }

        System.out.println("\nTABLETAS GRAFICAS:");
        if (tabletas.isEmpty()) {
            System.out.println("No hay tabletas gráficas registradas.");
        } else {
            for (EquipoElectronico tableta : tabletas) {
                System.out.println(tableta);
            }
        }
    }

    private int obtenerOpcion(int min, int max, String mensaje) {
        int opcion;
        do {
            System.out.print(mensaje + " (" + min + "-" + max + "): ");
            try {
                opcion = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); 
                opcion = -1;
            }
        } while (opcion < min || opcion > max);
        scanner.nextLine(); 
        return opcion;
    }

    public String validarCadena(String valor, String regex, String mensajeError) {
        if (valor == null || valor.isEmpty() || !valor.matches(regex)) {
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }
}
