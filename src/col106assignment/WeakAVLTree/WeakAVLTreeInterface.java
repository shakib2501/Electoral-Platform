package col106assignment.WeakAVLTree;

public interface WeakAVLTreeInterface<T extends Comparable<T>, E> {
    public void insert(T key, E value);
    public void delete(T key);
    public boolean search(T key);
    public void searchRange(T key, E value);
}
