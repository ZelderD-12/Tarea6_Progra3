package arbol;

import java.util.LinkedList;
import javax.swing.*;

public class SimuladorArbolBinario {

    private ArbolBB miArbol; // Árbol binario de búsqueda

    // Constructor
    public SimuladorArbolBinario() {
        this.miArbol = new ArbolBB(); // Inicializa el árbol
    }

    // Método para verificar si el árbol está vacío
    public boolean estaVacio() {
        return this.miArbol.estaVacio();
    }

    // Método para insertar un número de manera normal
    public boolean insertar(Integer dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        return this.miArbol.agregar(dato);
    }

    // Método para insertar un número específico primero
    public boolean insertarPrimero(Integer numeroEspecifico, Integer dato) {
        if (numeroEspecifico == null || dato == null) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos.");
        }
        // Insertar el número específico primero
        boolean insertado = this.miArbol.agregar(numeroEspecifico);
        
        // Insertar el número normal
        if (insertado) {
            insertado = this.miArbol.agregar(dato);
        }

        return insertado;
    }

    // Método para eliminar un número del árbol
    public boolean eliminar(Integer dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        return this.miArbol.eliminar(dato);
    }

    // Método para borrar todo el árbol
    public void borrarArbol() {
        this.miArbol.borrarArbol();
    }

    // Método para mostrar los recorridos del árbol
    public String preOrden() {
        LinkedList<Integer> it = this.miArbol.preOrden();
        return recorrido(it, "Recorrido PreOrden:");
    }

    public String inOrden() {
        LinkedList<Integer> it = this.miArbol.inOrden();
        return recorrido(it, "Recorrido InOrden:");
    }

    public String postOrden() {
        LinkedList<Integer> it = this.miArbol.postOrden();
        return recorrido(it, "Recorrido PosOrden:");
    }

    // Método para poder mostrar los tipos de recorrido
    private String recorrido(LinkedList<Integer> it, String msg) {
        StringBuilder r = new StringBuilder(msg + "\n");
        for (Integer numero : it) {
            r.append("\t").append(numero.toString()).append("\n");
        }
        return r.toString();
    }

    // Método para buscar dato en el nodo (devuelve un String)
    public String buscar(Integer dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        boolean siEsta = this.miArbol.existe(dato);
        return "El dato: " + dato.toString() + "\n" +
               (siEsta ? "Si se encuentra en el árbol" : "No se encuentra en el árbol");
    }

    // Método para buscar dato en el nodo (devuelve un booleano)
    public boolean buscarNumero(Integer dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        return this.miArbol.existe(dato);
    }

    // Método para obtener el panel de dibujo del árbol
    public JPanel getDibujo(JScrollPane scrollPane, JPanel panel) {
        if (scrollPane == null || panel == null) {
            throw new IllegalArgumentException("El JScrollPane o el JPanel no pueden ser nulos.");
        }
        return this.miArbol.getdibujo(scrollPane, panel);
    }

    // Método para repintar el árbol
    public void repintarArbol(JPanel panel) {
        if (panel == null) {
            throw new IllegalArgumentException("El JPanel no puede ser nulo.");
        }
        this.miArbol.repintar(panel);
    }

    // Método para buscar con pasos
    public BusquedaResultado buscarConPasos(Integer dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        return this.miArbol.buscarConPasos(dato);
    }

    // Método para obtener el elemento en una posición específica
    public Integer obtenerElementoEnPosicion(int posicion) {
        return this.miArbol.obtenerElementoEnPosicion(posicion);
    }

    // Método para obtener el tamaño del árbol
    public int obtenerTamanioArbol() {
        return this.miArbol.obtenerTamanio();
    }
}