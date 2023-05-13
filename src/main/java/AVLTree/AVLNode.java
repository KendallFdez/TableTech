package AVLTree;

import lombok.Data;
import lombok.NonNull;

@Data
public class AVLNode<T extends Comparable<T>> {

    @NonNull
    private T data;

    private int height = 1;

    private AVLNode<T> leftChild;
    private AVLNode<T> rightChild;

}
