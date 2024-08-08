//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import col106assignment.BST.BST;
import col106assignment.Heap.Heap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello there");
        BST<Integer,Integer> bst = new BST<>();
        bst.insert(1,3);
//        bst.insert(3,4);
        bst.insert(2,5);
        bst.insert(3,6);
        bst.printBST();
        bst.update(3,90);
        System.out.println("After updating");
        bst.printBST();
        System.out.println("After deleting");
        bst.delete(2);
        bst.printBST();
        Heap<Integer,Integer> heap = new Heap<>();
//        System.out.println(heap.extractMax());
        heap.insert(8,9);
        heap.insert(9,10);
        System.out.println(heap.extractMax());
        heap.insert(10,11);
        heap.insert(11,12);
        heap.insert(1,3);
        heap.insert(3,4);
        heap.increaseKey(11,50);
        heap.insert(2,5);
        heap.insert(5,6);
        heap.insert(6,7);
        heap.insert(7,8);
        System.out.println(heap.extractMax());
        heap.printHeap();
        heap.delete(11);
        System.out.println("After deleting 11");
        heap.printHeap();
        System.out.println(heap.extractMax());
        heap.increaseKey(10,66);
        heap.delete(1);
        System.out.println("After deleting 1");
        heap.printHeap();
        heap.delete(10);
        System.out.println(heap.extractMax());
        heap.delete(3);
        System.out.println("After deleting 3");
        heap.printHeap();
    }
}