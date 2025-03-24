package arbol;

import java.util.LinkedList;
import javax.swing.*;
import tarea_6.BitacoraAplicación;

public class SimuladorArbolBinario {

    private ArbolBB miArbol; // Árbol binario de búsqueda

    // Constructor
    public SimuladorArbolBinario() {
        BitacoraAplicación.agregaraccion("Inicializando el árbol binario.");
        this.miArbol = new ArbolBB(); // Inicializa el árbol
    }

    // Método para verificar si el árbol está vacío
    public boolean estaVacio() {
        BitacoraAplicación.agregaraccion("Verificando si el árbol binario esta vacío.");
        return this.miArbol.estaVacio();
    }

    // Método para insertar un número de manera normal
    public boolean insertar(Integer dato) {
        BitacoraAplicación.agregaraccion("Inicio de una inserción de dato normal en árbol binario.");
        if (dato == null) {
            BitacoraAplicación.agregaraccion("El dato que se esta intentando insertar en árbol binario es nulo.");
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        BitacoraAplicación.agregaraccion("Dato agregado en árbol binario.");
        return this.miArbol.agregar(dato);
    }

    // Método para insertar un número específico primero
    public boolean insertarPrimero(Integer numeroEspecifico, Integer dato) {
        if (numeroEspecifico == null || dato == null) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos.");
        }
        
        BitacoraAplicación.agregaraccion("Insertando un número específico primero en el árbol binario.");
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
            BitacoraAplicación.agregaraccion("El dato que se esta intentando eliminar en árbol binario es nulo.");
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        return this.miArbol.eliminar(dato);
    }

    // Método para borrar todo el árbol
    public void borrarArbol() {
        BitacoraAplicación.agregaraccion("Borrando todo el árbol binario.");
        this.miArbol.borrarArbol();
    }

    // Método para mostrar los recorridos del árbol
    public String preOrden() {
        
        LinkedList<Integer> it = this.miArbol.preOrden();
        BitacoraAplicación.agregaraccion("Iniciando reocrrido PreOrden en el árbol binario.");
        return recorrido(it, "Recorrido PreOrden:");
    }

    public String inOrden() {
        LinkedList<Integer> it = this.miArbol.inOrden();
        BitacoraAplicación.agregaraccion("Iniciando reocrrido InOrder en el árbol binario.");
        return recorrido(it, "Recorrido InOrden:");
    }

    public String postOrden() {
        LinkedList<Integer> it = this.miArbol.postOrden();
        BitacoraAplicación.agregaraccion("Iniciando reocrrido PostOrden en el árbol binario.");
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
            BitacoraAplicación.agregaraccion("El dato que se esta intentando buscar en árbol binario es nulo.");
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        boolean siEsta = this.miArbol.existe(dato);
        return "El dato: " + dato.toString() + "\n" +
               (siEsta ? "Si se encuentra en el árbol" : "No se encuentra en el árbol");
    }

    // Método para buscar dato en el nodo (devuelve un booleano)
    public boolean buscarNumero(Integer dato) {
        BitacoraAplicación.agregaraccion("Iniciando búsqueda booleana de un valor en árbol binario.");
        if (dato == null) {
            BitacoraAplicación.agregaraccion("El dato que se esta intentando buscar en árbol binario es nulo.");
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        return this.miArbol.existe(dato);
    }

    // Método para obtener el panel de dibujo del árbol
    public JPanel getDibujo(JScrollPane scrollPane, JPanel panel) {
        if (scrollPane == null || panel == null) {
            BitacoraAplicación.agregaraccion("El mostrador de arbol binario que se esta seleccionando es nulo.");
            throw new IllegalArgumentException("El JScrollPane o el JPanel no pueden ser nulos.");
        }
        return this.miArbol.getdibujo(scrollPane, panel);
    }

    // Método para repintar el árbol
    public void repintarArbol(JPanel panel) {
        if (panel == null) {
            BitacoraAplicación.agregaraccion("El mostrador de arbol binario que se esta seleccionando es nulo.");
            throw new IllegalArgumentException("El JPanel no puede ser nulo.");
        }
        this.miArbol.repintar(panel);
    }

    // Método para buscar con pasos
    public BusquedaResultado buscarConPasos(Integer dato) {
        if (dato == null) {
            BitacoraAplicación.agregaraccion("El dato que se esta intentando buscar por pasos en árbol binario es nulo.");
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        return this.miArbol.buscarConPasos(dato);
    }

    // Método para obtener el elemento en una posición específica
    public Integer obtenerElementoEnPosicion(int posicion) {
        BitacoraAplicación.agregaraccion("Buscando el elemento localizado en la posición "+posicion+" del árbol binario.");
        return this.miArbol.obtenerElementoEnPosicion(posicion);
    }

    // Método para obtener el tamaño del árbol
    public int obtenerTamanioArbol() {
        BitacoraAplicación.agregaraccion("Obteniendo el tamaño del árbol binario.");
        return this.miArbol.obtenerTamanio();
    }
   
}