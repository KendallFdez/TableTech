package AVLTree;

public interface Tree<T extends Comparable<T>> {

    /**
     * Un metodo abstracto para insertar
     * @param data El dato del nodo a insertar
     * @return De momento no retorna nada
     */
    Tree<T> insert(T data);

    /**
     * Un metodo abstracto para eliminar
     * @param data El dato del nodo a eliminar
     */
    void delete(T data);

    /**
     * Un metodo abstracto para recorrer el arbol
     */
    void traverse();

    /**
     * Un metodo abstracto para encontrar el valor mayor
     * @return De momento no retorna nada
     */
    T getMax();
    /**
     * Un metodo abstracto para encontrar el valor menor
     * @return De momento no retorna nada
     */
    T getMin();

    /**
     * Un metodo abstracto para ver si el arbol esta vacio
     * @return De momento no retorna nada
     */
    boolean isEmpty();

}