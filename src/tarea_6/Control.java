package tarea_6;

import arbol.SimuladorArbolBinario;
import arbol.ArbolBinarioNoEquilibrado;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Control extends Thread {
    private final SimuladorArbolBinario simuladorAVL; // Árbol equilibrado
    private final ArbolBinarioNoEquilibrado simuladorBinario; // Árbol no equilibrado
    private final JScrollPane spaneAVL, spaneBinario;
    private final JPanel panelAVL, paneBinario;
    private final ArrayList<Integer> numeros;
    private volatile boolean ejecutando = true; // Bandera para controlar la ejecución del hilo
    private JTextArea txtAreaRepetidos;

    public Control(ArrayList<Integer> numeros, JScrollPane spaneA, JPanel paneA, JScrollPane spaneB, JPanel paneB, JTextArea txtarea) {
        this.simuladorAVL = new SimuladorArbolBinario(); // Árbol equilibrado
        this.simuladorBinario = new ArbolBinarioNoEquilibrado(); // Árbol no equilibrado
        this.numeros = numeros;
        this.spaneAVL = spaneA;
        this.panelAVL = paneA;
        this.spaneBinario = spaneB;
        this.paneBinario = paneB;
        this.txtAreaRepetidos = txtarea;
    }

    // Método para insertar un número, verificando duplicados
    public boolean insertar(int numero) {
        // Verificar si el número ya existe en alguno de los árboles
        boolean existeEnAVL = simuladorAVL.buscarNumero(numero);
        boolean existeEnBinario = simuladorBinario.buscar(numero);

        if (existeEnAVL || existeEnBinario) {
            // Si el número ya existe, escribirlo en txtAreaRepetidos
            SwingUtilities.invokeLater(() -> {
                txtAreaRepetidos.append(numero + " está repetido.\n");
            });
            return false; // No se inserta el número
        } else {
            // Si el número no existe, insertarlo en ambos árboles
            simuladorAVL.insertar(numero);
            simuladorBinario.agregar(numero);
            actualizarVista(); // Actualizar la vista solo si no es repetido
            return true; // Se insertó correctamente
        }
    }

    @Override
    public void run() {
        try {
            for (int numero : numeros) {
                if (!ejecutando) { // Verifica si se debe detener el bucle
                    break;
                }

                insertar(numero); // Usa el método insertar que verifica duplicados
                Thread.sleep(400); // Pausa para simular la inserción paso a paso
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido: " + ex.getMessage());
        }
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

    // Método para eliminar un número de ambos árboles
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

    // Método para buscar un número en ambos árboles
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
    public void actualizarVista() {
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

    public void escribirRecorridos(JTextArea txtArea, String arbolSeleccionado) {
    if (txtArea == null) {
        throw new IllegalArgumentException("El JTextArea no puede ser nulo.");
    }

    if (arbolSeleccionado == null || arbolSeleccionado.isEmpty()) {
        throw new IllegalArgumentException("El árbol seleccionado no puede ser nulo o vacío.");
    }

    // Limpiar el JTextArea antes de escribir los recorridos
    txtArea.setText("");

    // Obtener los recorridos según el árbol seleccionado
     if (arbolSeleccionado.equalsIgnoreCase("AVL")) {
            if (simuladorAVL != null && !simuladorAVL.estaVacio()) {
                txtArea.append("=== Recorrido Pre-Orden (AVL Binario Equilibrado) ===\n");
                txtArea.append(simuladorAVL.preOrden() + "\n\n");

                txtArea.append("=== Recorrido In-Orden (AVL Binario Equilibrado) ===\n");
                txtArea.append(simuladorAVL.inOrden() + "\n\n");

                txtArea.append("=== Recorrido Post-Orden (AVL Binario Equilibrado) ===\n");
                txtArea.append(simuladorAVL.postOrden() + "\n");
            } else {
                txtArea.append("El árbol AVL está vacío.\n");
            }
    } else if (arbolSeleccionado.equalsIgnoreCase("BinarioNoEquilibrado")) {
        if (simuladorBinario != null && !simuladorBinario.estaVacio()) {
            txtArea.append("=== Recorrido Pre-Orden (Binario No Equilibrado) ===\n");
            txtArea.append(formatearRecorrido(simuladorBinario.preOrden()) + "\n\n");

            txtArea.append("=== Recorrido In-Orden (Binario No Equilibrado) ===\n");
            txtArea.append(formatearRecorrido(simuladorBinario.inOrden()) + "\n\n");

            txtArea.append("=== Recorrido Post-Orden (Binario No Equilibrado) ===\n");
            txtArea.append(formatearRecorrido(simuladorBinario.postOrden()) + "\n");
        } else {
            txtArea.append("El árbol binario no equilibrado está vacío.\n");
        }
    } else {
        txtArea.append("Árbol no reconocido. Seleccione 'AVL' o 'BinarioNoEquilibrado'.\n");
    }
}

    // Método auxiliar para formatear un recorrido (LinkedList) con saltos de línea
    private String formatearRecorrido(LinkedList<Integer> recorrido) {
    StringBuilder sb = new StringBuilder();
    for (Integer numero : recorrido) {
        sb.append(numero).append("\n"); // Agrega cada número en una nueva línea
    }
    return sb.toString();
    }
}