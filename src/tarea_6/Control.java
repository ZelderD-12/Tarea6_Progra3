package tarea_6;

import Modelo.modelo;
import arbol.SimuladorArbolBinario;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Control extends Thread{
    final modelo modelo;
    private int cantidadaciertos = 0;
    final SimuladorArbolBinario simulador;
    final Random r = new Random();
    final JScrollPane spane;
    final JPanel pane;
    private Integer numeroEspecifico = null; 

    public Control(modelo modelo, JScrollPane spane, JPanel pane) {
        simulador = new SimuladorArbolBinario();
        this.modelo = modelo;
        this.spane = spane;
        this.pane = pane;
    }
    
    // Método para insertar un número específico primero
    public void insertarPrimero(int numero) {
        this.numeroEspecifico = numero;
    }

    // Método para insertar un número en el árbol
    public void insertar(int numero) {
        if (numeroEspecifico != null) {
            // Si hay un número específico, insertarlo primero
            simulador.insertarPrimero(numeroEspecifico, numero);
            numeroEspecifico = null; // Reiniciar la variable después de usarla
        } else {
            // Si no hay un número específico, insertar el número normal
            simulador.insertar(numero);
        }

        // Actualizar la vista del árbol
        simulador.getDibujo(this.spane, this.pane);
    }

    // Método para eliminar un número del árbol
    public void eliminar(int numero) {
        simulador.eliminar(numero);

        // Actualizar la vista del árbol
        simulador.getDibujo(this.spane, this.pane);
    }

    // Método para buscar un número en el árbol
    public boolean buscar(int numero) {
        return simulador.buscarNumero(numero);
    }

    // Método para realizar el recorrido PreOrden
    public String obtenerRecorridoPreorden() {
        // PreOrden
        long startTime = System.currentTimeMillis(); // Marca el tiempo de inicio

        // Ejecutamos el recorrido preorden y lo mostramos
        String recorridoPreorden = simulador.preOrden(); // Llamamos al método preOrden
        System.out.println(recorridoPreorden); // Muestra el recorrido en consola

        long endTime = System.currentTimeMillis(); // Marca el tiempo de finalización

        // Calculamos el tiempo transcurrido
        long duration = endTime - startTime;

        // Convertimos el tiempo en minutos, segundos y milisegundos
        long minutes = (duration / 1000) / 60;
        long seconds = (duration / 1000) % 60;
        long milliseconds = duration % 1000;

        // Mostramos el tiempo transcurrido
        System.out.println("Tiempo de ejecución del preorden: " + minutes + " minutos " + seconds + " segundos " + milliseconds + " milisegundos.\t");

        return recorridoPreorden + "\n\nTiempo de ejecución: " + minutes + " minutos " + seconds + " segundos " + milliseconds + " milisegundos.";
    }
    
    // Método para realizar el recorrido InOrden
    public String obtenerRecorridoInorden() {
        // InOrden
        long startTime = System.currentTimeMillis(); // Marca el tiempo de inicio

        // Ejecutamos el recorrido inorden y lo mostramos
        String recorridoInorden = simulador.inOrden(); // Llamamos al método inOrden
        System.out.println(recorridoInorden); // Muestra el recorrido en consola

        long endTime = System.currentTimeMillis(); // Marca el tiempo de finalización

        // Calculamos el tiempo transcurrido
        long duration = endTime - startTime;

        // Convertimos el tiempo en minutos, segundos y milisegundos
        long minutes = (duration / 1000) / 60;
        long seconds = (duration / 1000) % 60;
        long milliseconds = duration % 1000;

        // Mostramos el tiempo transcurrido
        System.out.println("Tiempo de ejecución del inorden: " + minutes + " minutos " + seconds + " segundos " + milliseconds + " milisegundos.\t");

        return recorridoInorden + "\n\nTiempo de ejecución: " + minutes + " minutos " + seconds + " segundos " + milliseconds + " milisegundos.";
    }
    
    // Método para realizar el recorrido PostOrden
    public String obtenerRecorridoPostorden() {
        // PostOrden
        long startTime = System.currentTimeMillis(); // Marca el tiempo de inicio

        // Ejecutamos el recorrido postorden y lo mostramos
        String recorridoPostorden = simulador.postOrden(); // Llamamos al método postOrden
        System.out.println(recorridoPostorden); // Muestra el recorrido en consola

        long endTime = System.currentTimeMillis(); // Marca el tiempo de finalización

        // Calculamos el tiempo transcurrido
        long duration = endTime - startTime;

        // Convertimos el tiempo en minutos, segundos y milisegundos
        long minutes = (duration / 1000) / 60;
        long seconds = (duration / 1000) % 60;
        long milliseconds = duration % 1000;

        // Mostramos el tiempo transcurrido
        System.out.println("Tiempo de ejecución del preorden: " + minutes + " minutos " + seconds + " segundos " + milliseconds + " milisegundos.\t");

        return recorridoPostorden + "\n\nTiempo de ejecución: " + minutes + " minutos " + seconds + " segundos " + milliseconds + " milisegundos.";
    }
    
       @Override
       public void run(){
           
       }
    
}
