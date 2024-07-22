package csv_to_mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class PrincipalCsvToMysql {

    static ConexionMysql cm = new ConexionMysql("INSTITUTO");
    static Connection conexion = cm.getConexion();

    public static void main(String[] args) {
        
        
       List<Alumno> alumnos_al = obtenerListaAlumnos();
       
       if(insertarAlumno(alumnos_al)== true){
         System.out.println("OK INSERT");  
       }else {
         System.out.println("ERROR INSERT"); 
       }

    }

    public static List<Alumno> obtenerListaAlumnos() {
        List<Alumno> alumnos_al = new ArrayList<>();
        File f;
        FileReader fr;
        BufferedReader br;
        String fila = "";
        try {
            f = new File("data/persona.csv");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((fila = br.readLine()) != null) {
                String[] p = fila.split(";");
                Date fechaDate = Date.valueOf(LocalDate.parse(p[3]));
                Alumno alumno = new Alumno(Integer.parseInt(p[0]),
                        p[1],
                        p[2],
                        fechaDate);
                alumnos_al.add(alumno);
                System.out.println(alumno);
            }

        } catch (Exception e) {
            System.out.println("ERROR2: " + e.getMessage());
        }
        return alumnos_al;
    }

    public static boolean insertarAlumno(List<Alumno> alumnos_al) {
        boolean correcto = true;
        String sql = "INSERT INTO Alumno (idAlumno,nombre_apellido,sexo,fecha_nacimiento) VALUES (?,?,?,?)";//QUERY PARAMÉTRICA , los interrogantes empiezan en 1
        PreparedStatement ps = null;
        for (Alumno a : alumnos_al) {
            try {
                ps = conexion.prepareStatement(sql);
                ps.setInt(1, a.getIdAlumno());
                ps.setString(2, a.getNombreApellido());
                ps.setString(3, a.getSexo());
                ps.setDate(4, a.getFechaNacimiento());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("ERROR1: " + e.getMessage());

            }

        }

        return correcto;
    }

}
