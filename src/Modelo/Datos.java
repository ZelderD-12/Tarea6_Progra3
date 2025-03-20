package Modelo;

import java.util.Random;
import tarea_6.BitacoraAplicación;


public class Datos {
    private int[] numerosAleatorios;

    public Datos(int cantidad) {
        generarNumerosAleatorios(cantidad);
    }

    private void generarNumerosAleatorios(int cantidad) {
        BitacoraAplicación.agregaraccion("Se solicita generar " + cantidad + " números aleatorios.");
        numerosAleatorios = new int[cantidad];
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            numerosAleatorios[i] = rand.nextInt(100); // Números aleatorios entre 0 y 99
            BitacoraAplicación.agregaraccion("Número " +numerosAleatorios[i]+ " generado.");
        }
    }

    public int[] getNumerosAleatorios() {
        BitacoraAplicación.agregaraccion("Se solicita una lista de números aleatorios ya generados previamente.");
        return numerosAleatorios;
    }
}
