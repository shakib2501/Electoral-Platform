package col106assignment.Heap;

import java.util.LinkedList;
import java.util.Queue;

public class Heap<T extends Comparable<T>, E> implements HeapInterface<T,E> {
    private Pair<T,E>[] array;
    private int size;

    /**
     * @param key
     * @param value
     */
    public Heap(){
        size = 1;
        array = new Pair[size];
    }
    public Heap(T key, E value) {
        size = 1;
        array = new Pair[size];
        array[0] = new Pair<>(key, value);
    }
    public void insert(T key, E value) {
        if(this.size == this.array.length){
            if(array[size-1] == null){
                array[size-1] = new Pair<>(key, value);
                return;
            }
            else {
                Pair<T, E>[] temparray = new Pair[size * 2];
                for (int i = 0; i < size; i++) {
                    temparray[i] = array[i];
                }
                array = temparray;
            }
        }
        array[size] = new Pair<>(key, value);
        balanceUp(this.array, this.size);
        size++;
    }
    private void balanceUp(Pair<T,E>[] arr, int index){
        if(index == 0){
            return;
        }
        if(arr[index].getKey().compareTo(arr[(index-1)/2].getKey()) <= 0){
            return;
        }
        Pair<T,E> temp = arr[index];
        arr[index] = arr[(index-1)/2];
        arr[(index-1)/2] = temp;
        balanceUp(arr, (index-1)/2);
    }
    private void balanceDown(Pair<T,E>[] arr, int index){
        if(2*index + 2 > this.size) return;
        if(2 * index + 1 > this.size) return;
        if(arr[index].getKey().compareTo(arr[2*index+2].getKey()) < 0 && arr[index].getKey().compareTo(arr[2*index+1].getKey()) < 0){
            if(arr[2*index+2].getKey().compareTo(arr[2*index+1].getKey()) < 0){
                Pair<T,E> temp = arr[index];
                arr[index] = arr[2*index+1];
                arr[2*index+1] = temp;
                balanceDown(arr, 2*index+1);
            }
            else{
                Pair<T,E> temp = arr[index];
                arr[index] = arr[2*index+2];
                arr[2*index+2] = temp;
                balanceDown(arr, 2*index+2);
            }
        }
        else if(arr[index].getKey().compareTo(arr[2*index+2].getKey()) < 0){
            Pair<T,E> temp = arr[index];
            arr[index] = arr[2*index+2];
            arr[2*index+2] = temp;
            balanceDown(arr, 2*index+2);
        }
        else if(arr[index].getKey().compareTo(arr[2*index+1].getKey()) < 0){
            Pair<T,E> temp = arr[index];
            arr[index] = arr[2*index+1];
            arr[2*index+1] = temp;
            balanceDown(arr, 2*index+1);
        }
    }

    /**
     * @param key
     * @param value
     */
    private int search(T key, int index) {
        if(index >= size || index < 0) return -1;
        if(array[index].getKey().compareTo(key) == 0) return index;
        int temp = search(key, 2*index + 1);
        if(temp < 0){
            return search(key, 2*index+2);
        }
        else return temp;
    }

    public void increaseKey(T key, E value) {
        int temp = search(key, 0);
        if(temp < 0) return;
        array[temp].setValue(value);
    }

    /**
     * @param key
     * @return
     */
    public E extractMax() {
        if(size == 0) return null;
        else return array[0].getValue();
    }

    /**
     *
     */
    public void delete(T key) {
        int temp = search(key, 0);
        if(temp < 0) return;
        Pair<T,E> lastVal = array[size-1];
        array[size-1] = null;
        array[temp] = lastVal;
        size--;
        balanceDown(this.array,temp);
    }

    /**
     *
     */
    public void printHeap() {
        Queue<Pair<T,E>> queue = new LinkedList<>();
        int idx = 0;
        queue.add(array[idx]);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                Pair<T,E> pair = queue.poll();
                System.out.print("["+pair.getKey()+", " + pair.getValue() +"]");
                if(2*idx+1 < this.size){
                    queue.add(array[2*idx+1]);
                }
                if(2*idx+2 < this.size){
                    queue.add(array[2*idx+2]);
                }
                idx++;
            }
            System.out.println();
        }
    }
}
