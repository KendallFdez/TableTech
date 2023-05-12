package BinarySearchTree;

public class Nodo<T extends Comparable<? super T>> {
    public T getElement() {
        System.out.println(element);
        return element;
    }
    public T getLeft() {
        System.out.println(left.element);
        return left.element;
    }
    public T getRight() {
        System.out.println(right.element);
        return right.element;
    }
    T element;
    Nodo<T> left;
    Nodo<T> right;
    public Nodo(T element) {
        this(element, null, null);
    }
    public Nodo(T element, Nodo < T > left, Nodo < T > right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}