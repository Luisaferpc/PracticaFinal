abstract class EquipoElectronico {
    private String serial;
    private String marca;
    private float tamano;
    private float precio;

    public EquipoElectronico(String serial, String marca, float tamano, float precio) {
        this.serial = validarCadena(serial, "^[a-zA-Z0-9]+$", "El serial del equipo no puede contener caracteres especiales.");
        this.marca = validarCadena(marca, "^[a-zA-Z\\s]+$", "La marca no puede contener números ni caracteres especiales.");
        this.tamano = tamano;
        this.precio = precio;
    }

    public String getSerial() {
        return serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = validarCadena(marca, "^[a-zA-Z\\s]+$", "La marca no puede contener números ni caracteres especiales.");
    }

    public float getTamano() {
        return tamano;
    }

    public void setTamano(float tamano) {
        this.tamano = tamano;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    private String validarCadena(String valor, String regex, String mensajeError) {
        if (valor == null || valor.isEmpty() || !valor.matches(regex)) {
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }
}