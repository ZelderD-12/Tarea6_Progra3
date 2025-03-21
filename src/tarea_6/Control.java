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

    @Override
    public void run() {
        try {
            for (int numero : numeros) {
                if (!ejecutando) { // Verifica si se debe detener el bucle
                    break;
                }
                 
                simuladorAVL.insertar(numero); // Inserta en el árbol equilibrado
                simuladorBinario.agregar(numero); // Inserta en el árbol no equilibrado
                actualizarVista(); // Actualiza la vista de ambos árboles
                Thread.sleep(400); // Pausa para simular la inserción paso a paso
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido: " + ex.getMessage());
        }
    }
 
  public boolean insertar(Integer dato) {
    if (dato == null) {
        throw new IllegalArgumentException("El dato no puede ser nulo.");
    }

    // Insertar en el árbol AVL
    boolean insertadoAVL = simuladorAVL.insertar(dato);

    // Insertar en el árbol binario no equilibrado
    boolean insertadoBinario = simuladorBinario.agregar(dato);

    // Actualizar la vista de ambos árboles solo si la inserción fue exitosa
    if (insertadoAVL && insertadoBinario) {
        actualizarVista();
    }

    // Retorna true si la inserción fue exitosa en ambos árboles
    return insertadoAVL && insertadoBinario;
}
    // Método para insertar un número específico primero en ambos árboles
public boolean insertarPrimero(Integer numeroEspecifico, Integer dato) {
    if (numeroEspecifico == null || dato == null) {
        throw new IllegalArgumentException("Los datos no pueden ser nulos.");
    }

    // Insertar el número específico primero en ambos árboles
    boolean insertadoAVL = simuladorAVL.insertar(numeroEspecifico);
    boolean insertadoBinario = simuladorBinario.agregar(numeroEspecifico);

    // Insertar el número normal en ambos árboles
    if (insertadoAVL && insertadoBinario) {
        insertadoAVL = simuladorAVL.insertar(dato);
        insertadoBinario = simuladorBinario.agregar(dato);
    }

    // Actualizar la vista de ambos árboles
    actualizarVista();

    // Retorna true si la inserción fue exitosa en ambos árboles
    return insertadoAVL && insertadoBinario;
}
    
   public boolean eliminar(Integer dato) {
    if (dato == null) {
        throw new IllegalArgumentException("El dato no puede ser nulo.");
    }

    // Eliminar del árbol AVL
    boolean eliminadoAVL = simuladorAVL.eliminar(dato);

    // Eliminar del árbol binario no equilibrado
    boolean eliminadoBinario = simuladorBinario.eliminar(dato);

    // Actualizar la vista de ambos árboles solo si la eliminación fue exitosa
    if (eliminadoAVL && eliminadoBinario) {
        actualizarVista();
    }

    // Retorna true si la eliminación fue exitosa en ambos árboles
    return eliminadoAVL && eliminadoBinario;
}
 public String buscar(Integer dato) {
    if (dato == null) {
        throw new IllegalArgumentException("El dato no puede ser nulo.");
    }

    // Buscar en el árbol AVL
    boolean encontradoAVL = simuladorAVL.buscarNumero(dato);

    // Buscar en el árbol binario no equilibrado
    boolean encontradoBinario = simuladorBinario.buscar(dato);
    
   // Retorna un mensaje indicando si se encontró en alguno de los árboles
    return "El dato: " + dato.toString() + "\n" +
           (encontradoAVL ? "Se encuentra en el árbol AVL" : "No se encuentra en el árbol AVL") + "\n" +
           (encontradoBinario ? "Se encuentra en el árbol binario no equilibrado" : "No se encuentra en el árbol binario no equilibrado");
}
    
    // Método para actualizar la vista de ambos árboles
    public  void actualizarVista() {
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