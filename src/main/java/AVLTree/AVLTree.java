package AVLTree;

/**
 * AVLTree es un donde se almacena informacion de los platillos
 * @param <T> Es un tipo de dato que puede variar dependiendo de lo que se le asigne
 * @author Kendall Fernández
 */
public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    /**
     * La raiz del avl tree
     */
    private AVLNode<T> root;

    /**
     * Inserta un nuevo nodo al avl tree pero especificandole desde donde
     * @param data Lo que queremos que contega el nuevo nodo
     * @return No retorna nada
     */
    @Override
    public Tree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }

    /**
     * Inserta un nuevo nodo al avl tree
     * @param data Lo que queremos que contega el nuevo nodo
     * @param node El nodo donde queremos que empice a recorrer el arbol
     * @return Una rotacion en caso de que sea necesaria
     */
    private AVLNode<T> insert(T data, AVLNode<T> node) {
        if (node == null) {
            return new AVLNode<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    /**
     * Elimina un nodo al avl tree pero especificandole desde donde
     * @param data El valor del nodo a eliminar
     */
    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    /**
     * Elimina un nodo al avl tree
     * @param data El valor del nodo a eliminar
     * @param node El nodo donde queremos que empice a recorrer el arbol
     * @return Una rotacion en caso de que sea necesaria
     */
    private AVLNode<T> delete(T data, AVLNode<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        } else {
            // One Child or Leaf Node (no children)
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            // Two Children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    /**
     * Recorre el arbol con InOrder
     */
    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    /**
     * Recorre el arbol con InOrder
     * @param node El nodo donde queremos que empice a recorrer el arbol
     */
    private void traverseInOrder(AVLNode<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
            traverseInOrder(node.getRightChild());
        }
    }

    /**
     * Buscar el nodo con mayor valor
     * @return Un metodo igual pero desde la raiz
     */
    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    /**
     * Buscar el nodo con mayor valor
     * @param node El nodo donde queremos que empice a recorrer el arbol para buscar
     * @return El valor de el nodo
     */
    private T getMax(AVLNode<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }
    /**
     * Buscar el nodo con menor valor
     * @return Un metodo igual pero desde la raiz
     */
    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }
    /**
     * Buscar el nodo con menor valor
     * @param node El nodo donde queremos que empice a recorrer el arbol para buscar
     * @return El valor de el nodo
     */
    private T getMin(AVLNode<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    /**
     * Se encarga de verficar si la raiz es nula
     * @return Un booleano si el arbol se esta vacio
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Se encarga decidir la rotacion necesaria
     * @param node El nodo donde se necesita la rotacion
     * @return La rotacion que se necesita
     */
    private AVLNode<T> applyRotation(AVLNode<T> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    /** Hace una rotacion hacia la derecha
     * @param node El nodo donde se necesita la rotacion
     * @return EL nodo que se roto
     */
    private AVLNode<T> rotateRight(AVLNode<T> node) {
        AVLNode<T> leftNode = node.getLeftChild();
        AVLNode<T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }
    /** Hace una rotacion hacia la izquierda
     * @param node El nodo donde se necesita la rotacion
     * @return EL nodo que se roto
     */
    private AVLNode<T> rotateLeft(AVLNode<T> node) {
        AVLNode<T> rightNode = node.getRightChild();
        AVLNode<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    /**
     * Actualiza la altua de un nodo
     * @param node El nodo que se actualiza
     */
    private void updateHeight(AVLNode<T> node) {
        int maxHeight = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );
        node.setHeight(maxHeight + 1);
    }

    /**
     * Indica el indice de balanceo de un nodo
     * @param node EL nodo del que se indica
     * @return El indice de balanceo
     */
    private int balance(AVLNode<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    /**
     * Indica la altua de un nodo
     * @param node El nodo del que se indica
     * @return La altura del nodo
     */
    private int height(AVLNode<T> node) {
        return node != null ? node.getHeight() : 0;
    }

}
