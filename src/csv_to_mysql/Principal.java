package csv_to_mysql;

import java.util.List;


public class Principal {

    public static void main(String[] args) {
        //1. CREAR DOS ARCHIVOS NOMBRE MASCULINO.TXT, NOMBRE_FEMENINO.TXT
        MetodoArchivo.crearArhivo("data/masculino.txt");
        MetodoArchivo.crearArhivo("data/femenino.txt");
        
        //2.OBTENER DATOS PARA GRABAR EN EL ARCHIVO
        String rna = "data/nombre.txt";
        List<String> hombres_al = MetodoArchivo.obtenerListaNombresHombres(rna);//RECUPERAR LISTA
        List<String> mujeres_al = MetodoArchivo.obtenerListaNombresMujeres(rna);
        
        //3.GRABAR EN ARCHIVOS SEPARADOS NOMBRES DE OMBRE Y MUJER
        MetodoArchivo.escribirArchivo("data/masculino.txt", hombres_al);//GRABAMOS
        MetodoArchivo.escribirArchivo("data/femenino.txt", mujeres_al);
        
        
    }
}
