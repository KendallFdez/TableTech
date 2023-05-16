package LinkedList;

/**
 * Esta clase define nodos para una lista enlazada
 */
public class Nodo {
    public String data1;
    public String data2;
    public Nodo next;

    /**
     * Metodo constructor para la clase
     * @param data1 Elemento que contiene el nodo
     * @param data2 Elemento que contiene el nodo
     */
    public Nodo(String data1, String data2){
        this.next = null;
        this.data1 = data1;
        this.data2 = data2;
    }

    /**
     * Este metodo retorna el elemento de un nodo
     * @return Contenido de un nodo
     */
    public String getData1(){
        return this.data1;
    }

    /**
     * Este metodo retorna el elemento de un nodo
     * @return Contenido de un nodo
     */
    public String getData2(){
        return this.data2;
    }

    /**
     * Este metodo define el contenido de una nodo
     * @param data Es el elemento contenido en un nodo
     */
    public void setData(Object data){
        this.data1 = data1;
    }

    /**
     * Este metodo retorna el nodo siguiente en una lista
     * @return Siguiente nodo en una lista
     */
    public Nodo getNext(){
        return this.next;
    }

    /**
     * Este metodo define el nodo siguiente en una lista
     * @param node Es el nodo siguiente en una lista
     */
    public void setNext(Nodo node){
        this.next = node;
    }
}
