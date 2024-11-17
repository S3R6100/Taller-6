/**
 * Constructor que inicializa un nodo con el dato dado.
 * El atributo "siguiente" se inicializa como null, indicando que no hay conexión con otro nodo al momento de creación.
 */

public class Nodo {
    public int dato;
    public  Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}