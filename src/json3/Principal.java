package json3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import json1.Persona;

public class Principal {

    public static void main(String[] args) {
        try {
            String rna = "data/alumnos.json"; //estructura clave valor
            String json = new String(Files.readAllBytes(Paths.get(rna)));
            Gson gson = new Gson();
            List<Alumno> alumnos_al = gson.fromJson(json, new TypeToken<List<Alumno>>() {
            }.getType());
            for (Alumno alumno : alumnos_al) {
                System.out.println("Id Alumno       : " + alumno.getIdAlumno());
                System.out.println("Nombre          : " + alumno.getNombre());
                System.out.println("Apellido        : " + alumno.getApellido());
                System.out.println("Estatura        : " + alumno.getEstatura());
                System.out.println("Casado          : " + alumno.getCasado());
                System.out.println("Direccion Calle : " + alumno.getDireccion().getCalle());
                System.out.println("Direccion Numero: " + alumno.getDireccion().getNumero());
                System.out.println("Direccion Ciudad: " + alumno.getDireccion().getCiudad());
                List<String> hobbies_al = alumno.getHobbies();
                System.out.println("Hobbies         : " + String.join(", ", hobbies_al));
                System.out.println();
            }
        } catch (IOException ex) {
        }
    }

}
