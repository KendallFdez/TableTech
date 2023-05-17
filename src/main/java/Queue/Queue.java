package Queue;

import LinkedList.ListaEnlazada;
import LinkedList.Nodo;

public class Queue{
    private ListaEnlazada queueList = new ListaEnlazada();
    private Nodo head;
    private Nodo tail;

    /**
     * Método constructor para la clase
     */
    public Queue(){
        this.head = null;
        this.tail = null;
    }

    /**
     * Método para agregar un elemento a la cola
     * @param element
     * @param element2
     */
    public void enqueue(String element, String element2){
        this.queueList.insertLast(element, element2);
    }

    /**
     * Método para eliminar el elemento al frente de la cola
     * @return
     */
    public Object dequeue(){
        return this.queueList.deleteFirst();
    }

    /**
     * Método para ver el primer elemento de la cola sin eliminarlo
     * @return
     */
    public Object peek(){
        return this.queueList.getHead();
    }
}
