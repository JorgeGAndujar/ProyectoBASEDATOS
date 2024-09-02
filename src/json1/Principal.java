package json1;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Principal {

    public static void main(String[] args) {
        try {
            String rna = "data/persona.json"; //estructura clave valor
            String json = new String(Files.readAllBytes(Paths.get(rna)));
            Gson gson = new Gson();
            Persona persona = gson.fromJson(json, Persona.class);
            
            System.out.println("Dni:       " + persona.getDni());
            System.out.println("Nombre:    " + persona.getNombre());
            System.out.println("Apellido:  " + persona.getApellido());
            System.out.println("Direccion: " + persona.getDireccion());
            System.out.println("Telefono:  " + persona.getTelefono());
            System.out.println("Nacimiento:" + persona.getNacimiento());
            System.out.println(persona);
        } catch (IOException ex) {

        }

    }
}
