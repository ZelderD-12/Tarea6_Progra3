package arbol;

import java.util.LinkedList;
import javax.swing.*;

public class SimuladorArbolBinario {

    ArbolBB miArbol = new ArbolBB();

    public SimuladorArbolBinario() {        
    }

    // Método para insertar un número de manera normal
    public boolean insertar(Integer dato) {
        return (this.miArbol.agregar(dato));
    }

    // Método para insertar un número específico primero
    public boolean insertarPrimero(Integer numeroEspecifico, Integer dato) {
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
        return this.miArbol.eliminar(dato);
    }
   // Método para borrar todo el árbol
    public void borrarArbol() {
        miArbol.borrarArbol();
    }
    

    // Método para mostrar los recorridos del árbol
    public String preOrden() {
        LinkedList it = this.miArbol.preOrden();
        return (recorrido(it, "Recorrido PreOrden:"));
    }

    public String inOrden() {
        LinkedList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden:"));
    }

    public String postOrden() {
        LinkedList it = this.miArbol.postOrden();
        return (recorrido(it, "Recorrido PosOrden:"));
    }

    // Método para poder mostrar los tipos de recorrido
    private String recorrido(LinkedList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "";
            i++;
        }
        return (r);
    }

    // Método para buscar dato en el nodo (devuelve un String)
    public String buscar(Integer dato) {
        boolean siEsta = this.miArbol.existe(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el árbol" : "No se encuentra en el árbol";
        return (r);
    }

    // Método para buscar dato en el nodo (devuelve un booleano)
    public boolean buscarNumero(Integer dato) {
        return this.miArbol.existe(dato);
    }

    // Método para obtener el panel de dibujo del árbol
    public JPanel getDibujo(JScrollPane scrollPane, JPanel panel) {
        return this.miArbol.getdibujo(scrollPane, panel);
    }

    
    public void repintarArbol(JPanel panel) {
        this.miArbol.repintar(panel);
    }
    public BusquedaResultado buscarConPasos(Integer dato) {
    return miArbol.buscarConPasos(dato);
    }
    public BusquedaResultado buscarConPasos(int dato) {
    return miArbol.buscarConPasos(dato);
    }

    public Integer obtenerElementoEnPosicion(int posicion) {
    return miArbol.obtenerElementoEnPosicion(posicion);
    }
    // En la clase SimuladorArbolBinario
    public int obtenerTamanioArbol() {
    return miArbol.obtenerTamanio();
    }
}