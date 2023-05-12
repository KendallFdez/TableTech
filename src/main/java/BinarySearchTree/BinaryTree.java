package BinarySearchTree;

public class BinaryTree<T extends Comparable<? super T>> {
    private Nodo<T> root;

    public Nodo<T> getRoot() {
        return root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(T element) {
        return this.contains(element, this.root);
    }

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
    public T findMin() {
        if (this.isEmpty()) {
            return null;
        }
        return findMin(this.root);
    }
    private T findMin(Nodo<T> node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node.getElement();
    }
    public T findMax() {
        if (this.isEmpty()) {
            return null;
        }
        return findMax(this.root);
    }
    private T findMax(Nodo<T> node) {
        if (node.right != null) {
            return findMax(node.right);
        }
        return node.getElement();
    }
    public void insert(T element) {
        this.root = this.insert(element, this.root);
    }
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
    public void remove(T element) {
        this.root = this.remove(element,this.root);
    }
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

