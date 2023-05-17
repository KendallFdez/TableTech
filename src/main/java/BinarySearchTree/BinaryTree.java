package BinarySearchTree;

/**
 * BinaryTree es un donde se almacena informacion de las personas
 * @param <T> Es un tipo de dato que puede variar dependiendo de lo que se le asigne
 * @author Kendall Fernández
 */
public class BinaryTree<T extends Comparable<? super T>> {
    /**
     * La raiz del binary tree
     */
    private Nodo<T> root;

    /**
     * Retorna la raiz del binary tree
     * @return La raiz
     */
    public Nodo<T> getRoot() {
        return root;
    }

    /**
     * Inicia la raiz en nulo
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Verifica la raiz del binary tree para ver si es nula
     * @return Un booleano de si el arbol es nulo
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Retorna un valor booleano sobre si el arbol contiene cierto nodo especificanodole que empiece a recorrer desde la raiz
     * @param element El valor del nodo
     * @return El booleano
     */
    public boolean contains(T element) {
        return this.contains(element, this.root);
    }

    /**
     * Retorna un valor booleano sobre si el arbol contiene cierto nodo
     * @param element El valor del nodo que verifica
     * @param node El nodo desde donde se empiza a recorrer
     * @return El booleano
     */
    private boolean contains(T element, Nodo<T> node) {
        if (node == null) {
            return false;
        } else {
            int compareResult = element.compareTo(node.element);

            if (compareResult < 0) {
                return contains(element, node.left);
            } else if (compareResult > 0) {
                return contains(element, node.right);
            } else {
                return true;
            }
        }
    }
    /**
     * Buscar el nodo con menor valor
     * @return Un metodo igual pero desde la raiz
     */
    public T findMin() {
        if (this.isEmpty()) {
            return null;
        }
        return findMin(this.root);
    }
    /**
     * Buscar el nodo con menor valor
     * @param node El nodo donde queremos que empice a recorrer el arbol para buscar
     * @return El valor de el nodo
     */
    private T findMin(Nodo<T> node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node.getElement();
    }
    /**
     * Buscar el nodo con mayor valor
     * @return Un metodo igual pero desde la raiz
     */
    public T findMax() {
        if (this.isEmpty()) {
            return null;
        }
        return findMax(this.root);
    }
    /**
     * Buscar el nodo con mayor valor
     * @param node El nodo donde queremos que empice a recorrer el arbol para buscar
     * @return El valor de el nodo
     */
    private T findMax(Nodo<T> node) {
        if (node.right != null) {
            return findMax(node.right);
        }
        return node.getElement();
    }
    /**
     * Inserta un nuevo nodo al binary tree pero especificandole desde donde
     * @param element Lo que queremos que contega el nuevo nodo
     */
    public void insert(T element) {
        this.root = this.insert(element, this.root);
    }
    /**
     * Inserta un nuevo nodo al binary tree
     * @param element Lo que queremos que contega el nuevo nodo
     * @param current El nodo donde queremos que empice a recorrer el arbol
     * @return El nodo donde se aplica una recursion para recorrer
     */
    public Nodo<T> insert(T element, Nodo<T> current) {
        if (current == null) {
            return new Nodo<T>(element, null, null);
        }
        int compareResult = element.compareTo(current.element);

        if (compareResult < 0) {
            current.left = this.insert(element, current.left);
        } else if (compareResult > 0) {
            current.right = this.insert(element, current.right);
        }
        return current;
    }
    /**
     * Elimina un nuevo nodo al binary tree pero especificandole desde donde
     * @param element El valor del nodo a eliminar
     */
    public void remove(T element) {
        this.root = this.remove(element,this.root);
    }

    /**
     * Elimina un nuevo nodo al binary tree
     * @param element El valor del nodo a eliminar
     * @param node El nodo donde queremos que empice a recorrer
     * @return EL nodo eliminado
     */
    private Nodo<T> remove(T element,Nodo<T> node){
        if(node==null) {
            return node;
        }
        int compareResult = element.compareTo(node.element);

        if(compareResult < 0){
            node.left = remove(element,node.left);
        }else if(compareResult>0){
            node.right= remove(element,node.right);
        }else if(node.left!=null && node.right!=null){
            node.element= findMin(node.right);
            node.right= remove(node.element,node.right);
        }else{
            node=node.left!=null ? node.left : node.right;
        }
        return node;
    }
}

