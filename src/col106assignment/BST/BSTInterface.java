package col106assignment.BST;

public interface BSTInterface<T extends Comparable, E> {
    void insert(T key, E value);
    void update(T key, E value);
    void delete(T key);
    void printBST(); // Print the keys according to level order traversal of BST
}
