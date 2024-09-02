package json1;

public class Persona {
    //ariables de instancia(atributos)
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String nacimiento;
    //constructores

    public Persona(String dni, String nombre, String apellido, String direccion, String telefono, String nacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
    }

    public Persona() {
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
        this.nacimiento = "";
    }
    //metodos set y get

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
    //metodo to string

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", nacimiento=" + nacimiento + '}';
    }
    
}
