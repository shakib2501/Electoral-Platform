package col106assignment.Heap;

public interface HeapInterface<T extends Comparable, E> {
    void insert(T key, E value);
    void increaseKey(T key, E value);
    E extractMax();
    void delete(T key);
    void printHeap();
}
