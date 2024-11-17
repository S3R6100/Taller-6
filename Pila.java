import javax.swing.*;

public class Pila {
    private Nodo cima;
    private int tamano;

    /**
     * Constructor que inicializa una pila vacía.
     * La cima se establece en null y el tamaño inicial es 0.
     */
    public Pila() {
        cima = null;
        tamano = 0;
    }

    /**
     * Método que apila un nuevo dato en la pila.
     */
    public void apilar(int dato,JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
        actualizarTextArea(textArea);
    }


    /**
     * Método que desapila el elemento en la cima de la pila.
     */
    public int desapilar(JTextArea textArea) {

        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
            return -1;
        }
        int dato = cima.dato;
        cima = cima.siguiente;
        tamano--;
        actualizarTextArea(textArea);
        return dato;
    }

    /**
     * Método que verifica si la pila está vacía.
     */
    public boolean estaVacia() {
        return cima == null;
    }


    /**
     * Método que muestra el contenido actual de la pila en un JTextArea.
     */
    public void mostrarPila(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La pila está vacía.");
        } else {
            StringBuilder pilaStr = new StringBuilder();
            Nodo actual = cima;
            while (actual != null) {
                pilaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(pilaStr.toString());
        }
    }

    /**
     * Método privado para actualizar la representación de la pila en un JTextArea.
     */
    private void actualizarTextArea(JTextArea textArea) {
        mostrarPila(textArea);
    }


    /**
     * Método que busca un valor en la pila utilizando búsqueda lineal.
     */
    public int buscarLineal(int dato, JTextArea textArea){
        Nodo actual = cima;
        int posicion = 0;
        while (actual!= null ){
            if (actual.dato==dato){
                return posicion;
            }
            posicion++;
            actual=actual.siguiente;
        }
        return  -1;
    }

}
