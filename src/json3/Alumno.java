
package json3;

import java.util.List;

public class Alumno {
    //VARIABLES DE INSTANCIA(ATRIBUTOS)
    private int idAlumno;
    private String nombre;
    private String apellido;
    private double estatura;
    private boolean casado;
    private Direccion direccion;
    private List<String> hobbies;
    
    //CONSTRUCTORES

    public Alumno(int idAlumno, String nombre, String apellido, float estatura, boolean casado, Direccion direccion, List<String> hobbies) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.casado = casado;
        this.direccion = direccion;
        this.hobbies = hobbies;
    }

    public Alumno() {
        this.idAlumno = 0;
        this.nombre = "";
        this.apellido = "";
        this.estatura = 0.0;
        this.casado = false;
        this.direccion = null;
        this.hobbies = null;
    }
    //METODOS SET AND GET

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public boolean getCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
    
    //METODOS TOSTRING

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", estatura=" + estatura + ", casado=" + casado + ", direccion=" + direccion + ", hobbies=" + hobbies + '}';
    }
    
}
