package tarea_6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class BitacoraAplicación {
    public static JTextArea txa ;
    
    public static void agregartextarea(JTextArea txa){
        BitacoraAplicación.txa = txa;
    }
    
    public static void agregaraccion(String mensaje) { 
        new Thread(() -> {
        // Obtener la fecha y hora actual
        LocalDateTime actual = LocalDateTime.now();
        
        // Definir el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("'| 'dd-MM-yyyy '| 'HH:mm:ss '| '");
        
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
        
        File archivo;
        FileWriter escritor;
        PrintWriter linea;
        archivo = new File("./Bitacora_de_Aplicacion/Bitacora.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
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
        } else {
            try {
                escritor = new FileWriter(archivo, true);
                linea = new PrintWriter(escritor);
                // Escribir en el archivo
                linea.println(nuevalinea);
                linea.close();
                escritor.close();
            } catch (IOException e) {
                System.out.println("" + e);
            }
        }
        
        leerbitacora(txa);
        }).start();
    }
    
    public static void leerbitacora(JTextArea txa){
        FileReader archivo;
        BufferedReader lector;
        String linea, contenido;
        List<String> lineas = new ArrayList<>();
        try{
            contenido = "";
        archivo = new FileReader("./Bitacora_de_Aplicacion/Bitacora.txt");
        if(archivo.ready()){
           lector = new BufferedReader(archivo);
           while((linea=lector.readLine()) != null){
              lineas.add(linea);
           }
           lector.close();
           
           // Mostrar la primera línea sin cambios
            if (!lineas.isEmpty()) {
                contenido += lineas.get(0) + "\n"; // Primera línea igual
            }

            // Invertir las demás líneas y agregarlas
            for (int i = lineas.size() - 1; i > 0; i--) {
                contenido += lineas.get(i) + "\n"; // Añadir las líneas invertidas
            }
            
           txa.setText(contenido);
        }
         
        }catch(IOException e){
            System.out.println(""+ e.getMessage());
        }
    }
}
