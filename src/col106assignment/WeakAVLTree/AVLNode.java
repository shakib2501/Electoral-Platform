package col106assignment.WeakAVLTree;

public class AVLNode<T extends Comparable<T>, E> {
    T key;
    E value;
    AVLNode<T, E> parent;
    AVLNode<T, E> left;
    AVLNode<T, E> right;
    public AVLNode(T key, E value, AVLNode<T, E> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}
