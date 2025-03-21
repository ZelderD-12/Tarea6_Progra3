package arbol;

public class ArbolBinarioNoEquilibrado extends ArbolBB {
private ArbolBB miArbol; // Árbol binario de búsqueda no equilibrado
    // Método para insertar un nodo sin equilibrar
    private Nodo insertarNoBalanceado(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato < nodo.getDato()) {
            nodo.setIzq(insertarNoBalanceado(nodo.getIzq(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDer(insertarNoBalanceado(nodo.getDer(), dato));
        }

        return nodo;
    }
       // Sobrescribir el método buscar si es necesario
    public boolean buscar(Integer dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo.");
        }
        return buscarRecursivo(raiz, dato);
    }

    // Método auxiliar para buscar de manera recursiva
    private boolean buscarRecursivo(Nodo nodo, Integer dato) {
        if (nodo == null) {
            return false;
        }
        if (dato.equals(nodo.getDato())) {
            return true;
        } else if (dato < nodo.getDato()) {
            return buscarRecursivo(nodo.getIzq(), dato);
        } else {
            return buscarRecursivo(nodo.getDer(), dato);
        }
    }
    // Sobrescribir el método agregar para evitar el equilibrado
    @Override
    public boolean agregar(int dato) {
        raiz = insertarNoBalanceado(raiz, dato);
        return true;
    }
    
}