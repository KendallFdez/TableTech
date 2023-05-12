package BinarySearchTree;



public class Main {
    public static void main(String[] args) {
        BinaryTree arbol = new BinaryTree();
        arbol.insert( 5);
        arbol.insert(2);
        arbol.insert(12);
        arbol.insert(-4);
        arbol.insert(3);
        arbol.insert(9);
        arbol.insert(21);
        arbol.insert(19);
        arbol.insert(25);
        System.out.println(arbol.contains(12));
        arbol.remove(12);
        System.out.println(arbol.contains(12));
        System.out.println(arbol.contains(19));
        arbol.getRoot().getRight();
    }
}