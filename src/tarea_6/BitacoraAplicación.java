package tarea_6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.io.*;

public class BitacoraAplicación {

    public static void agregaraccion(String mensaje) {
        
        File archivo;
        FileWriter escritor;
        PrintWriter linea;
        archivo = new File("./Bitacora_de_Aplicacion/Bitacora.txt");
        
        // Obtener la fecha y hora actual
        LocalDateTime actual = LocalDateTime.now();
        
        // Definir el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("'| 'yyyy-MM-dd '| 'HH:mm:ss '| '");
        
        // Obtener el país o la región desde el sistema
        String pais = Locale.getDefault().getDisplayCountry();
        
        String PAISARREGLADO = pais;
        
        double espaciosfaltantes = 50- pais.length();
        
        if(espaciosfaltantes>0){
            if((espaciosfaltantes%2)==0){
                int contador = (int) (espaciosfaltantes/2);
                
                //Espacios al inicio
                
                for(int h = 0 ; h<contador; h++){
                    PAISARREGLADO = " " + PAISARREGLADO;
                }
                
                //Espacios al final
                
                for(int h = 0 ; h<contador; h++){
                    PAISARREGLADO = PAISARREGLADO + " ";
                }
            }else{
               int contador = (int) (espaciosfaltantes/2);
                
                //Espacios al inicio
                
                for(int h = 0 ; h<=contador; h++){
                    PAISARREGLADO = " " + PAISARREGLADO;
                }
                
                //Espacios al final
                
                for(int h = 0 ; h<contador; h++){
                    PAISARREGLADO = PAISARREGLADO + " ";
                }
            }
        }
        
        
        
        String nuevalinea = PAISARREGLADO+actual.format(formato) + " " + mensaje;
        
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escritor = new FileWriter(archivo, true);
                linea = new PrintWriter(escritor);
                // Escribir en el archivo
                linea.println(nuevalinea);
                linea.close();
                escritor.close();
            } catch (IOException e) {
                System.out.println("" + e);
            }
        } else {
            try {
                escritor = new FileWriter(archivo, true);
                linea = new PrintWriter(escritor);
                // Escribir en el archivo
                linea.println("                     Ubicación                    |    Fecha   |   Hora   |           Actividad");
                linea.println(nuevalinea);
                linea.close();
                escritor.close();
            } catch (IOException e) {
                System.out.println("" + e);
            }
        }
    }
}
