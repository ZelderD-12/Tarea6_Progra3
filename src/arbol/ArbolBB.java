package arbol;

import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import tarea_6.BitacoraAplicación;

public class ArbolBB {

    Nodo raiz;

    public ArbolBB() {
        raiz = null;
    }

    // Método para obtener la altura de un nodo
    private int altura(Nodo nodo) {
        
        BitacoraAplicación.agregaraccion("Se esta calculando la altura del nodo "+ nodo);
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    // Método para calcular el balance de un nodo
    private int getBalance(Nodo nodo) {
        BitacoraAplicación.agregaraccion("Se esta calculando el balance del nodo "+nodo);
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getIzq()) - altura(nodo.getDer());
    }

    // Rotación simple a la derecha
    private Nodo rotarDerecha(Nodo y) {
        BitacoraAplicación.agregaraccion("Se esta realizando una rotación a la derecha del nodo " + y+".");
        BitacoraAplicación.agregaraccion("Guardando el valor a la izquierda del nodo.");
        Nodo x = y.getIzq();
        BitacoraAplicación.agregaraccion("Guardando el nodo principal.");
        Nodo T2 = x.getDer();

        // Realizar la rotación
        BitacoraAplicación.agregaraccion("Reemplazando la posición de los nodos principal, izquierdo y derecho.");
        x.setDer(y);
        y.setIzq(T2);

        
        // Actualizar alturas
        BitacoraAplicación.agregaraccion("Recalculando las alturas de los subarboles.");
        y.setAltura(Math.max(altura(y.getIzq()), altura(y.getDer())) + 1);
        x.setAltura(Math.max(altura(x.getIzq()), altura(x.getDer())) + 1);

        return x;
    }

    // Rotación simple a la izquierda
    private Nodo rotarIzquierda(Nodo x) {
        BitacoraAplicación.agregaraccion("Se esta realizando una rotación a la derecha del nodo " + x+".");
        BitacoraAplicación.agregaraccion("Guardando el valor a la derecha del nodo.");
        Nodo y = x.getDer();
        BitacoraAplicación.agregaraccion("Guardando el nodo principal.");
        Nodo T2 = y.getIzq();

        // Realizar la rotación
        BitacoraAplicación.agregaraccion("Reemplazando la posición de los nodos principal, izquierdo y derecho.");
        y.setIzq(x);
        x.setDer(T2);

        // Actualizar alturas
        BitacoraAplicación.agregaraccion("Recalculando las alturas de los subarboles.");
        x.setAltura(Math.max(altura(x.getIzq()), altura(x.getDer())) + 1);
        y.setAltura(Math.max(altura(y.getIzq()), altura(y.getDer())) + 1);

        return y;
    }

