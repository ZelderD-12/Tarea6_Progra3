package arbol;

import tarea_6.BitacoraAplicación;

public class Nodo {
    private int dato;       // Valor almacenado en el nodo
    private Nodo izq;       // Referencia al hijo izquierdo
    private Nodo der;       // Referencia al hijo derecho
    private int altura;     // Altura del nodo

    // Constructor para crear un nodo con un dato específico
    public Nodo(int dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
        this.altura = 1;    // La altura inicial de un nodo es 1
    }

    // Getters y setters
    public int getDato() {
        BitacoraAplicación.agregaraccion("Obteniendo dato.");
        return dato;
    }

    public void setDato(int dato) {
        BitacoraAplicación.agregaraccion("Estableciendo dato.");
        this.dato = dato;
    }

    public Nodo getIzq() {
        BitacoraAplicación.agregaraccion("Obteniendo nodo izquierdo.");
        return izq;
    }

    public void setIzq(Nodo izq) {
        BitacoraAplicación.agregaraccion("Estableciendo nodo izquierdo.");
        this.izq = izq;
    }

    public Nodo getDer() {
        BitacoraAplicación.agregaraccion("Obteniendo nodo derecho.");
        return der;
    }

    public void setDer(Nodo der) {
        BitacoraAplicación.agregaraccion("Estableciendo nodo derecho.");
        this.der = der;
    }

    public int getAltura() {
        BitacoraAplicación.agregaraccion("Obteniendo altura.");
        return altura;
    }

    public void setAltura(int altura) {
        BitacoraAplicación.agregaraccion("Estableciendo altura.");
        this.altura = altura;
    }
}