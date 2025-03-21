package tarea_6;

import arbol.SimuladorArbolBinario;
import arbol.ArbolBinarioNoEquilibrado;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Control extends Thread {
    private final SimuladorArbolBinario simuladorAVL; // Árbol equilibrado
    private final ArbolBinarioNoEquilibrado simuladorBinario; // Árbol no equilibrado
    private final JScrollPane spaneAVL, spaneBinario;
    private final JPanel panelAVL, paneBinario;
    private final ArrayList<Integer> numeros;
    private volatile boolean ejecutando = true; // Bandera para controlar la ejecución del hilo

    public Control(ArrayList<Integer> numeros, JScrollPane spaneA, JPanel paneA, JScrollPane spaneB, JPanel paneB) {
        this.simuladorAVL = new SimuladorArbolBinario(); // Árbol equilibrado
        this.simuladorBinario = new ArbolBinarioNoEquilibrado(); // Árbol no equilibrado
        this.numeros = numeros;
        this.spaneAVL = spaneA;
        this.panelAVL = paneA;
        this.spaneBinario = spaneB;
        this.paneBinario = paneB;
    }
    public void insertar(int numero){
        simuladorAVL.insertar(numero); // Inserta en el árbol equilibrado
        simuladorBinario.agregar(numero);
    }

    @Override
    public void run() {
        try {
            for (int numero : numeros) {
                if (!ejecutando) { // Verifica si se debe detener el bucle
                    break;
                }
                insertar(numero);
                actualizarVista(); // Actualiza la vista de ambos árboles
                Thread.sleep(400); // Pausa para simular la inserción paso a paso
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido: " + ex.getMessage());
        }
    }

    // Método para actualizar la vista de ambos árboles
    private void actualizarVista() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (simuladorAVL != null && !simuladorAVL.estaVacio()) {
                    simuladorAVL.getDibujo(spaneAVL, panelAVL); // Actualiza el árbol equilibrado
                    panelAVL.revalidate();
                    panelAVL.repaint();
                }
                if (simuladorBinario != null && !simuladorBinario.estaVacio()) {
                    simuladorBinario.getdibujo(spaneBinario, paneBinario); // Actualiza el árbol no equilibrado
                    paneBinario.revalidate();
                    paneBinario.repaint();
                }
            }
        });
    }

    // Método para detener el hilo
    public void detener() {
        ejecutando = false;
    }
}