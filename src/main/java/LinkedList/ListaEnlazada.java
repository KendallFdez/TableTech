package LinkedList;

/**
 * Esta clase define una lista enlazada compuesta por nodos
 */
public class ListaEnlazada {
    private Nodo head;
    private Nodo last;
    private int size;

    /**
     * Metodo contructor para la clase
     */
    public ListaEnlazada(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Este metodo retorna si la lista es vacio o no
     * @return Valor booleano si la lista esta vacia o no
     */
    public boolean isEmpty(){
        return this.head ==  null;
    }

    /**
     * Este metodo retorna el tamaño de la lista
     * @return Tamaño de la lista
     */
    public int size() {
        return this.size;
    }

    /**
     * Este metodo recibe un objeto y lo inserta como primer elemento de la lista
     * @param data Nodo con valor objeto
     */
    public void insertFirst(Object data){
        Nodo newNode = new Nodo(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    /**
     * Este metodo recibe un objeto y lo inserta como utlimo elemento de la lista
     * @param data Nodo con valor objeto
     */
    public void insertLast(Object data){
        Nodo newNode = new Nodo(data);
        newNode.next = null;
        if (isEmpty()){
            this.head = newNode;
            this.size++;
        }
        else{
            Nodo temp = new Nodo(null);
            temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            this.size ++;
        }
    }

    /**
     * Este metodo elimina el primer elemento de una lista
     * @return Lista sin el primer nodo
     */
    public Nodo deleteFirst(){
        if (this.head != null){
            Nodo temp = this.head;
            this.head = this.head.next;
            this.size--;
            return temp;
        }
        else{
            return null;
        }
    }

    /**
     * Este metodo hace un print de la lista actual
     */
    public void displayList(){
        Nodo current = this.head;
        while (current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    /**
     * Este metodo recibe un valor, lo busca en la lista y lo retorna
     * @param searchValue Elemento a buscar en la lista
     * @return Elemento encontrado en la lista
     */
    public Nodo find (Object searchValue){
        Nodo current = this.head;
        while (current != null){
            if (current.getData().equals(searchValue)){
                return current;
            }
            else{
                current = current.getNext();
            }
        }
        return null;
    }

    /**
     * Este metodo elimina un elemento definido en la lista
     * @param searchValue Elemento a eliminar de la lista
     * @return Lista sin el elemento definido
     */
    public Nodo delete (Object searchValue){
        Nodo current = this.head;
        Nodo previous = this.head;
        while (current != null){
            if (current.getData().equals(searchValue)){
                if (current == this.head){
                    this.head = this.head.getNext();
                }
                else{
                    previous.setNext(current.getNext());
                }
            }
            else{
                previous = current;
                current = current.getNext();
            }
            return current;
        }
        return null;
    }
}

