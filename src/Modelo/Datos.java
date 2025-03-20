package Modelo;

import java.util.Random;


public class Datos {
    private int[] numerosAleatorios;

    public Datos(int cantidad) {
        generarNumerosAleatorios(cantidad);
    }

    private void generarNumerosAleatorios(int cantidad) {
        numerosAleatorios = new int[cantidad];
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            numerosAleatorios[i] = rand.nextInt(100); // Números aleatorios entre 0 y 99
        }
    }

    public int[] getNumerosAleatorios() {
        return numerosAleatorios;
    }
}
