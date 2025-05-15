package PracticaFinal;

public class ObjComputador {
    private String Marca;
    private String Serial;
    private double Tamaño;
    private double Precio;
    private String SistemaOperativo; //crear submenu 1. Windows 7. //2. Windows 10.  //3. Windows 11.
    private String Procesador; //crear submenu 1. AMD Ryzen. //2. Intel® Core™ i5.
    public ObjComputador() {
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public String getSerial() {
        return Serial;
    }
    public void setSerial(String serial) {
        Serial = serial;
    }
    public double getTamaño() {
        return Tamaño;
    }
    public void setTamaño(double tamaño) {
        Tamaño = tamaño;
    }
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double precio) {
        Precio = precio;
    }
    public String getSistemaOperativo() {
        return SistemaOperativo;
    }
    public void setSistemaOperativo(String sistemaOperativo) {
        SistemaOperativo = sistemaOperativo;
    }
    public String getProcesador() {
        return Procesador;
    }
    public void setProcesador(String procesador) {
        Procesador = procesador;
    }



    
} 
