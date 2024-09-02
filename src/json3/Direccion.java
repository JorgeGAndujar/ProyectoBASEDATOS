
package json3;

public class Direccion {
    //VARIABLES DE INSTANCIA(ATRIBUTO)
    private String calle;
    private int numero;
    private String ciudad;
    
    //CONSTRUCTORES

    public Direccion(String calle, int numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    public Direccion() {
        this.calle = "";
        this.numero = 0;
        this.ciudad = "";
    }
    //METODOS SET Y GET

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    //METODO TOSTRING 

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + '}';
    }
    
    
}
