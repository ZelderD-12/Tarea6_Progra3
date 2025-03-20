package arbol;

import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ArbolBB {

    private Nodo raiz;

    public ArbolBB() {
        raiz = null;
    }

    // Método para obtener la altura de un nodo
    private int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    // Método para calcular el balance de un nodo
    private int getBalance(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getIzq()) - altura(nodo.getDer());
    }

    // Rotación simple a la derecha
    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.getIzq();
        Nodo T2 = x.getDer();

        // Realizar la rotación
        x.setDer(y);
        y.setIzq(T2);

        // Actualizar alturas
        y.setAltura(Math.max(altura(y.getIzq()), altura(y.getDer())) + 1);
        x.setAltura(Math.max(altura(x.getIzq()), altura(x.getDer())) + 1);

        return x;
    }

    // Rotación simple a la izquierda
    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.getDer();
        Nodo T2 = y.getIzq();

        // Realizar la rotación
        y.setIzq(x);
        x.setDer(T2);

        // Actualizar alturas
        x.setAltura(Math.max(altura(x.getIzq()), altura(x.getDer())) + 1);
        y.setAltura(Math.max(altura(y.getIzq()), altura(y.getDer())) + 1);

        return y;
    }

    // Método para insertar un nodo de manera balanceada
    private Nodo insertarBalanceado(Nodo nodo, int dato) {
        // Inserción normal en un árbol binario de búsqueda
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato < nodo.getDato()) {
            nodo.setIzq(insertarBalanceado(nodo.getIzq(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDer(insertarBalanceado(nodo.getDer(), dato));
        } else {
            return nodo; // No se permiten duplicados
        }

        // Actualizar la altura del nodo actual
        nodo.setAltura(1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer())));

        // Obtener el factor de balance
        int balance = getBalance(nodo);

        // Casos de desbalance
        // Rotación simple a la derecha
        if (balance > 1 && dato < nodo.getIzq().getDato()) {
            return rotarDerecha(nodo);
        }

        // Rotación simple a la izquierda
        if (balance < -1 && dato > nodo.getDer().getDato()) {
            return rotarIzquierda(nodo);
        }

        // Rotación izquierda-derecha
        if (balance > 1 && dato > nodo.getIzq().getDato()) {
            nodo.setIzq(rotarIzquierda(nodo.getIzq()));
            return rotarDerecha(nodo);
        }

        // Rotación derecha-izquierda
        if (balance < -1 && dato < nodo.getDer().getDato()) {
            nodo.setDer(rotarDerecha(nodo.getDer()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Método público para agregar un dato al árbol
    public boolean agregar(int dato) {
        raiz = insertarBalanceado(raiz, dato);
        return true;
    }

    // Método para eliminar un nodo del árbol
    public boolean eliminar(int dato) {
        raiz = eliminarBalanceado(raiz, dato);
        return true;
    }

    // Método privado para eliminar un nodo de manera balanceada
    private Nodo eliminarBalanceado(Nodo nodo, int dato) {
        if (nodo == null) {
            return nodo;
        }

        // Buscar el nodo a eliminar
        if (dato < nodo.getDato()) {
            nodo.setIzq(eliminarBalanceado(nodo.getIzq(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDer(eliminarBalanceado(nodo.getDer(), dato));
        } else {
            // Nodo con un solo hijo o sin hijos
            if ((nodo.getIzq() == null) || (nodo.getDer() == null)) {
                Nodo temp = null;
                if (temp == nodo.getIzq()) {
                    temp = nodo.getDer();
                } else {
                    temp = nodo.getIzq();
                }

                // Caso sin hijos
                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else { // Caso con un hijo
                    nodo = temp; // Copiar el contenido del hijo no nulo
                }
            } else {
                // Nodo con dos hijos: obtener el sucesor inorden (el más pequeño en el subárbol derecho)
                Nodo temp = encontrarMinimo(nodo.getDer());

                // Copiar el dato del sucesor inorden
                nodo.setDato(temp.getDato());

                // Eliminar el sucesor inorden
                nodo.setDer(eliminarBalanceado(nodo.getDer(), temp.getDato()));
            }
        }

        // Si el árbol tenía solo un nodo, retornar
        if (nodo == null) {
            return nodo;
        }

        // Actualizar la altura del nodo actual
        nodo.setAltura(1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer())));

        // Obtener el factor de balance
        int balance = getBalance(nodo);

        // Casos de desbalance
        // Rotación simple a la derecha
        if (balance > 1 && getBalance(nodo.getIzq()) >= 0) {
            return rotarDerecha(nodo);
        }

        // Rotación simple a la izquierda
        if (balance < -1 && getBalance(nodo.getDer()) <= 0) {
            return rotarIzquierda(nodo);
        }

        // Rotación izquierda-derecha
        if (balance > 1 && getBalance(nodo.getIzq()) < 0) {
            nodo.setIzq(rotarIzquierda(nodo.getIzq()));
            return rotarDerecha(nodo);
        }

        // Rotación derecha-izquierda
        if (balance < -1 && getBalance(nodo.getDer()) > 0) {
            nodo.setDer(rotarDerecha(nodo.getDer()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Método para encontrar el nodo con el valor mínimo
    private Nodo encontrarMinimo(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.getIzq() != null) {
            actual = actual.getIzq();
        }
        return actual;
    }
    
     // Método para borrar todo el árbol
    public void borrarArbol() {
        raiz = null; // Elimina toda la estructura del árbol
    }

    // Métodos de recorrido (preOrden, inOrden, postOrden)
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }

    private void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }

    private void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }

    private void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    // Método para verificar si un dato existe en el árbol
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

    // Método para obtener el panel de dibujo del árbol
    public ArbolExpresionGrafico getdibujo(JScrollPane scrollPane, JPanel panel) {
        return new ArbolExpresionGrafico(this, scrollPane, panel);
    }

    // Método para repintar el árbol
    public void repintar(JPanel panel) {
        panel.removeAll(); // Limpia el panel
        ArbolExpresionGrafico dibujo = new ArbolExpresionGrafico(this, new JScrollPane(), panel);
        panel.add(dibujo); // Agrega el nuevo dibujo al panel
        panel.revalidate(); // Revalida el panel
        panel.repaint(); // Repinta el panel
    }
  
    // Método para obtener la raíz del árbol
    public Nodo getRaiz() {
        return raiz;
    }
    
    public BusquedaResultado buscarConPasos(int dato) {
    Nodo aux = raiz;
    int pasos = 0;
    while (aux != null) {
        pasos++;
        if (dato == aux.getDato()) {
            return new BusquedaResultado(true, pasos);
        } else if (dato > aux.getDato()) {
            aux = aux.getDer();
        } else {
            aux = aux.getIzq();
        }
    }
    return new BusquedaResultado(false, pasos);
}
    public Integer obtenerElementoEnPosicion(int posicion) {
    LinkedList<Integer> inOrden = inOrden();
    if (posicion >= 0 && posicion < inOrden.size()) {
        return inOrden.get(posicion);
    }
    return null;
}
    // En la clase ArbolBB
public int obtenerTamanio() {
    return inOrden().size(); // Retorna el tamaño del recorrido InOrden
}
}