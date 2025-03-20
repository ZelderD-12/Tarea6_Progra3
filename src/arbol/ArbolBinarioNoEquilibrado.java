package arbol;

public class ArbolBinarioNoEquilibrado extends ArbolBB {

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

    // Sobrescribir el método agregar para evitar el equilibrado
    @Override
    public boolean agregar(int dato) {
        raiz = insertarNoBalanceado(raiz, dato);
        return true;
    }
}