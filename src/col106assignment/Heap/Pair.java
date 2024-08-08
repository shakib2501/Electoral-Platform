package col106assignment.Heap;

public class Pair<T extends Comparable<T>, E> {
    private T key;
    private E value;
    public Pair(){
        key = null;
        value = null;
    }
    public Pair(T first, E second) {
        this.key = first;
        this.value = second;
    }
    public T getKey() {
        return key;
    }
    public E getValue() {
        return value;
    }
    public void setKey(T key) {
        this.key = key;
    }
    public void setValue(E value) {
        this.value = value;
    }
}
