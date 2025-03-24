package tarea_6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.io.*;
import javax.swing.*;

public class BitacoraAplicación {
    private static JTextArea txa;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("'| 'dd-MM-yyyy '| 'HH:mm:ss '| '");
    private static BufferedWriter escritorArchivo;

    // Inicializar el escritor del archivo
    static {
        try {
            File archivo = new File("./Bitacora_de_Aplicacion/Bitacora.txt");
            if (!archivo.exists()) {
                archivo.getParentFile().mkdirs(); // Crear directorio si no existe
                archivo.createNewFile();
            }
            escritorArchivo = new BufferedWriter(new FileWriter(archivo, true));
        } catch (IOException e) {
            System.err.println("Error al inicializar el archivo de bitácora: " + e.getMessage());
        }
    }

    public static void agregartextarea(JTextArea txa) {
        BitacoraAplicación.txa = txa;
    }

    public static void agregaraccion(String mensaje) {
        new Thread(() -> {
            LocalDateTime actual = LocalDateTime.now();
            String pais = Locale.getDefault().getDisplayCountry();
            String paisAjustado = ajustarPais(pais);

            String nuevalinea = paisAjustado + actual.format(FORMATO) + " " + mensaje;

            // Escribir en el archivo
            try {
                synchronized (escritorArchivo) {
                    escritorArchivo.write(nuevalinea);
                    escritorArchivo.newLine();
                    escritorArchivo.flush();
                }
            } catch (IOException e) {
                System.err.println("Error al escribir en la bitácora: " + e.getMessage());
            }

            // Actualizar la interfaz gráfica
            SwingUtilities.invokeLater(() -> {
                if (txa != null) {
                    txa.append(nuevalinea + "\n");
                    txa.setCaretPosition(txa.getDocument().getLength());
                }
            });
        }).start();
    }

    private static String ajustarPais(String pais) {
        int espaciosFaltantes = 50 - pais.length();
        if (espaciosFaltantes > 0) {
            int espaciosInicio = (espaciosFaltantes + 1) / 2;
            int espaciosFin = espaciosFaltantes / 2;

            StringBuilder paisAjustado = new StringBuilder();
            for (int i = 0; i < espaciosInicio; i++) {
                paisAjustado.append(" ");
            }
            paisAjustado.append(pais);
            for (int i = 0; i < espaciosFin; i++) {
                paisAjustado.append(" ");
            }
            return paisAjustado.toString();
        }
        return pais;
    }

    public static void leerbitacora() {
        new Thread(() -> {
            File archivo = new File("./Bitacora_de_Aplicacion/Bitacora.txt");
            if (!archivo.exists()) {
                return;
            }

            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }

                SwingUtilities.invokeLater(() -> {
                    if (txa != null) {
                        txa.setText(contenido.toString());
                        txa.setCaretPosition(txa.getDocument().getLength());
                    }
                });
            } catch (IOException e) {
                System.err.println("Error al leer la bitácora: " + e.getMessage());
            }
        }).start();
    }

    // Método para cerrar el archivo de bitácora al finalizar
    public static void cerrarBitacora() {
        try {
            if (escritorArchivo != null) {
                escritorArchivo.close();
            }
        } catch (IOException e) {
            System.err.println("Error al cerrar el archivo de bitácora: " + e.getMessage());
        }
    }
}