package col106assignment.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>, E> implements BSTInterface<T,E> {
    private Node<T,E> root;
    public BST() {
        root = null;
    }
    public BST(T key, E value) {
        root = new Node<T,E>(key, value);
    }
    public void insert(T key, E value) {
        if(this.root == null) {
            this.root = new Node(key,value);
            return;
        }
        Node<T,E> current = this.root;
        while(current != null) {
            if(key.compareTo(current.getKey()) > 0){
                if(current.right!= null) current = current.right;
                else{
                    Node<T,E> newNode = new Node(key,value);
                    current.right = newNode;
                    break;
                }
            }
            else if(key.compareTo(current.getKey()) < 0){
                if(current.left!= null) current = current.left;
                else{
                    Node<T,E> newNode = new Node(key,value);
                    current.left = newNode;
                    break;
                }
            }
        }
    }

    public void update(T key, E value) {
        if(root == null) {
            return;
        }

        Node<T,E> current = searchKey(this.root, key);
        if(current == null) {
            return;
        }
        else{
            current.setValue(value);
        }
//        while(current != null) {
//            if(key.compareTo(current.getKey()) == 0){
//                current.setValue(value);
//                break;
//            }
//            else if(key.compareTo(current.getKey()) > 0){
//                if(current.right!= null) current = current.right;
//            }
//            else if(key.compareTo(current.getKey()) < 0){
//                if(current.left!= null) current = current.left;
//            }
//        }
    }

    public void delete(T key) {
        this.root = deleteRecursively(this.root, key);
    }
    private Node<T,E> searchKey(Node<T,E> current, T key) {
        if(current == null || key.compareTo(current.getKey()) == 0) {
            return current;
        }
        else if(key.compareTo(current.getKey()) < 0) {
            return searchKey(current.left, key);
        }
        else return searchKey(current.right, key);
    }
    private Node<T,E> deleteRecursively(Node<T,E> node, T key) {
        if(node == null) return node;
        if(key.compareTo(node.getKey()) > 0){
            node.right = deleteRecursively(node.right, key);
        }
        else if(key.compareTo(node.getKey()) < 0){
            node.left = deleteRecursively(node.left, key);
        }
        else{
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;

            Node<T,E> temp = node.right;
            T minVal = node.right.getKey();
            while(temp.left != null){
                minVal = temp.left.getKey();
                temp = temp.left;
            }
            node.setKey(minVal);
            node.setValue(searchKey(node,minVal).getValue());
            node.right = deleteRecursively(node.right, minVal);
        }
        return node;
    }

    public void printBST(){
        Queue<Node<T,E>> queue = new LinkedList<>();
        Node<T,E> current = this.root;
        queue.offer(current);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node<T,E> temp = current;
            for(int i = 0; i < size; i++){
                temp = queue.poll();
                System.out.print("["+temp.getKey() + ", "+temp.getValue() + "]");
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
            System.out.println();
        }
    }
}
