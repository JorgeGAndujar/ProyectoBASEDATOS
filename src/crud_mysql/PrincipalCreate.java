package crud_mysql;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.Date;
public class PrincipalCreate {

    public static void main(String[] args) {
       ConexionMysql cm = new ConexionMysql("CAMPUSFP1");
       Connection conexion = cm.getConexion();
       MetodoCrud mc;
       if(conexion != null){
           System.out.println("OK: CONEXION");
           String fechaString ="2000-01-01";
           Date fechaDate = Date.valueOf(LocalDate.parse(fechaString));
           Alumno alumno = new Alumno(0,"Arturo","Goycochea Jauregui","dam",fechaDate);
           mc = new MetodoCrud(conexion);
           if(mc.insertarAlumno(alumno)){
               System.out.println("OK: INSERTALUMNO");
           }else {
               System.out.println("ERROR: INSERTALUMNO");
           }
           
       }else{
           System.out.println("ERROR: CONEXION");
       }
    }
    
}
