package arbol;

import java.util.LinkedList;
import javax.swing.*;

public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;

    public ArbolBB() {
        raiz = null;
    }

    public boolean agregar(int dato) {
        Nodo nuevo = new Nodo(dato, null, null);
        insertar(nuevo, raiz);
        return true;
    }

    // Método para insertar un dato en el árbol (no acepta repetidos)
    public void insertar(Nodo nuevo, Nodo pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    // Recorrido preorden
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }

    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    // Recorrido inorden
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }

    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    // Recorrido postorden
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }

    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    // Método para verificar si un nodo existe en el árbol
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }

    // Método para calcular la altura del árbol
    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }

    // Devuelve la altura del árbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }

    // Método para obtener el panel de dibujo del árbol
    public ArbolExpresionGrafico getdibujo(JScrollPane scrollPane, JPanel panel) {
        return new ArbolExpresionGrafico(this, scrollPane, panel);
    }
}