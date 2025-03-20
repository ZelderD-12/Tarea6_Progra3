package tarea_6;

import arbol.SimuladorArbolBinario;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Control extends Thread {
    private final SimuladorArbolBinario simulador;
    private final JScrollPane spaneAVL,spaneBinario;
    private final JPanel panelAVL, paneBinario;
    private final ArrayList<Integer> numeros;
    private volatile boolean ejecutando = true; // Bandera para controlar la ejecución del hilo

    public Control(ArrayList<Integer> numeros, JScrollPane spaneA, JPanel paneA,JScrollPane spaneB,JPanel paneB) {
        this.simulador = new SimuladorArbolBinario();
        this.numeros = numeros;
        this.spaneAVL = spaneA;
        this.panelAVL = paneA;
        this.spaneBinario = spaneB;
        this.paneBinario = paneB;
    }

    @Override
    public void run() {
    try {
        for (int numero : numeros) {
            if (!ejecutando) { // Verifica si se debe detener el bucle
                break;
            }
            simulador.insertar(numero); // Inserta el número en el árbol
            actualizarVista(); // Actualiza la vista del árbol
            Thread.sleep(400); // Pausa para simular la inserción paso a paso
        }
        } catch (InterruptedException ex) {
        System.out.println("Hilo interrumpido: " + ex.getMessage());
        }
    }

// Método para actualizar la vista del árbol
private void actualizarVista() {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            if (simulador != null && !simulador.estaVacio()) {
                simulador.getDibujo(spaneAVL, panelAVL); 
                panelAVL.revalidate(); // Actualiza el panel
                panelAVL.repaint(); // Vuelve a dibujar el panel
            }
        }
    });
}

    // Método para detener el hilo
    public void detener() {
        ejecutando = false;
    }
}