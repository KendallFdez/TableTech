package BinarySearchTree;
/**
 * El nodo que usa el binary tree para guardar información
 * @param <T> Es un tipo de dato que puede variar dependiendo de lo que se le asigne
 * @author Kendall Fernández
 */
public class Nodo<T extends Comparable<? super T>> {
    /**
     * Retornar el valor del nodo
     * @return  El valor del nodo
     */
    public T getElement() {
        System.out.println(element);
        return element;
    }

    /**
     * Retorna el valor del nodo izquierdo
     * @return El valor del nodo izquierdo
     */
    public T getLeft() {
        System.out.println(left.element);
        return left.element;
    }
    /**
     * Retorna el valor del nodo derecho
     * @return El valor del nodo derecho
     */
    public T getRight() {
        System.out.println(right.element);
        return right.element;
    }

    /**
     * Cambiar el valor del nodo
     * @param element El nuevo valor del nodo
     */
    public void setElement(T element) {
        this.element = element;
        System.out.println(this.element);
    }

    /**
     * Cambia el apuntador del hijo izquierdo
     * @param left
     */
    public void setLeft(Nodo<T> left) {
        this.left = left;
        System.out.println(this.left.getElement());
    }
    /**
     * Cambia el apuntador del derecho
     * @param right
     */
    public void setRight(Nodo<T> right) {
        this.right = right;
        System.out.println(this.right.getElement());
    }

    /**
     * El valor del nodo
     */
    T element;
    /**
     * El hijo izquierdo
     */
    Nodo<T> left;
    /**
     * El hijo derecho
     */
    Nodo<T> right;

    /**
     * Inicia el nodo con un elemnto
     * @param element EL elemento con el que se inicia
     */
    public Nodo(T element) {
        this(element, null, null);
    }

    /**
     * Inicia el nodo con un elemnto y con apuntadores a los hijos
     * @param element EL elemento con el que se inicia
     * @param left Apuntador al hijo izquierdo
     * @param right Apuntador al hijo derecho
     */
    public Nodo(T element, Nodo < T > left, Nodo < T > right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}