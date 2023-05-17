package AVLTree;

import lombok.Data;
import lombok.NonNull;


@Data
/**
 *La clase nodo se encarga de guardar datos que se usan en el árbol
 * @param <T> Es un tipo de dato que puede variar dependiendo de lo que se le asigne
 * @author Kendall Fernández
 */
public class AVLNode<T extends Comparable<T>> {

    @NonNull
    /**
     * Data es la información que guardamos
     */
    private T data;
    /**
     * Height es la el nivel de diferencia entre el node en que estamos y la raiz
     */
    private int height = 1;
    /**
     * Leftchild es el hijo izquierdo y se conectan para poder recorrer el arbol
     */
    private AVLNode<T> leftChild;
    /**
     * Rightchild es el hijo derecho y se conectan para poder recorrer el arbol
     */
    private AVLNode<T> rightChild;

}
