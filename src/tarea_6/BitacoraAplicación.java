
package tarea_6;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BitacoraAplicación {
    
    public static void agregaraccion(String mensaje){
        // Obtener la fecha y hora actual
        LocalDateTime actual = LocalDateTime.now();
        
        // Definir el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("'| 'yyyy-MM-dd '| 'HH:mm:ss '| '");
        
        // Obtener el país o la región desde el sistema
        String pais = Locale.getDefault().getDisplayCountry();
        
        String nuevalinea = "| "+pais+" "+actual.format(formato) + " " + mensaje + " | ";
        
        System.out.println(""+nuevalinea);
    }
}
