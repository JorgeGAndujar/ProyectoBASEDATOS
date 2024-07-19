package crud_mysql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class MetodoCrud { //CRUD: CREATE READ  UPDATE      DELETE
    //      CREAR  LEER  ACTUALIZAR  ELIMINAR

    //VARIABLES DE INSTANCIA (ATRIBUTOS)
    private Connection conexion;

    //CONSTRUCTORES
    public MetodoCrud(Connection conexion) {
        this.conexion = conexion;
    }

    //METODOS CRUD: CREATE READ UPDATE DELETE
    //READ (SELECT)
    public List<Alumno> obtenerTodosLosRegistros() {
        List<Alumno> alumnos_al = new ArrayList<>();
        String sql = "SELECT * FROM Alumno";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String grupo = rs.getString("grupo");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                Alumno alumno = new Alumno(idAlumno, nombre, apellidos, grupo, fechaNacimiento);
                alumnos_al.add(alumno);
            }
        } catch (SQLException e) {
            alumnos_al = null;
        }
        return alumnos_al;
    }
    //CREATE (INSERT)
    public boolean insertarAlumno(Alumno alumno){
        boolean correcto = true;
        String sql = "INSERT INTO Alumno (idAlumno, nombre, apellidos, grupo, fechaNacimiento) VALUES (NULL, ?, ?, ?, ?)";//Quary Paramétrica
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellidos());
            ps.setString(3, alumno.getGrupo());
            ps.setDate(4, alumno.getFechaNacimiento());
            ps.executeUpdate();
        }catch(SQLException e){
            correcto = false;
        }
        return correcto;
    }
}
