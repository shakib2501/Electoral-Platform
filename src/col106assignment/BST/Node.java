package col106assignment.BST;

public class Node<T extends Comparable<T> , E> {
    private T key;
    private E value;
    Node<T,E> left, right;
    Node(T key, E value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public T getKey() {
        return this.key;
    }
    public E getValue() {
        return this.value;
    }
    public Node getLeft() {
        return this.left;
    }
    public Node getRight() {
        return this.right;
    }
    public void setKey(T key) {
        this.key = key;
    }
    public void setValue(E value) {
        this.value = value;
    }
}
