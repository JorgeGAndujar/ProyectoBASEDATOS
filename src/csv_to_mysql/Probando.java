package csv_to_mysql;

import java.util.ArrayList;
import java.util.List;

public class Probando {

    public static void main(String[] args) {

        ArrayList<String> nombres_al = new ArrayList<>();

        nombres_al.add("Miguel");
        nombres_al.add("Carlos");

        if (nombres_al.contains("Miguel")) {
            System.out.println("SI ESTA");
        } else {
            System.out.println("NO ESTA");
        }

        //List<String> copianombres_al = (ArrayList<String>)nombres_al.clone();
        nombres_al.clear();

        if (nombres_al.isEmpty()) {
            System.out.println("ESTA VACIA");
        } else {
            System.out.println("NO ESTA VACIA");
        }
        
        String s = nombres_al.get(1);
        System.out.println("Elemento: " + s);

    }

}
