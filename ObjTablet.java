package PracticaFinal;

public class ObjTablet {
    private String Marca;
    private String Serial;
    private double Tamaño;
    private double Precio;
    private String Almacenamiento; //1.	256 GB //2.	512 GB //3.	1 TB
    private String Peso;  //se debe pedir en kg.
    public ObjTablet() {
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
    public String getAlmacenamiento() {
        return Almacenamiento;
    }
    public void setAlmacenamiento(String almacenamiento) {
        Almacenamiento = almacenamiento;
    }
    public String getPeso() {
        return Peso;
    }
    public void setPeso(String peso) {
        Peso = peso;
    }
    
    
}
