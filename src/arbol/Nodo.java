package arbol;

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
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}