    // Método para insertar un nodo de manera balanceada
    private Nodo insertarBalanceado(Nodo nodo, int dato) {
        // Inserción normal en un árbol binario de búsqueda
        BitacoraAplicación.agregaraccion("Se inicia una insserción balanceada de un nuevo valor.");
        if (nodo == null) {
            BitacoraAplicación.agregaraccion("El nodo no existe.");
            return new Nodo(dato);
        }

        if (dato < nodo.getDato()) {
            BitacoraAplicación.agregaraccion("Moviendo el puntero hacia la izquierda del nodo "+ nodo.getDato()+".");
            nodo.setIzq(insertarBalanceado(nodo.getIzq(), dato));
        } else if (dato > nodo.getDato()) {
            BitacoraAplicación.agregaraccion("Moviendo el puntero hacia la derecha del nodo "+ nodo.getDato()+".");
            nodo.setDer(insertarBalanceado(nodo.getDer(), dato));
        } else {
            BitacoraAplicación.agregaraccion("Es un duplicado, no autorizado.");
            return nodo; // No se permiten duplicados
        }

        // Actualizar la altura del nodo actual
        BitacoraAplicación.agregaraccion("Se actualiza la altura del nodo insertado.");
        nodo.setAltura(1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer())));

        // Obtener el factor de balance
        BitacoraAplicación.agregaraccion("Obteniendo factor de balance.");
        int balance = getBalance(nodo);

        // Casos de desbalance
        // Rotación simple a la derecha
        if (balance > 1 && dato < nodo.getIzq().getDato()) {
            BitacoraAplicación.agregaraccion("Se esta detectando un desbalance a la izquierda.");
            return rotarDerecha(nodo);
        }

        // Rotación simple a la izquierda
        if (balance < -1 && dato > nodo.getDer().getDato()) {
            BitacoraAplicación.agregaraccion("Se esta detectando un desbalance a la derecha.");
            return rotarIzquierda(nodo);
        }

        // Rotación izquierda-derecha
        if (balance > 1 && dato > nodo.getIzq().getDato()) {
            BitacoraAplicación.agregaraccion("Se esta detectando un desequilibrio, 1 hijo del subarbol izquierdo puede pertenecer al subarbol derecho.");
            nodo.setIzq(rotarIzquierda(nodo.getIzq()));
            return rotarDerecha(nodo);
        }

        // Rotación derecha-izquierda
        if (balance < -1 && dato < nodo.getDer().getDato()) {
            BitacoraAplicación.agregaraccion("Se esta detectando un desequilibrio, 1 hijo del subarbol derecho puede pertenecer al subarbol izquierdo.");
            nodo.setDer(rotarDerecha(nodo.getDer()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Método público para agregar un dato al árbol
    public boolean agregar(int dato) {
        BitacoraAplicación.agregaraccion("Se esta evaluando agregar el valor "+dato + " al árbol.");
        raiz = insertarBalanceado(raiz, dato);
        return true;
    }

    // Método para eliminar un nodo del árbol
    public boolean eliminar(int dato) {
        BitacoraAplicación.agregaraccion("Se esta evaluando eliminar el valor "+dato + " del árbol.");
        raiz = eliminarBalanceado(raiz, dato);
        return true;
    }

    // Método privado para eliminar un nodo de manera balanceada
    private Nodo eliminarBalanceado(Nodo nodo, int dato) {
        BitacoraAplicación.agregaraccion("Eliminando balanceadamente el nodo "+nodo+" cuyo valor es "+dato+".");
        if (nodo == null) {
            BitacoraAplicación.agregaraccion("El nodo no existe.");
            return nodo;
        }

        // Buscar el nodo a eliminar
        BitacoraAplicación.agregaraccion("Buscando la posición del nodo.");
        if (dato < nodo.getDato()) {
            BitacoraAplicación.agregaraccion("Buscando en el subarbol izquierdo.");
            nodo.setIzq(eliminarBalanceado(nodo.getIzq(), dato));
        } else if (dato > nodo.getDato()) {
            BitacoraAplicación.agregaraccion("Buscando en el subarbol derecho.");
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
                    BitacoraAplicación.agregaraccion("Solo 1 hijo detectado, copiando su contenido.");
                    nodo = temp; // Copiar el contenido del hijo no nulo
                }
            } else {
                // Nodo con dos hijos: obtener el sucesor inorden (el más pequeño en el subárbol derecho)
                BitacoraAplicación.agregaraccion("Obteniendo el sucesor en orden más pequeño.");
                Nodo temp = encontrarMinimo(nodo.getDer());

                // Copiar el dato del sucesor inorden
                BitacoraAplicación.agregaraccion("Copiar el sucesor en orden.");
                nodo.setDato(temp.getDato());

                // Eliminar el sucesor inorden
                BitacoraAplicación.agregaraccion("Eliminación del sucesor en orden.");
                nodo.setDer(eliminarBalanceado(nodo.getDer(), temp.getDato()));
            }
        }

        // Si el árbol tenía solo un nodo, retornar
        if (nodo == null) {
            BitacoraAplicación.agregaraccion("El árbol solo tiene un nodo.");
            return nodo;
        }

        // Actualizar la altura del nodo actual
        BitacoraAplicación.agregaraccion("Actualizando altura del nodo actual.");
        nodo.setAltura(1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer())));

        // Obtener el factor de balance
        BitacoraAplicación.agregaraccion("Obteniendo el factor de balance");
        int balance = getBalance(nodo);

        // Casos de desbalance
        // Rotación simple a la derecha
        if (balance > 1 && getBalance(nodo.getIzq()) >= 0) {
            BitacoraAplicación.agregaraccion("Se esta detectando un desbalance a la izquierda.");
            return rotarDerecha(nodo);
        }

        // Rotación simple a la izquierda
        if (balance < -1 && getBalance(nodo.getDer()) <= 0) {
            BitacoraAplicación.agregaraccion("Se esta detectando un desbalance a la derecha.");
            return rotarIzquierda(nodo);
        }

        // Rotación izquierda-derecha
        if (balance > 1 && getBalance(nodo.getIzq()) < 0) {
            BitacoraAplicación.agregaraccion("Se esta detectando un desequilibrio, 1 hijo del subarbol izquierdo puede pertenecer al subarbol derecho.");
            nodo.setIzq(rotarIzquierda(nodo.getIzq()));
            return rotarDerecha(nodo);
        }

        // Rotación derecha-izquierda
        if (balance < -1 && getBalance(nodo.getDer()) > 0) {
            BitacoraAplicación.agregaraccion("Se esta detectando un desequilibrio, 1 hijo del subarbol derecho puede pertenecer al subarbol izquierdo.");
            nodo.setDer(rotarDerecha(nodo.getDer()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Método para encontrar el nodo con el valor mínimo
    private Nodo encontrarMinimo(Nodo nodo) {
        BitacoraAplicación.agregaraccion("Buscando nodo cuyo valor sea el menor de todo el árbol.");
        Nodo actual = nodo;
        while (actual.getIzq() != null) {
            BitacoraAplicación.agregaraccion("Relizando recorrido postOrden.");
            actual = actual.getIzq();
        }
        return actual;
    }
    
     // Método para borrar todo el árbol
    public void borrarArbol() {
        BitacoraAplicación.agregaraccion("Borrando todo el árbol.");
        raiz = null; // Elimina toda la estructura del árbol
    }

    // Métodos de recorrido (preOrden, inOrden, postOrden)
    public LinkedList preOrden() {
        BitacoraAplicación.agregaraccion("Empezando recorrido preOrden.");
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }

    private void preorden(Nodo aux, LinkedList recorrido) {
        BitacoraAplicación.agregaraccion("Relizando recorrido preOrden.");
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    public LinkedList inOrden() {
        BitacoraAplicación.agregaraccion("Empezando recorrido inOrder.");
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }

    private void inorden(Nodo aux, LinkedList recorrido) {
        BitacoraAplicación.agregaraccion("Relizando recorrido inOrder.");
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    public LinkedList postOrden() {
        BitacoraAplicación.agregaraccion("Empezando recorrido postOrden.");
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }

    private void postorden(Nodo aux, LinkedList recorrido) {
        BitacoraAplicación.agregaraccion("Relizando recorrido postOrden.");
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    // Método para verificar si un dato existe en el árbol
    public boolean existe(int dato) {
        BitacoraAplicación.agregaraccion("Verificando la existencia del valor "+dato+" dentro del árbol.");
        Nodo aux = raiz;
        while (aux != null) {
            BitacoraAplicación.agregaraccion("Valor encontrado.");
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                BitacoraAplicación.agregaraccion("Buscando en el subárbol derecho.");
                aux = aux.getDer();
            } else {
                BitacoraAplicación.agregaraccion("Buscando en el subárbol izquierdo.");
                aux = aux.getIzq();
            }
        }
        return false;
    }

    // Método para obtener el panel de dibujo del árbol
    public ArbolExpresionGrafico getdibujo(JScrollPane scrollPane, JPanel panel) {
        BitacoraAplicación.agregaraccion("Obteniendo el panel mostrador.");
        return new ArbolExpresionGrafico(this, scrollPane, panel);
    }

    // Método para repintar el árbol
    public void repintar(JPanel panel) {
        BitacoraAplicación.agregaraccion("Repintando el árbol.");
        BitacoraAplicación.agregaraccion("Limpiando el panel mostrador del árbol.");
        panel.removeAll(); // Limpia el panel
        ArbolExpresionGrafico dibujo = new ArbolExpresionGrafico(this, new JScrollPane(), panel);
        BitacoraAplicación.agregaraccion("Agregando el nuevo árbol al panel mostrador.");
        panel.add(dibujo); // Agrega el nuevo dibujo al panel
        BitacoraAplicación.agregaraccion("Revalidando el panel mostrador.");
        panel.revalidate(); // Revalida el panel
        BitacoraAplicación.agregaraccion("Repintando el panel mostrador.");
        panel.repaint(); // Repinta el panel
    }
  
    // Método para obtener la raíz del árbol
    public Nodo getRaiz() {
        BitacoraAplicación.agregaraccion("Obteniendo la raíz del árbol.");
        return raiz;
    }
    
    public BusquedaResultado buscarConPasos(int dato) {
        BitacoraAplicación.agregaraccion("Buscando el valor "+dato+" contando los pasos.");
    Nodo aux = raiz;
    int pasos = 0;
    while (aux != null) {
        pasos++;
        BitacoraAplicación.agregaraccion("Vamos por el paso #"+pasos+".");
        if (dato == aux.getDato()) {
            BitacoraAplicación.agregaraccion("Valor encontrado.");
            return new BusquedaResultado(true, pasos);
        } else if (dato > aux.getDato()) {
            BitacoraAplicación.agregaraccion("Buscando en el subarbol derecho.");
            aux = aux.getDer();
        } else {
            BitacoraAplicación.agregaraccion("Buscando en el subarbol izquierdo.");
            aux = aux.getIzq();
        }
    }
    return new BusquedaResultado(false, pasos);
}
    public Integer obtenerElementoEnPosicion(int posicion) {
        BitacoraAplicación.agregaraccion("Buscando el valor localizado en la posición "+posicion+".");
    LinkedList<Integer> inOrden = inOrden();
    if (posicion >= 0 && posicion < inOrden.size()) {
        return inOrden.get(posicion);
    }
    BitacoraAplicación.agregaraccion("Posición no localizada.");
    return null;
}
    // En la clase ArbolBB
    public int obtenerTamanio() {
        BitacoraAplicación.agregaraccion("Obteniendo tamaño con un recorrido InOrder.");
    return inOrden().size(); // Retorna el tamaño del recorrido InOrden
    }
    public boolean estaVacio() {
        BitacoraAplicación.agregaraccion("Se ha detectado que el árbol esta vacío.");
        return this.raiz == null;
    }
}