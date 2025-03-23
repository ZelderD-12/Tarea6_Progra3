package arbol;

import tarea_6.BitacoraAplicación;

public class ArbolBinarioNoEquilibrado extends ArbolBB {
private ArbolBB miArbol; // Árbol binario de búsqueda no equilibrado
    // Método para insertar un nodo sin equilibrar
    private Nodo insertarNoBalanceado(Nodo nodo, int dato) {
        BitacoraAplicación.agregaraccion("Iniciando inserción no balanceada.");
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato < nodo.getDato()) {
             BitacoraAplicación.agregaraccion("Buscando insertar el nuevo valor en el subárbol izquierdo de forma no equilibrada.");
            nodo.setIzq(insertarNoBalanceado(nodo.getIzq(), dato));
        } else if (dato > nodo.getDato()) {
            BitacoraAplicación.agregaraccion("Buscando insertar el nuevo valor en el subárbol derecho de forma no equilibrada.");
            nodo.setDer(insertarNoBalanceado(nodo.getDer(), dato));
        }

        return nodo;
    }
       // Sobrescribir el método buscar si es necesario
    public boolean buscar(Integer dato) {
        BitacoraAplicación.agregaraccion("Evaluando si es necesario sobreescribir la búsqueda.");
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        BitacoraAplicación.agregaraccion("Sobreescribiendo la búsqueda.");
        return buscarRecursivo(raiz, dato);
    }

    // Método auxiliar para buscar de manera recursiva
    private boolean buscarRecursivo(Nodo nodo, Integer dato) {
        BitacoraAplicación.agregaraccion("Iniciando búsqueda recursiva.");
        if (nodo == null) {
            BitacoraAplicación.agregaraccion("Valor nulo, búsqueda cancelada.");
            return false;
        }
        if (dato.equals(nodo.getDato())) {
            BitacoraAplicación.agregaraccion("Valor encontrado con búsqueda recursiva.");
            return true;
        } else if (dato < nodo.getDato()) {
            BitacoraAplicación.agregaraccion("Buscando recursivamente el valor en el subarbol izquierdo.");
            return buscarRecursivo(nodo.getIzq(), dato);
        } else {
             BitacoraAplicación.agregaraccion("Buscando recursivamente el valor en el subarbol derecho.");
            return buscarRecursivo(nodo.getDer(), dato);
        }
    }
    // Sobrescribir el método agregar para evitar el equilibrado
    @Override
    public boolean agregar(int dato) {
        BitacoraAplicación.agregaraccion("Sobreescribiendo la inserción para evitar el equilibrado.");
        raiz = insertarNoBalanceado(raiz, dato);
        return true;
    }
    
}